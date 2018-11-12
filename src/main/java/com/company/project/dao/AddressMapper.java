package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Address;

import java.util.List;

public interface AddressMapper extends Mapper<Address> {
    List<Address> selectPcartAddress();
}