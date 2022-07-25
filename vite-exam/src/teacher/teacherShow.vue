<script >
import Teacher from './Teacher.vue'
import Head from './Head.vue'
import Aside from './aside.vue'

export default {
    name: "App",
    components: { 
      Aside,
      Teacher ,
      Head,
      Document,
      IconMenu,
      Location,
      Setting
    }
}
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
</script>

<template>
  <el-container>
    <el-header>
      <Head />
    </el-header>
    <el-container>
        <Aside />
        <router-view></router-view>
      </el-container>
  </el-container>
  
</template>

<style scoped>
.el-header {
    color: #333;
    text-align: center;
    line-height: 60px;
  }
.el-main {
    background-color: #f9f9f9;
    color: #333;
    text-align: center;
  }
  
  body > .el-container {
    margin-bottom: 40px;
    width: 100%;
  }
</style>
