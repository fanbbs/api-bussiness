package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Picture;
import com.company.project.model.Station;
import com.company.project.service.StationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/02.
*/
@RestController
@RequestMapping("/station")
@Api(tags = "基站信息")
public class StationController {
    @Resource
    private StationService stationService;

    @PostMapping
    @ApiIgnore
    public Result add(@RequestBody Station station) {
        stationService.save(station);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiIgnore
    public Result delete(@PathVariable Integer id) {
        stationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiIgnore
    public Result update(@RequestBody Station station) {
        stationService.update(station);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiIgnore
    public Result detail(@PathVariable Integer id) {
        Station station = stationService.findById(id);
        return ResultGenerator.genSuccessResult(station);
    }

    @GetMapping
    @ApiIgnore
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Station> list = stationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findByLatnid/{latnid}")
    @ApiOperation(value="查找地市所有基站", notes="查找地市所有基站")
    @ApiImplicitParam(name = "latnid", value = "地市标识", dataType = "String")
    public Result findByLatnid(@PathVariable String latnid) {
        Condition condition = new Condition(Station.class);
        condition.createCriteria().andCondition(
                "EPARCHY_CODE = '" + latnid + "'");
        List<Station> list = stationService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
