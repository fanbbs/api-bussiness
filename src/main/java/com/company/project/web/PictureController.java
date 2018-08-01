package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Picture;
import com.company.project.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/02/07.
*/
@RestController
@RequestMapping("/picture")
public class PictureController {
    @Resource
    private PictureService pictureService;
    private Condition condition;

    @PostMapping
    public Result add(@RequestBody Picture picture) {
        pictureService.save(picture);
        return ResultGenerator.genSuccessResult(picture.getPictureId());
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        pictureService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Picture picture) {
        pictureService.update(picture);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Picture picture = pictureService.findById(id);
        return ResultGenerator.genSuccessResult(picture);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Picture> list = pictureService.findAll();
        PageInfo<Picture> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findByAddressID/{addrid}")
    public Result findByAddressID(@PathVariable Integer addrid) {
        Condition condition = new Condition(Picture.class);
        condition.createCriteria().andCondition(
                "ADDRESS_ID = " + addrid );
        condition.setOrderByClause("ADDRESS_ID desc");
        List<Picture> list = pictureService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/findByAddressIDs/{addrids}")
    public Result findByAddressIDs(@PathVariable String addrids) {
        Condition condition = new Condition(Picture.class);
        condition.createCriteria().andCondition(
                "ADDRESS_ID in ( " + addrids + " )");
        condition.setOrderByClause("ADDRESS_ID desc");
        List<Picture> list = pictureService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

}
