package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Station;
import com.company.project.model.StationUserDetail;
import com.company.project.service.StationUserDetailService;
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
import java.util.List;

/**
* Created by CodeGenerator on 2018/05/15.
*/
@RestController
@RequestMapping("/station/user/detail")
@Api(tags = "基站用户明细信息")
public class StationUserDetailController {
    @Resource
    private StationUserDetailService stationUserDetailService;

    @PostMapping
    @ApiIgnore
    public Result add(@RequestBody StationUserDetail stationUserDetail) {
        stationUserDetailService.save(stationUserDetail);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiIgnore
    public Result delete(@PathVariable Integer id) {
        stationUserDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiIgnore
    public Result update(@RequestBody StationUserDetail stationUserDetail) {
        stationUserDetailService.update(stationUserDetail);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiIgnore
    public Result detail(@PathVariable Integer id) {
        StationUserDetail stationUserDetail = stationUserDetailService.findById(id);
        return ResultGenerator.genSuccessResult(stationUserDetail);
    }

    @GetMapping
    @ApiIgnore
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StationUserDetail> list = stationUserDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findAny")
    @ApiOperation(value="任意查找", notes="根据任意条件查找基站明细")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "页内条数", dataType = "Integer"),
            @ApiImplicitParam(name = "dataTime", value = "日期", dataType = "Integer"),
            @ApiImplicitParam(name = "eparchyName", value = "本地网", dataType = "String"),
            @ApiImplicitParam(name = "cityName", value = "区县", dataType = "String"),
            @ApiImplicitParam(name = "areaType", value = "区域类别", dataType = "Integer"),
            @ApiImplicitParam(name = "netType", value = "网别", dataType = "String"),
            @ApiImplicitParam(name = "state", value = "状态", dataType = "Integer"),
            @ApiImplicitParam(name = "userLow", value = "最少用户", dataType = "Integer"),
            @ApiImplicitParam(name = "userUp", value = "最多用户", dataType = "Integer")
    })
    public Result findAny(@RequestParam(defaultValue = "0") Integer page,
                          @RequestParam(defaultValue = "20") Integer size,
                          @RequestParam(defaultValue = "20180321") Integer dataTime,
                          @RequestParam(defaultValue = "'哈尔滨市'") String eparchyName,
                          @RequestParam(defaultValue = "'南岗区'") String cityName,
                          @RequestParam(defaultValue = "'1'") String areaType,
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
    @ApiOperation(value="查找一些基站指定日期的信息", notes="查找一些基站指定日期的信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "dataTime", value = "日期", dataType = "Integer"),
            @ApiImplicitParam(name = "ids", value = "基站标识串", dataType = "String"),
    })
    public Result findByIdsDate(
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
