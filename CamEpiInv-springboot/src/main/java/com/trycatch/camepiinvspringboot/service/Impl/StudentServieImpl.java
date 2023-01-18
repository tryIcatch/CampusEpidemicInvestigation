package com.trycatch.camepiinvspringboot.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trycatch.camepiinvspringboot.Dao.StudentDao;
import com.trycatch.camepiinvspringboot.entity.DateNum;
import com.trycatch.camepiinvspringboot.entity.HealthNum;
import com.trycatch.camepiinvspringboot.entity.Student;
import com.trycatch.camepiinvspringboot.entity.Teacher;
import com.trycatch.camepiinvspringboot.service.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServieImpl extends ServiceImpl<StudentDao, Student> implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
        public List<Student>  getByUsername(String username) {
        QueryWrapper<Student> qw1 = new QueryWrapper<>();
        qw1.like("username","zs");
        return studentDao.selectList(qw1);
    }

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        studentDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize, Student student) {
        QueryWrapper<Student> lqw = new QueryWrapper<>();
        lqw.like(Strings.isNotEmpty(student.getName()),"name",student.getName());
        lqw.like(Strings.isNotEmpty(student.getNumber()),"number",student.getNumber());
        lqw.like(Strings.isNotEmpty(student.getPhonenumber()),"phonenumber",student.getPhonenumber());
        lqw.like(Strings.isNotEmpty(student.getHealth()),"health",student.getHealth());
        lqw.like(Strings.isNotEmpty(student.getTemperature()),"temperature",student.getTemperature());
        IPage page = new Page(currentPage,pageSize);
        studentDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public List<DateNum> getCountByDate() {
        List<DateNum> dateNums=studentDao.getDateNum();
        return dateNums;
    }

    @Override
    public List<HealthNum> getHealthNum() {
        List<HealthNum> healths= studentDao.getHealthNum();
        return healths;
    }

    @Override
    public boolean updateByUsername(String username,String password) {
        return  studentDao.updateByUsername(username,password);
    }
}
