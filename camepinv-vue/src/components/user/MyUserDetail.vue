<template>
<h1 class="text-center">用户详情页--{{id}}</h1>
  <button type="button" class="btn btn-light btn-sm" @click="goBack">后退</button>
</template>

<script>
export default {
  name: "MyUserDetail",
  props:["id"],
  methods:{
    goBack(){
      this.$router.go(-1)
    }
  }
}
</script>

<style scoped>

</style>