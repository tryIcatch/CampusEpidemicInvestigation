<template>
 <h4 class="text-center">学生返校信息管理</h4>
  <div class="filter-container mt-3 mb-3"  >
    <el-input placeholder="学生姓名" v-model="pagination.name" style="width: 200px;" class="filter-item"></el-input>
    <el-input placeholder="学号" v-model="pagination.number" style="width: 200px;" class="filter-item"></el-input>
    <el-input placeholder="手机号" v-model="pagination.phonenumber" style="width: 200px;" class="filter-item"></el-input>
    <el-input placeholder="健康状况" v-model="pagination.health" style="width: 200px;" class="filter-item"></el-input>
    <el-input placeholder="体温" v-model="pagination.temperature" style="width: 200px;" class="filter-item"></el-input>
    <el-button @click="getAll()" class="dalfBut">查询</el-button>
    <el-button type="primary" class="butT" @click="handleCreate()">新建</el-button>
    <el-button type="info" @click="goback">返回</el-button>
  </div>
<!--新增标签弹层  -->
  <div class="add-form">

    <el-dialog title="新增" v-model="dialogFormVisible" >

      <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

        <el-row>

          <el-col :span="12">

            <el-form-item label="学生姓名" prop="name">

              <el-input v-model="formData.name"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学生性别" prop="gender">

              <el-input v-model="formData.gender"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学生年龄" prop="age">

              <el-input v-model="formData.age"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学号" prop="number">

              <el-input v-model="formData.number"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="专业" prop="department">

              <el-input v-model="formData.department"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学院" prop="college">

              <el-input v-model="formData.college"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="健康状况" prop="health">

              <el-input v-model="formData.health"/>

            </el-form-item>

          </el-col>


          <el-col :span="12">

            <el-form-item label="手机号" prop="phonenumber">

              <el-input v-model="formData.phonenumber"/>

            </el-form-item>

          </el-col>



          <el-col :span="12">

            <el-form-item label="所在城市" prop="city">

              <el-input v-model="formData.city"/>

            </el-form-item>

          </el-col>


          <el-col :span="12">

            <el-form-item label="今日体温" prop="temperature">

              <el-input v-model="formData.temperature"/>

            </el-form-item>

          </el-col>
        </el-row>



      </el-form>

      <div slot="footer" class="dialog-footer">

        <el-button @click="cancel">取消</el-button>

        <el-button type="primary" @click="handleAdd" >确定</el-button>

      </div>

    </el-dialog>

  </div>
<!--编辑标签弹层  -->
  <div class="add-form">

    <el-dialog title="编辑检查项" v-model="dialogFormVisible4Edit">

      <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

        <el-row>

          <el-col :span="12">

            <el-form-item label="学生姓名" prop="name">

              <el-input v-model="formData.name"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学生性别" prop="gender">

              <el-input v-model="formData.gender"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学生年龄" prop="age">

              <el-input v-model="formData.age"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学号" prop="number">

              <el-input v-model="formData.number"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="专业" prop="department">

              <el-input v-model="formData.department"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="学院" prop="college">

              <el-input v-model="formData.college"/>

            </el-form-item>

          </el-col>

          <el-col :span="12">

            <el-form-item label="健康状况" prop="health">

              <el-input v-model="formData.health"/>

            </el-form-item>

          </el-col>


          <el-col :span="12">

            <el-form-item label="手机号" prop="phonenumber">

              <el-input v-model="formData.phonenumber"/>

            </el-form-item>

          </el-col>



          <el-col :span="12">

            <el-form-item label="所在城市" prop="city">

              <el-input v-model="formData.city"/>

            </el-form-item>

          </el-col>


          <el-col :span="12">

            <el-form-item label="今日体温" prop="temperature">

              <el-input v-model="formData.temperature"/>

            </el-form-item>

          </el-col>
        </el-row>



      </el-form>


      <div slot="footer" class="dialog-footer">

        <el-button  @click="cancel">取消</el-button>

        <el-button type="primary" @click="handleEidt" >确定</el-button>

      </div>

    </el-dialog>

  </div>
  <table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>
      <td>#</td>
      <td>姓名</td>
      <td>年龄</td>
      <td>性别</td>
      <td>学号</td>
      <td>专业</td>
      <td>学院</td>
      <td>手机号</td>
      <td>健康状况</td>
      <td>当前所在城市</td>
      <td>当日体温</td>
      <td>日期</td>
    </tr>
    </thead>
<!--        if(res.data.records.heath==="健康") this.state="badge-success"
        if(res.data.records.heath==="发热") this.state="badge-danger"
        if(res.data.records.heath==="咳嗽") this.state="badge-warning"-->
    <tbody>
    <tr v-for="(item,i) in studentlist" :key="item.id">
      <td >{{i+1}}</td>
      <td >{{ item.name }}</td>
      <td>{{ item.age }}</td>
      <td >{{ item.gender }}</td>
      <td>{{ item.number }}</td>
      <td >{{ item.department }}</td>
      <td >{{ item.college }}</td>
      <td >{{ item.phonenumber }}</td>
      <td :class="item.health==='健康' || item.health==='良好'?state='badge-success':state='badge-warning' ">{{ item.health }}</td>
      <td >{{ item.city }}</td>
      <td >{{ item.temperature }}</td>
      <td >{{ item.date }}</td>
      <td>
          <el-button type="primary" size="small" @click="handleUpdate(item.id)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDelete(item.id)">删除</el-button>
      </td>
    </tr>
    </tbody>
  </table>
  <!--分页组件-->
  <div class="pagination-container">

    <el-pagination
        class="pagiantion"
        @current-change="handleCurrentChange"

        :current-page="pagination.currentPage"

        :page-size="pagination.pageSize"

        layout="total, prev, pager, next, jumper"

        :total="pagination.total">

    </el-pagination>

  </div>
</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: "MyUsers",
  data(){
    return{
      studentlist:[],
      dialogFormVisible: false,//添加表单是否可见
      dialogFormVisible4Edit:false,//编辑表单是否可见
      formData: {},//表单数据
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
      pagination: {//分页相关模型数据
        currentPage: 1,//当前页码
        pageSize:10,//每页显示的记录数
        total:0,//总记录数
        gender: "",
        name: "",
        number: "",
        department: "",
        college: "",
        health: "",
        phonenumber: "",
        city: "",
        temperature: "",
        age: "",
      },
      param:"",
      state:""
    }
},
  methods:{
    handleCreate(){
      this.resetForm()
      this.dialogFormVisible=true
    },
    resetForm(){
      this.formData = {}
    },
    cancel(){
      this.dialogFormVisible=false
      this.dialogFormVisible4Edit=false
      this.$message.info("操作取消")
    },

    handleUpdate(id){

      axios.get("/home/update/"+id).then(({data:res})=>{
        if(res.flag && res.data!=null){
          this.dialogFormVisible4Edit=true;
          this.formData = res.data;
        }else {
          this.$message.error("数据同步失败,自动刷新")
        }

      }).finally(()=>{
        this.getAll()
      })


    },
    handleCurrentChange(currentPage){
      this.pagination.currentPage=currentPage
      this.getAll()

    },
    handleDelete(id){

      this.$confirm("确认永久删除此信息？" ,"提示",{type:"info"}).then(()=>{

        axios.delete("/home/delete/"+id).then(({data:res})=>{
          if(res.flag){
            this.$message.success("删除成功")
          }else {
            this.$message.error("数据同步失败,自动刷新")
          }

        }).finally(()=>{
          this.getAll()
        })

      }).catch(()=>{
        this.$message.info("取消操作")
      })


    },
    handleEidt(){
      axios.put("/home",this.formData).then(({data:res})=>{
        if(res.flag){
          this.dialogFormVisible4Edit=false
          this.$message.success("修改成功")
        }else {
          this.$message.error("修改失败")
        }

      }).finally(()=>{
        this.getAll()
      })
    },
    //分页查询
    getAll() {

      this.param="?query&name="+this.pagination.name+"&number="+this.pagination.number+"&phonenumber="+this.pagination.phonenumber+"&health="+this.pagination.health+"&temperature="+this.pagination.temperature

      axios.get("/home/getall/"+this.pagination.currentPage+"/"+this.pagination.pageSize+this.param).then(({data:res})=>{
        console.log(res)

        this.pagination.pageSize=res.data.size;
        this.pagination.currentPage=res.data.current;
        this.pagination.total=res.data.total;
        this.studentlist=res.data.records;
      })

    },
    handleAdd(){
      axios.post("/home/save",this.formData).then(({data:res})=>{
        if(res.flag){
          this.dialogFormVisible=false
          this.$message.success("添加成功")
        }else {
          this.$message.error(res.msg)
        }

      }).finally(()=>{
        this.getAll()
      })
    },
    goback(){
      router.go(0)
    }

  },
  created() {

/*    axios.post("/home/list",{
      token:localStorage.getItem("token")
    }).then(({data:res})=>{
       this.studentlist = res.data;
    })*/
    this.getAll();
  }
}
</script>

<style scoped>
.badge-success{
  background-color: #00cc66;
  border: 1px solid #dee2e6;
}
.badge-warning{
  color: white;
}
</style>