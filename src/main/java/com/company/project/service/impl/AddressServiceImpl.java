package com.company.project.service.impl;

import com.company.project.dao.AddressMapper;
import com.company.project.model.Address;
import com.company.project.service.AddressService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/02/08.
 */
@Service
@Transactional
public class AddressServiceImpl extends AbstractService<Address> implements AddressService {
    @Resource
    private AddressMapper djbAddressMapper;

    public List<Address> selectPcartAddress() {
        return djbAddressMapper.selectPcartAddress();
    }

}
