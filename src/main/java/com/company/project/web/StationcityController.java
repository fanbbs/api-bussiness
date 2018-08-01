package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Stationcity;
import com.company.project.service.StationcityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
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
public class StationcityController {
    @Resource
    private StationcityService stationcityService;

    @PostMapping
    public Result add(@RequestBody Stationcity stationcity) {
        stationcityService.save(stationcity);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        stationcityService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Stationcity stationcity) {
        stationcityService.update(stationcity);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Stationcity stationcity = stationcityService.findById(id);
        return ResultGenerator.genSuccessResult(stationcity);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Stationcity> list = stationcityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @GetMapping("/bydata")
    public Result listBydate(@RequestParam(defaultValue = "20180408") String data_time, @RequestParam(defaultValue = "0097") String parent_city_code){

        Condition condition = new Condition(Stationcity.class);
        condition.createCriteria().andCondition(
                "data_time = " + data_time + "\n" +
                        "and parent_city_code = " + parent_city_code
        );
        condition.setOrderByClause("city_code asc");
        List<Stationcity> list = stationcityService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
