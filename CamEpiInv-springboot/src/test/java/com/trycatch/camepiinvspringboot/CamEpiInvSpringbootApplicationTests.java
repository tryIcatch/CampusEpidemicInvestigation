package com.trycatch.camepiinvspringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trycatch.camepiinvspringboot.Dao.StudentDao;
import com.trycatch.camepiinvspringboot.Dao.TeacherDao;
import com.trycatch.camepiinvspringboot.entity.Student;
import com.trycatch.camepiinvspringboot.entity.Teacher;
import com.trycatch.camepiinvspringboot.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CamEpiInvSpringbootApplicationTests {

    @Autowired
    private TeacherDao teacherDao;

    @Test
    void contextLoads() {
        QueryWrapper<Teacher> qw = new QueryWrapper<>();
        qw.like("username","zs");
        teacherDao.selectList(qw);
    }


    @Autowired
    private StudentDao studentDao;
    @Test
    void test(){
        QueryWrapper<Student> qw1 = new QueryWrapper<>();
        qw1.like("username","zs");
        System.out.println(studentDao.selectList(qw1));

    }

    @Autowired
    private  StudentService studentService;

    @Test
    void getall(){
        System.out.println(studentService.list());
    }

    @Test
    void getpage(){
        IPage<Student> page=studentService.getPage(1,5);
    }

    @Test
    void getDateNum(){

        System.out.println(studentDao.getDateNum());
    }
    @Test
    void getHealthNum(){

        System.out.println(studentDao.getHealthNum());
    }

    @Test
    void updateByUsername(){
        System.out.println(studentService.updateByUsername("zs","123"));
    }
}
