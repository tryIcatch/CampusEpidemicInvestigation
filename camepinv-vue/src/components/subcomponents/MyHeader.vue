<template>
      <div class="header">
        <nav aria-label="breadcrumb" class="navigate">
          <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page" style="color:#000; font-size:20px">高校返校疫情排查管理系统</li>
<!--            <button type="button" class="btn btn-link  btn-sm login-btn" @click="onLoginOut" style="text-decoration: none">退出登录</button>-->
            <el-button type=""  @click="onLoginOut">退出登录</el-button>
          </ol>
        </nav>
      </div>

</template>

<script>
export default {
  name: "MyHeader",
  methods:{
    onLoginOut(){
      localStorage.removeItem("token")
      this.$router.push("/login")
    }
  }
}
</script>

<style scoped>

.navigate{
  width: 100%;
}
.breadcrumb{
  justify-content: space-between;
}
.header{

  font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
  background-color: white;
}
</style>