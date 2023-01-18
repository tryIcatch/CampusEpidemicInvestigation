<template>
  <div class="home-container">
       <my-header></my-header>
    <div class="home-main-box">
      <my-aside></my-aside>
      <div class="home-main-body">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import MyAside from "@/components/subcomponents/MyAside.vue";
import MyHeader from "@/components/subcomponents/MyHeader.vue";
export default {
  name: "MyHome",
  components:{
    MyHeader,
    MyAside,
  }
}
</script>

<style scoped>
.home-container{
  height: 100%;
  display: flex;
  flex-direction: column;
}
.home-main-box{
  height: 100%;
  display: flex;
}
.home-main-body{
  padding: 15px;
  flex: 1;
}
</style>