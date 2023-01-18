package com.trycatch.camepiinvspringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trycatch.camepiinvspringboot.entity.DateNum;
import com.trycatch.camepiinvspringboot.entity.HealthNum;
import com.trycatch.camepiinvspringboot.entity.Student;

import java.util.List;

public interface StudentService  extends IService<Student> {

    public List<Student> getByUsername(String username);

    IPage<Student> getPage(int currentPage, int pageSize);

    IPage<Student> getPage(int currentPage, int pageSize, Student student);

    public List<DateNum> getCountByDate();

    public List<HealthNum> getHealthNum();

    public boolean updateByUsername(String username,String password);
}