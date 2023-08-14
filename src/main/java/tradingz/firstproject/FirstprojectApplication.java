package tradingz.firstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tradingz.firstproject.controllers.UserController;
@SpringBootApplication
public class FirstprojectApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(FirstprojectApplication.class, args);
    }
}
