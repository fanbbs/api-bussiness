package com.company.project.service.impl;

import com.company.project.dao.StationcityMapper;
import com.company.project.model.Stationcity;
import com.company.project.service.StationcityService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/11.
 */
@Service
@Transactional
public class StationcityServiceImpl extends AbstractService<Stationcity> implements StationcityService {
    @Resource
    private StationcityMapper t2i2cStaffCityMapper;

}
