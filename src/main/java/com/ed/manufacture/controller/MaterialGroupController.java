package com.ed.manufacture.controller;

import com.ed.manufacture.entity.MaterialGroup;
import com.ed.manufacture.service.MaterialGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MaterialGroupController {

    @Autowired
    MaterialGroupService materialGroupService;

    @GetMapping("/login")
    String login(){
        return "login";
    }
    @RequestMapping(method = RequestMethod.GET)
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("materialgroup");
        modelAndView.addObject("materialgroups", materialGroupService.getMaterialGroups());
        return modelAndView;
    }

    @RequestMapping(value = "materialgroup", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView addStudent(@RequestParam String name) throws Exception {

        ModelAndView modelAndView = new ModelAndView("materialgroup");

        try {
            MaterialGroup materialGroup = new MaterialGroup();
            materialGroup.setName(name);
            materialGroup = materialGroupService.addMaterialGroup(materialGroup);
            modelAndView.addObject("message", "Material group added with name: " + materialGroup.getName());
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add Material group: " + ex.getMessage());
        }
        modelAndView.addObject("materialgroups", materialGroupService.getMaterialGroups());
        return modelAndView;
    }

    @RequestMapping(value = "materialgroup/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    String deleteMaterialGroup(@PathVariable("id") int id)
    {
        materialGroupService.delMaterialGroup(id);
        return "redirect:/";
    }

}
