package com.company.project.service.impl;

import com.company.project.dao.StationMapper;
import com.company.project.model.Station;
import com.company.project.service.StationService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/02.
 */
@Service
@Transactional
public class StationServiceImpl extends AbstractService<Station> implements StationService {
    @Resource
    private StationMapper vStationHeatMapper;

}
