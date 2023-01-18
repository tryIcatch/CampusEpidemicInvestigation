package com.trycatch.camepiinvspringboot.controller;



import com.trycatch.camepiinvspringboot.Dao.StudentDao;
import com.trycatch.camepiinvspringboot.entity.Data;
import com.trycatch.camepiinvspringboot.entity.Student;
import com.trycatch.camepiinvspringboot.entity.Teacher;
import com.trycatch.camepiinvspringboot.key.Constant;
import com.trycatch.camepiinvspringboot.service.StudentService;
import com.trycatch.camepiinvspringboot.service.TeacherService;
import com.trycatch.camepiinvspringboot.utils.JwtUtil;
import com.trycatch.camepiinvspringboot.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/login")
public class Login {

    @Autowired
    private TeacherService teacherService;


    @PostMapping("/teacher")
    public R post(@RequestBody Teacher teacher){
        List<Teacher> teacher1=  teacherService.getByUsername(teacher.getUsername());
        if(teacher1.isEmpty()){
            return new R(false,"用户名和密码不能为空");
        }
        if(teacher1.get(0).getPassword().equals(teacher.getPassword())){
            String accessToken= JwtUtil.createJWT(teacher.getUsername().toString(), Constant.ACCESS_TOKEN_EXPIRE);
            return new R(true,"登陆成功",accessToken);
        }else {
            return new R(false,"用户名或密码错误");
        }

    }

    @Autowired
    private StudentService studentService;

    @PostMapping("/studentlogin")
    public R post(@RequestBody Student student){
        List<Student> student1=  studentService.getByUsername(student.getUsername());
        if(student1.isEmpty()){
            return new R(false,"用户名和密码不能为空");
        }
        if(student1.get(0).getPassword().equals(student.getPassword())){
            String accessToken= JwtUtil.createJWT(student.getUsername().toString(), Constant.ACCESS_TOKEN_EXPIRE);
            return new R(true,"登陆成功",accessToken);
        }else {
            return new R(false,"用户名或密码错误");
        }
    }

    @GetMapping("/studentlogin/changeup/{username}/{password}")
    public R changeup(@PathVariable String username,@PathVariable String password){
        List<Student> student1=  studentService.getByUsername(username);
        if(student1.isEmpty()){
            return new R(false,"用户名和密码不能为空");
        }
       /*修改用户名或密码*/
        studentService.updateByUsername(student1.get(0).getUsername(),password);
        return new R(true,"修改成功");
    }

}
