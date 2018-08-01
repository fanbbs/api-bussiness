package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Station;
import com.company.project.model.StationUserDetail;
import com.company.project.service.StationUserDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/05/15.
*/
@RestController
@RequestMapping("/station/user/detail")
public class StationUserDetailController {
    @Resource
    private StationUserDetailService stationUserDetailService;

    @PostMapping
    public Result add(@RequestBody StationUserDetail stationUserDetail) {
        stationUserDetailService.save(stationUserDetail);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        stationUserDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody StationUserDetail stationUserDetail) {
        stationUserDetailService.update(stationUserDetail);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        StationUserDetail stationUserDetail = stationUserDetailService.findById(id);
        return ResultGenerator.genSuccessResult(stationUserDetail);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StationUserDetail> list = stationUserDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findAny")
    public Result findAny(@RequestParam(defaultValue = "0") Integer page,
                          @RequestParam(defaultValue = "20") Integer size,
                          @RequestParam(defaultValue = "20180321") Integer dataTime,
                          @RequestParam(defaultValue = "'哈尔滨市'") String eparchyName,
                          @RequestParam(defaultValue = "'南岗区'") String cityName,
                          @RequestParam(defaultValue = "1") Integer areaType,
                          @RequestParam(defaultValue = "'4G'") String netType,
                          @RequestParam(defaultValue = "0") Integer state,
                          @RequestParam(defaultValue = "0") Integer userLow,
                          @RequestParam(defaultValue = "9999999") Integer userUp
    ){
        PageHelper.startPage(page, size);
        Condition condition = new Condition(Station.class);
        condition.createCriteria().andCondition(
                " DATA_TIME = " + dataTime + "\n" +
                        " and EPARCHY_NAME = " + eparchyName + "\n" +
                        " and CITY_NAME = " + cityName + "\n" +
                        " and STATION_ATTR = " + areaType + "\n" +
                        " and NET_TYPE_CODE = " + netType + "\n" +
                        " and STATE = " + state + "\n" +
                        " and USER_CNT >= " + userLow + "\n" +
                        " and USER_CNT <= " + userUp + "\n"

        );
        List<StationUserDetail> list = stationUserDetailService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }


    @GetMapping("/findByIdsDate")
    public Result findAny(
                          @RequestParam(defaultValue = "20180321") Integer dataTime,
                          @RequestParam(defaultValue = "") String ids
    ){
        Condition condition = new Condition(Station.class);
        condition.createCriteria().andCondition(
                " DATA_TIME = " + dataTime + "\n" +
                        " and STATION_ID in ( " + ids + " )\n"
        );
        List<StationUserDetail> list = stationUserDetailService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
