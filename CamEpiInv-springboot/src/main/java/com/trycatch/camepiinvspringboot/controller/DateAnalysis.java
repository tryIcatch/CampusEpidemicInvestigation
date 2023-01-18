package com.trycatch.camepiinvspringboot.controller;

import com.trycatch.camepiinvspringboot.entity.DateNum;
import com.trycatch.camepiinvspringboot.service.StudentService;
import com.trycatch.camepiinvspringboot.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analysis")
public class DateAnalysis {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public R getData(){
        return new R(true,studentService.getCountByDate());
    }
    @GetMapping("/healthnum")
    public R getHealth(){
        return new R(true,studentService.getHealthNum());
    }


}
