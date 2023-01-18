<template>

  <el-col :span="12" id="aside">
    <el-menu
        default-active="1"
        class="el-menu-vertical-demo"
        active-color="black"
    >
      <el-menu-item index="1"      id="menue1" >
        <el-icon ><Document /></el-icon>
        <router-link to="/home/users"  >学生信息管理</router-link>
      </el-menu-item>
      <el-menu-item index="2"  id="menue2">
        <el-icon><Histogram /></el-icon>
        <router-link to="/home/analysis"  >学生返校数据分析</router-link>
      </el-menu-item>
    </el-menu>
  </el-col>
</template>

<script>


export default {
  name: "MyAside",
  methods: {

  }

}
</script>

<style scoped>
.layout-aside-container li{
  list-style: none;
}
.el-col-12 {
  max-width: 50%;
  flex: 0 0 0;
}
#menue1 >a,#menue2 >a{
  text-decoration: none;
  color: black;
}
.router-link-active{
  text-decoration: none;
  color: rgb(64,158,255);
}
#aside{
  font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
}
</style>