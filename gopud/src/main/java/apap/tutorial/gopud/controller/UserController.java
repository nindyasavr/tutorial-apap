package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.RoleService;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        String pass = user.getPassword();
        model.addAttribute("listRole", roleService.findAll());
        if (userService.checkPassword(pass)) {
            userService.addUser(user);
            model.addAttribute("pesan", "");
            return "home";
        }
//        Boolean digit = false;
//        Boolean huruf = false;
//        if (pass.length() < 8) {
//            return "password-invalid";
//        }
//        for (int i = 0; i < pass.length(); i++) {
//            if (Character.isDigit(pass.charAt(i))) {
//                digit = true;
//            }
//            if (Character.isLowerCase(pass.charAt(i))) {
//                huruf = true;
//            }
//        }
//        if (digit == false || huruf == false) {
//            return "password-invalid";
//        }
        model.addAttribute("pesan", "Invalid Password");
        return "home";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(@ModelAttribute UserModel userUpdated, String oldPassword, String newPassword, String confirmPassword, Model model) {
        UserModel existUser = userService.getUserByUsername(userUpdated.getUsername());
        String pesan = "";
        model.addAttribute("listRole", roleService.findAll());
        if (!userService.isMatch(oldPassword, existUser.getPassword())) {
            pesan = "update password gagal";
            model.addAttribute("pesan", pesan);
            return "home";
        }
        if (!newPassword.equals(confirmPassword)) {
            pesan = "update password gagal";
            model.addAttribute("pesan", pesan);
            return "home";
        }
        if (!userService.checkPassword(newPassword)) {
            pesan = "update password gagal";
            model.addAttribute("pesan", pesan);
            return "home";
        }
        existUser.setPassword(newPassword);
        userService.addUser(existUser);
        model.addAttribute("pesan", pesan);
        return "home";
    }


}
