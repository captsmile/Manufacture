package com.ed.manufacture.dao;

import com.ed.manufacture.entity.MaterialGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialGroupRepository extends CrudRepository<MaterialGroup, Integer> {
}
