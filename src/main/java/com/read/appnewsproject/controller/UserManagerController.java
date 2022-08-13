package com.read.appnewsproject.controller;

import com.read.appnewsproject.dto.UserDTO;
import com.read.appnewsproject.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagerController extends ParentController{

    @Autowired
    private IUserServices services;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/admin-management")
    public String adminManagement(Model model,
                                  @RequestParam(required = false,defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "10",required = false) Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("listUser",services.getAllUser(pageable));
        return "usermanagement/adminManagement";
    }

    @GetMapping("/admin-management/add-new")
    public String addNewUser(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user",userDTO);
        return "usermanagement/form-add-new-user";
    }
    @PostMapping("/admin-management/add-new")
    public String processAddNewUser(@ModelAttribute("user") UserDTO userDTO){
        userDTO.setPassWord(passwordEncoder.encode(userDTO.getPassWord()));
        services.addNewAccount(userDTO);
        return "redirect:/admin/admin-management";
    }
    @GetMapping("/admin-management/delete/{id}")
    public String processDelete(@PathVariable(name = "id") Long id){
        services.deleteUser(id);
        return "redirect:/admin/admin-management";
    }
}
