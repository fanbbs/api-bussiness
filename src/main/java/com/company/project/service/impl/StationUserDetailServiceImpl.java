package com.company.project.service.impl;

import com.company.project.dao.StationUserDetailMapper;
import com.company.project.model.StationUserDetail;
import com.company.project.service.StationUserDetailService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/15.
 */
@Service
@Transactional
public class StationUserDetailServiceImpl extends AbstractService<StationUserDetail> implements StationUserDetailService {
    @Resource
    private StationUserDetailMapper vStationUserDetailMapper;

}
