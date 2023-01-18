<template>

    <div class="login-container" >
      <div class="wut" >
        <img src="../assets/logo.png" alt="" style="width: 280px;" >
      </div>

      <div class="login-container1">

          <div class="login-container-left">
            <img src="../assets/sketch%20(2).png" alt="" style="width: 434px;border-radius: 8px">

          </div>
        <div class="login-container-right">
          <div class="login-header">
            <div class="header-left" ref="teacher" @click="goteacher">
              <p align="center">教师登录</p>
            </div>

            <div class="header-right" ref="student"  @click="gostudent">
              <p align="center">学生登录</p>
            </div>
          </div>
          <div class="line" ref="line" ></div>
          <div class="login-box">
            <div class="input">
              <input type="text" placeholder="用户名"  ref="username" v-model.trim:value="username" >
            </div>
            <div class="input">
              <input type="password" placeholder="密码"  ref="password" v-model.trim:value="password">
            </div>


          </div>
          <div class="login-footer" >
            <div class="login_btn">    <button style="display:block;margin:0 auto;" @click="login" >登录</button></div>
          </div>
        </div>

      </div>


    </div>



</template>

<script>
import { ref,onMounted } from "vue";
import axios from "axios";
import router from "@/router";
export default {
  name: "Mylogin",
  data(){
    return{
      username:'',
      password:'',
      identity:'teacher',
    }
  },
  methods:{
    goteacher(){
      this.$refs.line.style.right=88+"px"
      this.identity="teacher"
    },
    gostudent(){
      this.$refs.line.style.right=-93+"px"
      this.identity="student"
    },
    login(){
      if(this.username===""||this.password==="") this.$message.error("用户名和密码不能为空")
      if(this.identity==="student"&& this.username!=="" && this.password!==""){
        axios.post("/student",{
          "username":this.username,
          "password":this.password,
        }).then(({data:res})=>{
          if(res.flag===true){
            this.$message.success("登录成功")
            router.push({
              path:"/studentsubmit?",
              query:{
                "username":this.username
              }
            })
            localStorage.setItem("token",res.token)
          }else {
            this.$message.info(res.msg)
            localStorage.removeItem("token")
          }
        })
      }

      if(this.identity==="teacher"&& this.username!=="" && this.password!==""){
        axios.post("/api",{
          "username":this.username,
          "password":this.password,
        }).then(({data:res})=>{
          if(res.flag===true){
            this.$message.success("登录成功")
            router.push({path:'/home'})
            localStorage.setItem("token",res.token)
          }else {
            this.$message.info(res.msg)
            localStorage.removeItem("token")
          }

        })


      }


    }


  },
  setup() {
    let teacher = ref(null);
    let student = ref(null);
    let line = ref(null);
    // 需要在生命周期获取
    onMounted(()=>{
      line.value.style.right=88+"px"
    })
    return { teacher, student,line };
  },
  created() {
    this.identity="teacher"
  },
}
</script>

<style scoped>

 .login-container{
   width: 100%;
   border: solid 1px black;
   height: 100vh;
   display: flex;
   flex-direction: column;
   justify-content: space-around;
   align-items: center;
   background-color: rgb(150,15,5);
   color: white;
   font-family: "Lucida Calligraphy", cursive, serif, sans-serif;

 }

 .login-container1{
   display: flex;
   -webkit-box-align: center;
   align-items: center;
   width: 70vw;
   max-width: 1180px;
   justify-content: space-around;
   margin-bottom:180px;
   border: 1px white solid;
   border-radius: 8px;
 }
.login-container-left {
  height: 100%;
  width: 434.41px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
}
.login-container-right{
  width: 478px;
  height: 380px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

}
.login-header{
  width: 360px;
  height:88px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
.login-box{
  width: 360px;
  height:160px;
  border: solid 1px white;
  border-bottom: none;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  font-size: 18px;
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;

}
.login-footer{
  width: 360px;
  height: 55px;
  border: solid 1px white;
  border-bottom-right-radius:8px;
  border-bottom-left-radius:8px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.header-left,.header-right{
  width: 50%;
  height: 100%;
  line-height: 75px;
  font-size: 20px;

}
.img_box img{
 width: 560px;
}
.login-box input {
  width: 250px;
  height: 35px;
  margin-bottom: 15px;
  margin-top: 15px;
  border: #8c939d 1px solid;
  border-radius: 3px;
  outline: none;
  caret-color:rgb(150,15,5);
  text-shadow:rgb(150,15,5) ;

}
.login-box input:focus{
  -webkit-box-shadow: 0 0 5px burlywood;/*点击input 外阴影*/
  -moz-box-shadow:0 0 5px wheat;
  box-shadow: 0 0 5px wheat;
  border-color:whitesmoke ;/*黑色边框改为白色*/
  background:whitesmoke;/*input内背景为白色*/
}
.login-footer button{
  width:200px;
  height:40px;
  font-size:18px;
  border: none;
  background-color: rgb(255,255,255);
  border-radius: 2px;
}
.line{
  width: 130px;
  border: 1px white solid;
  margin-bottom: 20px;
  position: relative;
}


</style>