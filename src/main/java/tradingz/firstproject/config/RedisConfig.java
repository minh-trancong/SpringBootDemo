package tradingz.firstproject.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {
    @Autowired
    private Environment environment;

    @Value("${cache.redis.host}")
    private String redisHost;
    @Value("${cache.redis.port}")
    private int redisPort;
    @Value("${cache.redis.time-to-live}")
    private long redisCacheTtl;
    @Value("${cache.redis.use-ssl}")
    private boolean useSSL;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(Duration.ofSeconds(10)).build();
        ClientOptions clientOptions = ClientOptions.builder()
                .socketOptions(socketOptions)
                .autoReconnect(true)
                .disconnectedBehavior(ClientOptions.DisconnectedBehavior.REJECT_COMMANDS)
                .build();

        LettuceClientConfiguration.LettuceClientConfigurationBuilder clientConfigBuilder =
                LettuceClientConfiguration.builder()
                        .commandTimeout(Duration.ofSeconds(10))
                        .clientOptions(clientOptions);

        if (useSSL) clientConfigBuilder.useSsl();

        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
        redisConf.setHostName(redisHost);
        redisConf.setPort(redisPort);
        redisConf.setUsername(environment.getProperty("cache.redis.username"));
        redisConf.setPassword(environment.getProperty("cache.redis.password"));

        return new LettuceConnectionFactory(redisConf, clientConfigBuilder.build());
    }

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMillis(redisCacheTtl))
                .disableCachingNullValues();
    }

    @Bean
    public RedisCacheManager cacheManager() {
        return RedisCacheManager.builder(redisConnectionFactory())
                .cacheDefaults(cacheConfiguration())
                //.transactionAware()
                .build();
    }

    @Bean
    @Primary
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericToStringSerializer<>(String.class));
        return template;
    }
}
