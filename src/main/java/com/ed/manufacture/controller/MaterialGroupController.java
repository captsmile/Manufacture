package com.ed.manufacture.controller;

import com.ed.manufacture.entity.MaterialGroup;
import com.ed.manufacture.service.MaterialGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MaterialGroupController {

    @Autowired
    MaterialGroupService materialGroupService;

    @RequestMapping(method = RequestMethod.GET)
    String home() {
        return "material";
    }

    @RequestMapping(value = "student", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView addStudent(@RequestParam String name) throws Exception {

        ModelAndView modelAndView = new ModelAndView("material");
        try {
            MaterialGroup materialGroup = new MaterialGroup();
            materialGroup.setName(name);
            materialGroup = materialGroupService.addMaterialGroup(materialGroup);
            modelAndView.addObject("message", "Material group added with name: " + materialGroup.getName());
        }
        catch (Exception ex){
            modelAndView.addObject("message", "Failed to add Material group: " + ex.getMessage());
        }
        modelAndView.addObject("students", materialGroupService.getMaterialGroups());
        return modelAndView;
    }
}
