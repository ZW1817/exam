<script>
import students from './StudentComponent.vue'
import teachers from './TeacherComponent.vue'

import { ref } from 'vue'

export default {
    name: "App",
    components: { 
      
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
<div class="left">
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
            <router-link to="/admin"><el-menu-item index="1-1">学生管理</el-menu-item></router-link>
            <router-link to="/admin/teachers"><el-menu-item index="1-2">教师管理</el-menu-item></router-link>
            <router-link to="/admin/classes"><el-menu-item index="1-3">班级管理</el-menu-item></router-link>
            <router-link to="/admin/course"><el-menu-item index="1-4">科目管理</el-menu-item></router-link>
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
                    请输入旧密码：<el-input style="width:300px"></el-input><br>
                    请输入新密码：<el-input style="width:300px"></el-input><br>
                    <el-button type="danger" @click="close" style="margin-right:190px;margin-left:50px">确认</el-button>
                    <el-button type="danger" @click="close">取消</el-button>
                  </div>
                </template>
              </el-dialog>
            </el-menu-item>
            <router-link to="/admin/edit"><el-menu-item index="2-2">编辑账户</el-menu-item></router-link>
          </el-menu-item-group>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>
            <el-icon><icon-menu /></el-icon>
            <span>公告管理</span>
          </template>
          <el-menu-item-group #title>
            <router-link to="/admin/notice"><el-menu-item index="3-1">发布公告</el-menu-item></router-link>
          </el-menu-item-group>
        </el-sub-menu>
      </el-menu>
    </el-col>
  </el-row>
  </div>
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

body > .el-container {
  margin-bottom: 40px;
  width: 100%;
}

.updating{
  width: 100px;
  font-size: 20px;
}
.el-menu-item * {
    vertical-align: baseline;
}

.el-overlay-dialog  {
    width: 1000px;
}
.left{
  width: 300px;
  height: 600px;
  float:left;
}
</style>
