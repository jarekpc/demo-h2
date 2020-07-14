package com.example.demoh2.controller;

import com.example.demoh2.config.Support;
import com.example.demoh2.entity.User;
import com.example.demoh2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class HomeController {

    private final UserService userService;


    @Value("${dane.wejsciowe.1}")
    private String dane;

    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "index";
    }

    @PostMapping("/users")
    public String createUser(User user){
        log.info("save user " + user);
        userService.saveUser(user);
        return "users";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

//    private void findUser(String name, Integer id) {
//        User user = userService.findNameAndId(name, id);
//        log.info("Found user: " + user);
//    }

    private void prepareUser() {
        log.info("Save user!");
//        User user = new User(1, "Jarek", "jarekpc@o2.pl", LocalDate.now(), false);
        User user = new User();
//        Set<Address> addressSet = new HashSet<>();
//        addressSet.add(new Address());
//        user.setAddreses(addressSet);
        userService.saveUser(user);
    }
}
