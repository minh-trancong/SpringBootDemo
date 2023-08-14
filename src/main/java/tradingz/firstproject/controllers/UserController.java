package tradingz.firstproject.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import tradingz.firstproject.models.User;
import tradingz.firstproject.repositories.UserRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository;
    public UserController(final UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @QueryMapping
    public Iterable<User> allUsers(){
        return userRepository.findAll();
    }
    @MutationMapping
    public User newUser(@Argument("name") String name, @Argument("email") String email, @Argument("phoneNumber") String phoneNumber){
        User user = new User(name, email, phoneNumber);
        userRepository.save(user);
        return user;
    }

}






