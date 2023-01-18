package com.trycatch.camepiinvspringboot.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trycatch.camepiinvspringboot.entity.DateNum;
import com.trycatch.camepiinvspringboot.entity.HealthNum;
import com.trycatch.camepiinvspringboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.logging.Handler;

@Mapper
public interface StudentDao  extends BaseMapper<Student> {
    public Student getByUsername();


    @Select("SELECT  date,count(*) as num FROM sch_student WHERE DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date GROUP BY date;")
    public List<DateNum> getDateNum();

    @Select("SELECT health ,count(*) as num  FROM sch_student GROUP BY health")
    public List<HealthNum> getHealthNum();

    @Update("UPDATE sch_student SET password = #{password} WHERE username = #{username}")
    public boolean updateByUsername(String username,String password);
}
