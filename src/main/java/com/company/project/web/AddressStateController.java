package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.AddressState;
import com.company.project.service.AddressStateService;
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
* Created by CodeGenerator on 2018/02/08.
*/
@RestController
@RequestMapping("/address/state")
@Api(tags = "地址统计信息")

public class AddressStateController {
    @Resource
    private AddressStateService addressStateService;

    @PostMapping
    @ApiOperation(value="增加地址统计", notes="增加地址统计")
    @ApiImplicitParam(name = "addressState", value = "地址统计对象", dataType = "AddressState")
    public Result add(@RequestBody AddressState addressState) {
        addressStateService.save(addressState);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="删除地址统计", notes="按照地址标识删除地址统计")
    @ApiImplicitParam(name = "id", value = "地址标识",dataType = "Integer")
    public Result delete(@PathVariable Integer id) {
        addressStateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value="修改地址统计信息", notes="修改地址统计信息")
    @ApiImplicitParam(name = "addressState", value = "地址统计对象", dataType = "AddressState")
    public Result update(@RequestBody AddressState addressState) {
        addressStateService.update(addressState);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="查询地址统计信息", notes="按照地址标识查询地址统计信息")
    @ApiImplicitParam(name = "id", value = "地址标识",dataType = "Integer")
    public Result detail(@PathVariable Integer id) {
        AddressState addressState = addressStateService.findById(id);
        return ResultGenerator.genSuccessResult(addressState);
    }

    @GetMapping
    @ApiOperation(value="查找地址统计列表，分页显示", notes="查找地址统计列表，分页显示")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "页内条数", dataType = "Integer")})
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<AddressState> list = addressStateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findStatByIds/{addrids}")
    @ApiOperation(value="查询一些地址统计信息", notes="按照输入的若干地址标识查询地址统计信息")
    @ApiImplicitParam(name = "addrids", value = "批量地址标识",dataType = "String")
    public Result findChildrensByAddressID(@PathVariable String addrids) {
        List<AddressState> list = addressStateService.findByIds(addrids);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/findOneStatByIds/{addrids}")
    @ApiOperation(value="查询一条地址统计信息", notes="按照输入的若干地址标识查询地址统计信息")
    @ApiImplicitParam(name = "addrids", value = "批量地址标识",dataType = "String")
    public Result findOneStatByIds(@PathVariable String addrids) {
        Condition statCondition = new Condition(AddressState.class);
        statCondition.createCriteria().andCondition(
                " \"ADDRESS_ID\" IN ( " + addrids + " )\n"
        );
        statCondition.setOrderByClause("\"ADDRESS_ID\" desc");
        List<AddressState> list = addressStateService.findByCondition(statCondition);
        return ResultGenerator.genSuccessResult(list.get(0));
    }

}
