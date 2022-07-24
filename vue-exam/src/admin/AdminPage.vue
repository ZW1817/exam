<script>
// import home from './Home.vue'
// import head from './HeadComponent.vue'
import students from './StudentComponent.vue'
import teachers from './TeacherComponent.vue'

import { ref } from 'vue'

export default {
    name: "App",
    components: { 
      Document,
      IconMenu,
      Location,
      Setting,
      students,
      teachers
    },
    methods(){
      
    }
    
}
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

const visible = ref(false)
</script>

<template>
  <el-container>
    <el-header>
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
    <el-col :span="2">
    <el-menu-item index="0">java</el-menu-item>
    </el-col>
    <div class="flex-grow" />
    <el-col :span="18">
    <el-menu-item index="1" disabled>班级：201807050106</el-menu-item>
     </el-col>  
    <el-menu-item index="2" disabled>姓名：张三</el-menu-item>
    <el-menu-item index="2" disabled><img src="../assets/vue.svg"  alt="vue" /></el-menu-item>
    <el-sub-menu index="3">
      <template #title></template>
      <el-menu-item index="3-1">退出</el-menu-item>
      <el-menu-item index="3-2">关于</el-menu-item>
    </el-sub-menu>
   
  </el-menu>
    </el-header>
    <el-container>
        <el-aside >
  <el-row style="justify-content:right">     
    <el-col :span="22">
      <el-menu
        class="el-menu-vertical-demo"
        default-active="2"
        background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
      >
        <el-sub-menu index="1" >
          <template #title>
            <el-icon><location /></el-icon>
            <span>基础管理</span>
          </template>
          <el-menu-item-group #title>
            <el-menu-item index="1-1"><router-link to="/adminPage/students">学生管理</router-link></el-menu-item>
            <el-menu-item index="1-2"><router-link to="/adminPage/teachers">教师管理</router-link></el-menu-item>
            <el-menu-item index="1-3"><router-link to="/adminPage/classes">班级管理</router-link></el-menu-item>
            <el-menu-item index="1-4"><router-link to="/adminPage/course">科目管理</router-link></el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <el-icon><icon-menu /></el-icon>
            <span>账户设置</span>
          </template>
          <el-menu-item-group #title>
            <el-menu-item index="2-1" @click="visible = true">修改密码
              <el-dialog v-model="visible" :show-close="false" >
                <template #header="{ close, titleId, titleClass }">
                  <div class="my-header">
                    <h4 :id="titleId" :class="titleClass" style="margin-left:200px">修改密码</h4>
                    请输入旧密码：<el-input class="updating"></el-input><br>
                    请输入新密码：<el-input class="updating"></el-input><br>
                    <el-button type="danger" @click="close" style="margin-right:190px;margin-left:50px">确认</el-button>
                    <el-button type="danger" @click="close">取消</el-button>
                  </div>
                </template>
              </el-dialog>
            </el-menu-item>
            <el-menu-item index="2-2"><router-link to="/adminPage/edit">编辑账户</router-link></el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>
            <el-icon><icon-menu /></el-icon>
            <span>公告管理</span>
          </template>
          <el-menu-item-group #title>
            <el-menu-item index="3-1"><router-link to="/adminPage/notice">发布公告</router-link></el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
      </el-menu>
    </el-col>
  </el-row>
  </el-aside>
        <router-view></router-view>
      </el-container>
  </el-container>



</template>

<style scoped>
.el-header {
    color: #333;
    text-align: center;
    line-height: 100px;

  }
.el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 100px;
    height: 660px;
  }
/* .el-container{
  height: 720px;
  width: 1520px;
} */
body > .el-container {
  margin-bottom: 40px;
  width: 100%;
}
.updating{
  width: 340px;
  font-size: 20px;
}

.my-header{
  margin-left: 160px;
}

.el-dialog  {
    border-radius: 30px;
}

.el-menu-item * {
    vertical-align: baseline;
}

.el-overlay-dialog  {
    width: 450px;
}
</style>
