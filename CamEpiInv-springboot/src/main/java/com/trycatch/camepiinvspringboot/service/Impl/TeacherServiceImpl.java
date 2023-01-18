package com.trycatch.camepiinvspringboot.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trycatch.camepiinvspringboot.Dao.TeacherDao;
import com.trycatch.camepiinvspringboot.entity.Teacher;
import com.trycatch.camepiinvspringboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl  extends ServiceImpl<TeacherDao,Teacher> implements TeacherService {

    @Autowired
    private  TeacherDao teacherDao;

    @Override
    public List<Teacher> getByUsername(String username) {
        QueryWrapper<Teacher> qw = new QueryWrapper<>();
        qw.like("username",username);
        return  teacherDao.selectList(qw);
    }
}
