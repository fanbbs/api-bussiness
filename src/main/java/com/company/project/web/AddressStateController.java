package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Address;
import com.company.project.model.AddressState;
import com.company.project.service.AddressStateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/02/08.
*/
@RestController
@RequestMapping("/address/state")
public class AddressStateController {
    @Resource
    private AddressStateService addressStateService;

    @PostMapping
    public Result add(@RequestBody AddressState addressState) {
        addressStateService.save(addressState);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        addressStateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody AddressState addressState) {
        addressStateService.update(addressState);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        AddressState addressState = addressStateService.findById(id);
        return ResultGenerator.genSuccessResult(addressState);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<AddressState> list = addressStateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findStatByIds/{addrids}")
    public Result findChildrensByAddressID(@PathVariable String addrids) {
        List<AddressState> list = addressStateService.findByIds(addrids);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/findOneStatByIds/{addrids}")
    public Result findOneStatByIds(@PathVariable String addrids) {
        Condition statCondition = new Condition(AddressState.class);
        statCondition.createCriteria().andCondition(
                " ADDRESS_ID IN ( " + addrids + " )\n" +
                        " AND ROWNUM = 1 "
        );
        statCondition.setOrderByClause("ADDRESS_ID desc");
        List<AddressState> list = addressStateService.findByCondition(statCondition);
        return ResultGenerator.genSuccessResult(list.get(0));
    }

}
