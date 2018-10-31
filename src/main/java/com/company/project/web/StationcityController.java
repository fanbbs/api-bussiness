package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Stationcity;
import com.company.project.service.StationcityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/11.
*/
@RestController
@RequestMapping("/stationcity")
@Api(tags = "基站统计，按照区域汇总的基站信息和TITC用户统计")
public class StationcityController {
    @Resource
    private StationcityService stationcityService;

    @PostMapping
    @ApiIgnore
    public Result add(@RequestBody Stationcity stationcity) {
        stationcityService.save(stationcity);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiIgnore
    public Result delete(@PathVariable Integer id) {
        stationcityService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiIgnore
    public Result update(@RequestBody Stationcity stationcity) {
        stationcityService.update(stationcity);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiIgnore
    public Result detail(@PathVariable Integer id) {
        Stationcity stationcity = stationcityService.findById(id);
        return ResultGenerator.genSuccessResult(stationcity);
    }

    @GetMapping
    @ApiIgnore
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Stationcity> list = stationcityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @GetMapping("/bydata")
    @ApiOperation(value="按照日期，区域查找统计信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "data_time", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "parent_city_code", value = "区域标识", dataType = "String")})
    public Result listBydate(@RequestParam(defaultValue = "20180408") Integer data_time, @RequestParam(defaultValue = "'0097'") String parent_city_code){

        Condition condition = new Condition(Stationcity.class);
        condition.createCriteria().andCondition(
                "\"DATA_TIME\" = " + data_time + "\n" +
                        "and \"PARENT_CITY_CODE\" = " + parent_city_code
        );
        condition.setOrderByClause("\"CITY_CODE\" asc");
        List<Stationcity> list = stationcityService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
