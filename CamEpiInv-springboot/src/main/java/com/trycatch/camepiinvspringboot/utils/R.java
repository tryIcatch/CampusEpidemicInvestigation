package com.trycatch.camepiinvspringboot.utils;


import com.trycatch.camepiinvspringboot.entity.Teacher;
import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    private String token;

    public R(Boolean flag){
        this.flag=flag;
    }
    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public R(Boolean flag,String msg){
        this.msg=msg;
        this.flag=flag;
    }

    public R(Boolean flag,String msg,String token){
        this.msg=msg;
        this.flag=flag;
        this.token=token;
    }

    public R(Boolean flag,Object data,String token){
        this.flag=flag;
        this.data=data;
        this.token=token;
    }
}
