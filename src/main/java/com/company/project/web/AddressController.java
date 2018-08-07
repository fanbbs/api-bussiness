package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Address;
import com.company.project.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.gds.offset.CoordOffset;

/**
* Created by CodeGenerator on 2018/02/08.
*/
@RestController
@RequestMapping("/address")
@Api(tags = "标准地址维护，查询")

public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping
    @ApiOperation(value="增加地址", notes="增加地址")
    @ApiImplicitParam(name = "address", value = "地址对象", dataType = "Address")
    public Result add(@RequestBody Address address) {
        addressService.save(address);
        return ResultGenerator.genSuccessResult(address.getAddressId());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="按照地址id删除地址", notes="按照地址id删除地址")
    @ApiImplicitParam(name = "id", value = "地址id",dataType = "Integer")
    public Result delete(@PathVariable Integer id) {
        addressService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value="修改地址内容", notes="修改地址内容")
    @ApiImplicitParam(name = "address", value = "地址对象", dataType = "Address")
    public Result update(@RequestBody Address address) {
        addressService.update(address);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="按照地址id查找地址内容", notes="按照地址id查找地址内容")
    @ApiImplicitParam(name = "id", value = "地址id",dataType = "Integer")
    public Result detail(@PathVariable Integer id) {
        Address address = addressService.findById(id);
        return ResultGenerator.genSuccessResult(address);
    }

    @GetMapping
    @ApiOperation(value="查找地址列表，分页显示", notes="查找地址列表，分页显示")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "页内条数", dataType = "Integer")})
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Address> list = addressService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findChildrensByAddressID/{addrid}")
    @ApiOperation(value="查找指定地址下全部子地址", notes="根据输入的地址id查找当前地址下所有子地址")
    @ApiImplicitParam(name = "addrid", value = "地址id",dataType = "Integer")
    public Result findChildrensByAddressID(@PathVariable Integer addrid) {
        Condition condition = new Condition(Address.class);
        condition.createCriteria().andCondition(
                "ADDRESS_ID IN (\n" +
                            " with recursive t_result as ( " +
                            " select * from address where address_id= " + addrid + "\n" +
                            " union all " +
                            " select t2.* from t_result t1 join address t2 on t1.address_id=t2.up_geo_loc_id " +
                            " ) " +
                            " select address_id from t_result " +
                        " ) and addr_status_cd <> 2 " );
        condition.setOrderByClause("addr_type_cd,name desc");
        List<Address> list = addressService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/findNearbyCommunity/{addrids}")
    @ApiOperation(value="查找地址对应的小区", notes="查找输入的全部8级地址对应的6级地址")
    @ApiImplicitParam(name = "addrids", value = "地址标识列表逗号分隔",dataType = "String")
    public Result findNearbyCommunity(@PathVariable String addrids) {
        Condition communityCondition = new Condition(Address.class);
        communityCondition.createCriteria().andCondition(
                "ADDRESS_ID IN (SELECT UP_GEO_LOC_ID\n" +
                        "                        FROM ADDRESS\n" +
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
    @ApiOperation(value="查找地址对应的街路", notes="查找输入的全部8级地址对应的5级地址")
    @ApiImplicitParam(name = "addrids", value = "地址标识列表逗号分隔",dataType = "String")
    public Result findNearbyStreet(@PathVariable String addrids) {
        Condition communityCondition = new Condition(Address.class);
        communityCondition.createCriteria().andCondition(
                "address_id in\n" +
                        "       (select up_geo_loc_id\n" +
                        "          from address\n" +
                        "         where address_id in (select up_geo_loc_id\n" +
                        "                                from address\n" +
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

    @ApiOperation(value="地址纠偏", notes="输入gps采集的经纬度，转换成地图加密的经纬度")
    @ApiImplicitParams({@ApiImplicitParam(name = "x", value = "经度", dataType = "double"),
            @ApiImplicitParam(name = "y", value = "纬度", dataType = "double")})
    @GetMapping("/coord")
    public Result jiupian(@RequestParam(defaultValue = "0") double x, @RequestParam(defaultValue = "0") double y){
        Map result = jiupianSingle(x,y);
        return ResultGenerator.genSuccessResult(result);
    }

    @ApiIgnore
    private Map jiupianSingle(double x, double y) {
        String packFile;
        try {
            if (isOSLinux()) {
//                packFile = "/home/elkstack/app/springboot/locallib/packfile.dat";
                packFile = "/opt/lib/packfile.dat";
            }else {
                packFile = "D:\\app\\app\\locallib\\packfile.dat";
                packFile = packFile.replace("\\\\", "/");
            }
            CoordOffset coord = CoordOffset.getInstance(packFile, false);

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

    public static boolean isOSLinux() {
        Properties prop = System.getProperties();

        String os = prop.getProperty("os.name");
        if (os != null && os.toLowerCase().indexOf("linux") > -1) {
            return true;
        } else {
            return false;
        }
    }

    @ApiIgnore
    @GetMapping("/partfind")
    public Result partlist() {
        List<Address> list = addressService.selectPcartAddress();
        return ResultGenerator.genSuccessResult(list);
    }

}
