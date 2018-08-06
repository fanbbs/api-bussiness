package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Stationstat;
import com.company.project.service.StationstatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/09.
*/
@RestController
@RequestMapping("/stationstat")
@Api(tags = "基站统计，13地市TITC用户统计")
public class StationstatController {
    @Resource
    private StationstatService stationstatService;

    @PostMapping
    @ApiIgnore
    public Result add(@RequestBody Stationstat stationstat) {
        stationstatService.save(stationstat);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiIgnore
    public Result delete(@PathVariable Integer id) {
        stationstatService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiIgnore
    public Result update(@RequestBody Stationstat stationstat) {
        stationstatService.update(stationstat);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiIgnore
    public Result detail(@PathVariable Integer id) {
        Stationstat stationstat = stationstatService.findById(id);
        return ResultGenerator.genSuccessResult(stationstat);
    }

    @GetMapping
    @ApiOperation(value="查找统计列表，分页显示", notes="查找统计列表，分页显示")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "页内条数", dataType = "Integer")})
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Stationstat> list = stationstatService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
