package com.trycatch.camepiinvspringboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trycatch.camepiinvspringboot.entity.Teacher;

import java.util.List;


public interface TeacherService extends IService<Teacher> {
    public List<Teacher> getByUsername(String username);
}
