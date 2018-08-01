package com.company.project.service.impl;

import com.company.project.dao.StationstatMapper;
import com.company.project.model.Stationstat;
import com.company.project.service.StationstatService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/09.
 */
@Service
@Transactional
public class StationstatServiceImpl extends AbstractService<Stationstat> implements StationstatService {
    @Resource
    private StationstatMapper t2i2cEparchyUserStaionMapper;

}
