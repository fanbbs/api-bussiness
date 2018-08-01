package com.company.project.service.impl;

import com.company.project.dao.AddressStateMapper;
import com.company.project.model.AddressState;
import com.company.project.service.AddressStateService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/08.
 */
@Service
@Transactional
public class AddressStateServiceImpl extends AbstractService<AddressState> implements AddressStateService {
    @Resource
    private AddressStateMapper repAddrInfoSaleMapper;

}
