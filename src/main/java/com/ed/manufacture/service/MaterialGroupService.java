package com.ed.manufacture.service;

import com.ed.manufacture.dao.MaterialGroupRepository;
import com.ed.manufacture.entity.MaterialGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialGroupService {

    @Autowired
    MaterialGroupRepository materialGroupRepository;

    public MaterialGroup addMaterialGroup(MaterialGroup materialGroup){
        materialGroupRepository.save(materialGroup);
        return materialGroup;
    }

    public Iterable<MaterialGroup> getMaterialGroups(){
        return materialGroupRepository.findAll();
    }
}
