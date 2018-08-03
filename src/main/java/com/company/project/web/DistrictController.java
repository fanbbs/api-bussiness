package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.District;
import com.company.project.service.DistrictService;
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
* Created by CodeGenerator on 2018/07/31.
*/
@RestController
@RequestMapping("/district")
@Api(tags = "全国区县列表")
public class DistrictController {
    @Resource
    private DistrictService districtService;

    @PostMapping
    @ApiOperation(value="增加区县", notes="增加区县")
    @ApiImplicitParam(name = "district", value = "区县对象", dataType = "District")
    public Result add(@RequestBody District district) {
        districtService.save(district);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="按照区县id删除区县", notes="按照区县id删除区县")
    @ApiImplicitParam(name = "id", value = "区县id",dataType = "Integer")
    public Result delete(@PathVariable Integer id) {
        districtService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value="修改区县内容", notes="修改区县内容")
    @ApiImplicitParam(name = "district", value = "区县对象", dataType = "District")
    public Result update(@RequestBody District district) {
        districtService.update(district);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="按照区县id查找区县内容", notes="按照区县id查找区县内容")
    @ApiImplicitParam(name = "id", value = "区县id",dataType = "Integer")
    public Result detail(@PathVariable Integer id) {
        District district = districtService.findById(id);
        return ResultGenerator.genSuccessResult(district);
    }

    @GetMapping
    @ApiOperation(value="查找区县列表，分页显示", notes="查找区县列表，分页显示")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", dataType = "Integer"),
                        @ApiImplicitParam(name = "size", value = "页内条数", dataType = "Integer")})
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<District> list = districtService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findByLatnid/{latnid}")
    @ApiOperation(value="根据本地网区号查询区县列表", notes="根据本地网区号查询区县列表")
    @ApiImplicitParam(name = "latnid", value = "本地网区号",dataType = "String")
    public Result findByAddressID(@PathVariable String latnid) {
        Condition condition = new Condition(District.class);
        condition.createCriteria().andCondition(
                "EPARCHY_CODE = " + latnid );
        List<District> list = districtService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
