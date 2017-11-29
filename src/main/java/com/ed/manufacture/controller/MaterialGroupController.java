package com.ed.manufacture.controller;

import com.ed.manufacture.entity.MaterialGroup;
import com.ed.manufacture.service.MaterialGroupService;
import com.ed.manufacture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MaterialGroupController {

    @Autowired
    MaterialGroupService materialGroupService;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("logins", userService.getAuthUsers());
        return modelAndView;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/")
    String dashboard(){
        return "dashboard";
    }

    @RequestMapping(value = {"/materialgroup"}, method = RequestMethod.GET)
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("materialgroup");
        modelAndView.addObject("materialgroups", materialGroupService.getMaterialGroups());
        return modelAndView;
    }

    @RequestMapping(value = {"/error"}, method = RequestMethod.GET)
    String error() {
        return "error";
    }

    @RequestMapping(value = "/materialgroup", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView addStudent(@RequestParam String name) throws Exception {

        ModelAndView modelAndView = new ModelAndView("materialgroup");

        try {
            MaterialGroup materialGroup = new MaterialGroup();
            materialGroup.setName(name);
            materialGroup = materialGroupService.addMaterialGroup(materialGroup);
            modelAndView.addObject("message", "Material group added with name: " + materialGroup.getName());
        } catch (Exception ex) {
            modelAndView.addObject("message", "Failed to add Material group: " + ex.getMessage());
        }
        modelAndView.addObject("materialgroups", materialGroupService.getMaterialGroups());
        return modelAndView;
    }

    @RequestMapping(value = "/materialgroup/{id}", method = RequestMethod.GET)
    String deleteMaterialGroup(@PathVariable("id") int id) {
        materialGroupService.delMaterialGroup(id);
        return "redirect:/materialgroup";

    }

}
