package com.company.project.service;
import com.company.project.model.Address;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/02/08.
 */
public interface AddressService extends Service<Address> {
    List<Address> selectPcartAddress();

}
