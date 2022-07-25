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
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
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
    <el-menu-item index="1" disabled>班级：201807050106</el-menu-item>
    <el-menu-item index="2" disabled>姓名：张三</el-menu-item>
    <el-menu-item index="3" disabled> <el-avatar
        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
      /></el-menu-item>
    <el-sub-menu index="4">
      <template #title></template>
      <el-menu-item index="4-1">退出</el-menu-item>
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
</style>
