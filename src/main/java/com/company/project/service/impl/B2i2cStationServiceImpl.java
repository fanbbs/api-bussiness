package com.company.project.service.impl;

import com.company.project.dao.B2i2cStationMapper;
import com.company.project.model.B2i2cStation;
import com.company.project.service.B2i2cStationService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/10/30.
 */
@Service
@Transactional
public class B2i2cStationServiceImpl extends AbstractService<B2i2cStation> implements B2i2cStationService {
    @Resource
    private B2i2cStationMapper t2i2cStationMapper;

}
