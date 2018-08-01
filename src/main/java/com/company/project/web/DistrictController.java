package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.District;
import com.company.project.service.DistrictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/07/31.
*/
@RestController
@RequestMapping("/district")
public class DistrictController {
    @Resource
    private DistrictService districtService;

    @PostMapping
    public Result add(@RequestBody District district) {
        districtService.save(district);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        districtService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody District district) {
        districtService.update(district);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        District district = districtService.findById(id);
        return ResultGenerator.genSuccessResult(district);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<District> list = districtService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findByLatnid/{latnid}")
    public Result findByAddressID(@PathVariable String latnid) {
        Condition condition = new Condition(District.class);
        condition.createCriteria().andCondition(
                "EPARCHY_CODE = " + latnid );
        List<District> list = districtService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
