<template>
  <div class="studentsubmit">
    <div class="form">
      <h1 align="center" class="mb-5">学生信息提交表单</h1>
      <el-form :model="form" label-width="120px" >
        <el-form-item label="学生姓名">
          <el-input v-model="form.name"  />
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="form.gender">
            <el-radio label="男" />
            <el-radio label="女" />
          </el-radio-group>
        </el-form-item>
        <el-form-item label="学生年龄">
          <el-input v-model="form.age"  />
        </el-form-item>
        <el-form-item label="学生学号">
          <el-input v-model="form.number"  />
        </el-form-item>
        <el-form-item label="学生手机号">
          <el-input v-model="form.phonenumber"  />
        </el-form-item>
        <el-form-item label="专业">
          <el-input v-model="form.department"  />
        </el-form-item>
        <el-form-item label="学院">
          <el-input v-model="form.college"  />
        </el-form-item>
        <el-form-item label="当前所在城市">
          <el-input v-model="form.city"  />
        </el-form-item>


        <el-form-item label="健康状况">
          <el-select v-model="form.health" placeholder="选择当前状态">
            <el-option label="健康" value="健康" />
            <el-option label="良好" value="良好" />
            <el-option label="发热" value="发热" />
            <el-option label="发热" value="发热" />
            <el-option label="咳嗽" value="咳嗽" />
          </el-select>
        </el-form-item>
        <el-form-item label="当前体温">
          <el-input v-model="form.temperature"  />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">提交</el-button>
          <el-button @click="cancel">取消</el-button>
          <el-button type="info" @click="changeinfo"  >修改用户名或密码</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
  <div class="add-form">

    <el-dialog title="修改用户名或密码" v-model="dialogFormVisible4Edit">

      <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

        <el-row>

          <el-col :span="12">

            <el-form-item label="用户名" prop="username">

              <el-input v-model="formData.username" disabled :value="formData.username"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="密码" prop="password">

              <el-input v-model="formData.password"/>

            </el-form-item>

          </el-col>


        </el-row>



      </el-form>


      <div slot="footer" class="dialog-footer" align="center">

        <el-button  @click="cancel">取消</el-button>

        <el-button type="primary" @click="handleEidt" >确定</el-button>

      </div>

    </el-dialog>

  </div>

</template>

<script>
import {onMounted, reactive} from 'vue'
import axios from "axios";
export default {
  name: "StudentSubmit",
  data(){
    return{
      form:{
        name: '',
        gender: '',
        age: '',
        number: '',
        phonenumber: "",
        department: '',
        college: '',
        city: '',
        health:'',
        temperature:'',
      },

      rules: {//校验规则
        gender: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        name: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        number: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        department: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        college: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        health: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        phonenumber: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        city: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        temperature: [{ required: true, message: '此项为必填项', trigger: 'blur' }],
        age: [{ required: true, message: '此项为必填项', trigger: 'blur' }],

      },
      formData:{
        username:"",
        password:"",
      },
      dialogFormVisible4Edit:false
    }
  },
  methods:{
    onSubmit(){
      if(this.form.name===""|| this.form.gender===""||this.form.number===""||this.form.department===""||this.form.college===""||this.form.health===""||this.form.phonenumber===""||this.form.city===""||this.form.temperature===""||this.form.age===""){
        this.$message.info("有未填项，请检查")
      }else {
        axios.post("/home/save",this.form).then(({data:res})=>{
          if(res.flag){
            this.$message.success("添加成功")
          }else {
            this.$message.error(res.msg)
          }
        })

      }


    },
    cancel(){
      this.dialogFormVisible4Edit=false
      this.$message.info("操作取消")
    },
    changeinfo(){
      this.dialogFormVisible4Edit=true
    },

    handleEidt(){

      if(this.formData.username===""||this.formData.password===""){
        this.$message.info("有未填项，请检查")
      }else {
        axios.get("/student/changeup/"+this.formData.username+"/"+this.formData.password).then(({data:res})=>{
          console.log(this.formData)
          if(res.flag ){
            this.dialogFormVisible4Edit=false;
            this.$message.success("修改成功")
            localStorage.removeItem("token")
          }else {
            this.$message.error("数据同步失败")
          }

        })
      }

    }


  },

  setup(){
    onMounted(()=>{

    })

  },
  created() {
    this.formData.username=this.$route.query.username
  }
}
</script>

<style scoped>
.studentsubmit{
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.form{
  width: 55%;
  border: 1px solid black;
}
.el-input{
  width: 85%;
}
</style>