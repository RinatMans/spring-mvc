package web.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.dao.UsersDAO;
import web.models.User;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersDAO usersDAO;

    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

        @GetMapping()
    public String index(Model model){
        model.addAttribute("users", usersDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("users", usersDAO.index());
        model.addAttribute("user", usersDAO.show(id));
        return "users/index";
    }
    @GetMapping("new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        usersDAO.save(user);

        return "redirect:/users";
    }
}