package tradingz.firstproject.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import tradingz.firstproject.models.User;
import tradingz.firstproject.repositories.UserRepository;
import org.springframework.stereotype.Controller;

import javax.persistence.Id;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository;
    public UserController(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private RedisTemplate<String, String> userTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @QueryMapping
    public Iterable<User> allUsers() throws JsonProcessingException {
        Iterable<User> users = userRepository.findAll();
        for (User user : users){
            userTemplate.opsForValue().set("user"+user.getUserID().toString(), objectMapper.writeValueAsString(user));
        }
        return userRepository.findAll();
    }
    @MutationMapping
    public User newUser(@Argument("name") String name, @Argument("email") String email, @Argument("phoneNumber") String phoneNumber) throws JsonProcessingException {
        User user = new User(name, email, phoneNumber);
        userRepository.save(user);
        userTemplate.opsForValue().set("user"+user.getUserID().toString(), objectMapper.writeValueAsString(user));
        return user;
    }

    @QueryMapping
    public User userById (@Argument Integer id) throws JsonProcessingException {
        String userJson = userTemplate.opsForValue().get("user"+id);
        User user = null;
        if (userJson == null){
            user = userRepository.findById(id).orElse(null);
            userTemplate.opsForValue().set("user"+id, objectMapper.writeValueAsString(user));
        } else {
            user = objectMapper.readValue(userJson, User.class);
        }
        return user;
    }

}






