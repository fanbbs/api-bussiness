package com.company.project.service.impl;

import com.company.project.dao.PictureMapper;
import com.company.project.model.Picture;
import com.company.project.service.PictureService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/07.
 */
@Service
@Transactional
public class PictureServiceImpl extends AbstractService<Picture> implements PictureService {
    @Resource
    private PictureMapper pictureMapper;


}
