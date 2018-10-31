package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.B2i2cStation;
import com.company.project.service.B2i2cStationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/10/30.
*/
@RestController
@RequestMapping("/b2i2c/station")
@Api(tags = "B2i2c基站维护，查询")
public class B2i2cStationController {
    @Resource
    private B2i2cStationService b2i2cStationService;

    @PostMapping
    @ApiOperation(value="增加B2i2c基站", notes="增加B2i2c基站")
    @ApiImplicitParam(name = "b2i2cStation", value = "B2i2c基站对象", dataType = "B2i2cStation")
    public Result add(@RequestBody B2i2cStation b2i2cStation) {
        b2i2cStationService.save(b2i2cStation);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="按照B2i2c基站id删除B2i2c基站", notes="按照B2i2c基站id删除B2i2c基站")
    @ApiImplicitParam(name = "id", value = "B2i2c基站id",dataType = "Integer")
    public Result delete(@PathVariable Integer id) {
        b2i2cStationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value="修改B2i2c基站", notes="修改B2i2c基站")
    @ApiImplicitParam(name = "b2i2cStation", value = "B2i2c基站对象", dataType = "B2i2cStation")
    public Result update(@RequestBody B2i2cStation b2i2cStation) {
        b2i2cStationService.update(b2i2cStation);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="查询B2i2c基站", notes="查询B2i2c基站")
    @ApiImplicitParam(name = "id", value = "B2i2c基站标识",dataType = "Integer")
    public Result detail(@PathVariable Integer id) {
        B2i2cStation b2i2cStation = b2i2cStationService.findById(id);
        return ResultGenerator.genSuccessResult(b2i2cStation);
    }

    @GetMapping
    @ApiOperation(value="查找B2i2c基站列表，分页显示", notes="查找B2i2c基站列表，分页显示")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", dataType = "Integer"), @ApiImplicitParam(name = "size", value = "页内条数", dataType = "Integer")})
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<B2i2cStation> list = b2i2cStationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findByLatnid/{datetime}/{latnid}")
    @ApiOperation(value="查找地市所有基站", notes="查找地市所有基站")
    @ApiImplicitParams({@ApiImplicitParam(name = "datetime", value = "统计日期", dataType = "Integer"),
            @ApiImplicitParam(name = "latnid", value = "地市标识", dataType = "String")})
    public Result findByLatnid(@PathVariable Integer datetime, @PathVariable String latnid) {
        Condition condition = new Condition(B2i2cStation.class);
        condition.createCriteria().andCondition(
                "\"DATA_TIME\" = " + datetime + "\n" +
                " AND \"EPARCHY_CODE\" = '" + latnid + "'"
        );
        List<B2i2cStation> list = b2i2cStationService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
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
                          @RequestParam(defaultValue = "20181010") Integer dataTime,
                          @RequestParam(defaultValue = "'哈尔滨市'") String eparchyName,
                          @RequestParam(defaultValue = "'南岗区'") String cityName,
                          @RequestParam(defaultValue = "'1'") String areaType,
                          @RequestParam(defaultValue = "'4G'") String netType,
                          @RequestParam(defaultValue = "0") Integer state,
                          @RequestParam(defaultValue = "0") Integer userLow,
                          @RequestParam(defaultValue = "9999999") Integer userUp
    ){
        PageHelper.startPage(page, size);
        Condition condition = new Condition(B2i2cStation.class);
        condition.createCriteria().andCondition(
                " \"DATA_TIME\" = " + dataTime + "\n" +
                        " and \"EPARCHY_NAME\" = " + eparchyName + "\n" +
                        " and \"CITY_NAME\" = " + cityName + "\n" +
                        " and \"STATION_ATTR\" = " + areaType + "\n" +
                        " and \"NET_TYPE_CODE\" = " + netType + "\n" +
                        " and \"STATE\" = " + state + "\n" +
                        " and \"USER_CNT\" >= " + userLow + "\n" +
                        " and \"USER_CNT\" <= " + userUp + "\n"

        );
        List<B2i2cStation> list = b2i2cStationService.findByCondition(condition);
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
        Condition condition = new Condition(B2i2cStation.class);
        condition.createCriteria().andCondition(
                " \"DATA_TIME\" = " + dataTime + "\n" +
                        " and \"STATION_ID\" in ( " + ids + " )\n"
        );
        List<B2i2cStation> list = b2i2cStationService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
