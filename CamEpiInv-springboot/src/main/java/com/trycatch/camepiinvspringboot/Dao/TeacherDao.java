package com.trycatch.camepiinvspringboot.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trycatch.camepiinvspringboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {
    public Teacher getByUsername();
}
