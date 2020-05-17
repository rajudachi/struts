package org.superbiz.struts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.superbiz.struts.data.UserRepository;
import org.superbiz.struts.model.User;

import java.util.Optional;


@RestController
@ComponentScan("org.superbiz.struts.model")
public class UsersController {

    //private final User user;

    @Autowired
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/addUser")
    public ModelAndView addUserForm() {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("addUserForm");
        return retVal;
    }

    @PostMapping("/addUser")
    public ModelAndView addUser(User user) {

        userRepository.save(user);
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("addedUser");
        return retVal;
    }

    @GetMapping("/findUser")
    public ModelAndView findUserForm() {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("findUserForm");
        return retVal;

    }

    @PostMapping("/findUser")
    public ModelAndView findUser(@RequestParam long id, Model model) {
        ModelAndView retVal = new ModelAndView();

        Optional<User> user = userRepository.findById(id);
        retVal.setViewName("displayUser");

        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("errorMessage", "User not found");
            retVal.setViewName("findUserForm");
        }
        return retVal;
    }


    @GetMapping("/list")
    public ModelAndView listUsers(Model model) {
        ModelAndView retVal = new ModelAndView();

        model.addAttribute("users", userRepository.findAll());
        retVal.setViewName("displayUsers");

        return retVal;
    }
}
