package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Address;
import com.company.project.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gds.offset.CoordOffset;

/**
* Created by CodeGenerator on 2018/02/08.
*/
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping
    public Result add(@RequestBody Address address) {
        addressService.save(address);
        return ResultGenerator.genSuccessResult(address.getAddressId());
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        addressService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Address address) {
        addressService.update(address);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Address address = addressService.findById(id);
        return ResultGenerator.genSuccessResult(address);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Address> list = addressService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findChildrensByAddressID/{addrid}")
    public Result findChildrensByAddressID(@PathVariable Integer addrid) {
        Condition condition = new Condition(Address.class);
        condition.createCriteria().andCondition(
                "ADDRESS_ID IN (\n" +
                        "SELECT ADDRESS_ID\n" +
                        "  FROM DJB_ADDRESS A\n" +
                        " START WITH A.ADDRESS_ID = " + addrid + "\n" +
                        " CONNECT BY PRIOR A.ADDRESS_ID = A.UP_GEO_LOC_ID\n" +
                        ") and addr_status_cd <> 2 " );
        condition.setOrderByClause("addr_type_cd,name desc");
        List<Address> list = addressService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/findNearbyCommunity/{addrids}")
    public Result findNearbyCommunity(@PathVariable String addrids) {
        Condition communityCondition = new Condition(Address.class);
        communityCondition.createCriteria().andCondition(
                "ADDRESS_ID IN (SELECT UP_GEO_LOC_ID\n" +
                        "                        FROM DJB_ADDRESS\n" +
                        "                       WHERE ADDR_TYPE_CD = 8\n" +
                        "                               and addr_status_cd <> 2\n" +
                        "                               and ADDRESS_ID in ( " + addrids + " ))\n" +
                                "   and addr_status_cd <> 2\n" +
        "   AND ADDR_TYPE_CD = 6" );
        communityCondition.setOrderByClause("ADDRESS_ID desc");
        List<Address> list = addressService.findByCondition(communityCondition);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/findNearbyStreet/{addrids}")
    public Result findNearbyStreet(@PathVariable String addrids) {
        Condition communityCondition = new Condition(Address.class);
        communityCondition.createCriteria().andCondition(
                "address_id in\n" +
                        "       (select up_geo_loc_id\n" +
                        "          from djb_address\n" +
                        "         where address_id in (select up_geo_loc_id\n" +
                        "                                from djb_address\n" +
                        "                               where addr_type_cd = 8\n" +
                        "                               and ADDRESS_ID in ( " + addrids + " ))\n" +
                        "           and addr_status_cd = 1\n" +
                        "           and addr_type_cd = 6)\n" +
                        "   and addr_status_cd = 1\n" +
                        "   and addr_type_cd = 5" );
        communityCondition.setOrderByClause("ADDRESS_ID desc");
        List<Address> list = addressService.findByCondition(communityCondition);
        return ResultGenerator.genSuccessResult(list);
    }


    @GetMapping("/coord")
    public Result jiupian(@RequestParam(defaultValue = "0") double x, @RequestParam(defaultValue = "0") double y){
        Map result = jiupianSingle(x,y);
        return ResultGenerator.genSuccessResult(result);
    }

    private Map jiupianSingle(double x, double y) {
        try {
            CoordOffset coord = CoordOffset.getInstance(
//                    "/home/elkstack/app/springboot/locallib/packfile.dat", false);
                    "/app/webapp/workorder/src/gisapi/lib/packfile.dat", false);


            double[] outXY = new double[2];
            coord.offsetCoord(x, y, outXY);

            Map mapResult = new HashMap();
            mapResult.put("x",outXY[0]);
            mapResult.put("y",outXY[1]);

            return mapResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("/partfind")
    public Result partlist() {
        List<Address> list = addressService.selectPcartAddress();
        return ResultGenerator.genSuccessResult(list);
    }

}
