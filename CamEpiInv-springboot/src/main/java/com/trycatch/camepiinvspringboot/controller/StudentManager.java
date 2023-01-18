package com.trycatch.camepiinvspringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trycatch.camepiinvspringboot.entity.Student;
import com.trycatch.camepiinvspringboot.service.StudentService;
import com.trycatch.camepiinvspringboot.utils.R;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/home")
public class StudentManager {

    @Autowired
    private StudentService studentService;

    @PostMapping("/list")
    public R getAll(@RequestBody String token){
        if (token!=null)        return new R(true,studentService.list());
        else return new R(false,"登录过期，请重新登录");
    }
    @PostMapping("/save")
    public R save(@RequestBody Student student){
        if(student.getUsername()==null || student.getPassword()==null){
            student.setUsername(student.getName());
            student.setPassword("123456");
        }
        Date date = new Date();
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        student.setDate(dateFormat.format(date));
        return new R(studentService.save(student));
    }

    @GetMapping("/update/{id}")
    public R getById(@PathVariable Integer id ){
        return new R(true,studentService.getById(id));
    }
    @PutMapping
    public R update(@RequestBody Student student){
        return new R(studentService.updateById(student));
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable  Integer id){
        return new R( studentService.removeById(id));
    }



    @GetMapping("/getall")
    public R getALL(){
        return new R(true,studentService.list());
    }


    @GetMapping("/getall/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable  int pageSize,String name ,Student student){
        IPage<Student> page=studentService.getPage(currentPage,pageSize,student);
        if (currentPage>page.getPages()){
            page=studentService.getPage((int)page.getPages(),pageSize,student);
        }
        return new R(null!= page,page);
    }


}
