<template>
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
    <el-menu-item index="1" disabled>班级：{{this.$store.state.user.classid}}班</el-menu-item>
    <el-menu-item index="2" disabled>姓名：{{this.$store.state.user.name}}</el-menu-item>
    <el-menu-item index="2" disabled><img src="../assets/vue.svg"  alt="vue" /></el-menu-item>
    <el-sub-menu index="3">
      <template #title></template>
      <el-menu-item index="3-1">退出</el-menu-item>
      <el-menu-item index="3-2">关于</el-menu-item>
    </el-sub-menu>
  </el-menu>

</template>

<script>
export default {
    name:'header',
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

<style scoped>
    .flex-grow {
  flex-grow: 1;
}
.el-header {
    color: #333;
    text-align: center;
    line-height: 60px;
  }
</style>