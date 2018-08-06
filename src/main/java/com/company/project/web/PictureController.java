package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Picture;
import com.company.project.service.PictureService;
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
* Created by CodeGenerator on 2018/02/07.
*/
@RestController
@RequestMapping("/picture")
@Api(tags = "地址图片")
public class PictureController {
    @Resource
    private PictureService pictureService;
    private Condition condition;

    @PostMapping
    @ApiOperation(value="增加地址图片", notes="增加地址图片")
    @ApiImplicitParam(name = "picture", value = "增加地址图片对象", dataType = "Picture")
    public Result add(@RequestBody Picture picture) {
        pictureService.save(picture);
        return ResultGenerator.genSuccessResult(picture.getPictureId());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="按照图片标识删除地址图片", notes="按照图片标识删除地址图片")
    @ApiImplicitParam(name = "id", value = "图片标识",dataType = "Integer")
    public Result delete(@PathVariable Integer id) {
        pictureService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value="修改地址图片内容", notes="修改地址图片内容")
    @ApiImplicitParam(name = "picture", value = "地址图片对象", dataType = "Picture")
    public Result update(@RequestBody Picture picture) {
        pictureService.update(picture);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="按照图片标识查找地址图片内容", notes="按照图片标识查找地址图片内容")
    @ApiImplicitParam(name = "id", value = "图片标识",dataType = "Integer")
    public Result detail(@PathVariable Integer id) {
        Picture picture = pictureService.findById(id);
        return ResultGenerator.genSuccessResult(picture);
    }

    @GetMapping
    @ApiOperation(value="查找图片列表，分页显示", notes="查找图片列表，分页显示")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "页内条数", dataType = "Integer")})
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Picture> list = pictureService.findAll();
        PageInfo<Picture> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/findByAddressID/{addrid}")
    @ApiOperation(value="按照地址标识查找地址图片内容", notes="按照地址标识查找地址图片内容")
    @ApiImplicitParam(name = "addrid", value = "地址标识",dataType = "Integer")
    public Result findByAddressID(@PathVariable Integer addrid) {
        Condition condition = new Condition(Picture.class);
        condition.createCriteria().andCondition(
                "ADDRESS_ID = " + addrid );
        condition.setOrderByClause("ADDRESS_ID desc");
        List<Picture> list = pictureService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/findByAddressIDs/{addrids}")
    @ApiOperation(value="按照若干地址标识查找地址图片内容", notes="按照若干地址标识查找地址图片内容")
    @ApiImplicitParam(name = "addrids", value = "地址标识列表，逗号分隔",dataType = "String")
    public Result findByAddressIDs(@PathVariable String addrids) {
        Condition condition = new Condition(Picture.class);
        condition.createCriteria().andCondition(
                "ADDRESS_ID in ( " + addrids + " )");
        condition.setOrderByClause("ADDRESS_ID desc");
        List<Picture> list = pictureService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

}
