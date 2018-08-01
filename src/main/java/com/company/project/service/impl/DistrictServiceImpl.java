package com.company.project.service.impl;

import com.company.project.dao.DistrictMapper;
import com.company.project.model.District;
import com.company.project.service.DistrictService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/31.
 */
@Service
@Transactional
public class DistrictServiceImpl extends AbstractService<District> implements DistrictService {
    @Resource
    private DistrictMapper wyDistrictInfoMapper;

}
