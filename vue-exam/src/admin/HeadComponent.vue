<script >
 export default {
   name:'HelloWorld',
   data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      edit(){
        this.$router.push("/");
      }
    }
 }
</script>

<template>
<div class="top">
<el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    :ellipsis="false"
    @select="handleSelect"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <el-menu-item index="0">java</el-menu-item>
    <div class="flex-grow" />
    <el-menu-item index="1" disabled>用户名：{{this.$store.state.user.username}}（管理员）</el-menu-item>
    <el-menu-item index="2" disabled>姓名：{{this.$store.state.user.realname}}</el-menu-item>
    <el-menu-item index="3" disabled> <el-avatar
        src="https://img0.baidu.com/it/u=4279060385,1136133045&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
      /></el-menu-item>
    <el-sub-menu index="4">
      <template #title></template>
      <el-menu-item index="4-1" @click="edit">退出</el-menu-item>
      <el-menu-item index="4-2">关于</el-menu-item>
    </el-sub-menu>
  </el-menu>
  </div>
</template>

<style scoped>
.flex-grow {
  flex-grow: 1;
}
.top{
  width:100%;
  height: 60px;
  margin-top: 0;
}
.el-avatar{
  margin-top:10px;
}
</style>
