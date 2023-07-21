package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAo.UserDAO;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;
    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public String GetAllUser(Model model){
        // Получаем весь список User
        model.addAttribute("user",userDAO.GetAll());
        return "/users/user";
    }
    @GetMapping("/{id}")
    public String Show(@PathVariable("id") int id, Model model){
    // получаем User по Id
        model.addAttribute("user",userDAO.GetUser(id));
    return "users/show";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "/user/new";

    }
    @PostMapping()
    public  String createUser(@ModelAttribute("user") User user){
        userDAO.save(user);
        return "redirect:/users/users";
    }

}
