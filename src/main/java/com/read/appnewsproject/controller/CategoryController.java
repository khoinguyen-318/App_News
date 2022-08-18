package com.read.appnewsproject.controller;

import com.read.appnewsproject.dto.CategoryDTO;
import com.read.appnewsproject.services.impl.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController extends ParentController{
    @Autowired
    private CategoryServices services;

    @GetMapping("/category")
    public String getAllCategory(Model model,
                                 @RequestParam(required = false,defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "10",required = false) Integer size){
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("listCategory",services.listAll(pageable));
        return "category/categoryManagement";
    }
    @GetMapping("/category/addNewCategory")
    public String showAddNewForm(Model model){
        model.addAttribute("category",new CategoryDTO());
        return "category/addNewForm";
    }
    @PostMapping("/category/addNewCategory")
    public String process(@ModelAttribute("category") CategoryDTO categoryDTO){
        services.addNewCategory(categoryDTO);
        return "redirect:/admin/category";
    }
    @GetMapping("/category/delete/{id}")
    public String processDeleted(@PathVariable(name = "id") Long id){
        services.deleteCategory(id);
        return "redirect:/admin/category";
    }
    @GetMapping("/category/update/{id}")
    public String showFormUpdate(@PathVariable(name = "id") Long id,Model model){
        model.addAttribute("category",services.findById(id));
        return "category/formUpdate";
    }
    @PostMapping("/category/update")
    public String processUpdate(@ModelAttribute("category") CategoryDTO categoryDTO){
        services.updateCategory(categoryDTO, categoryDTO.getId());
        return "redirect:/admin/category";
    }
}
