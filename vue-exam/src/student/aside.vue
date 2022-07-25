<template>
<div class="aside">
  <el-aside style="height:500px">
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
            <span>考试管理</span>
          </template>
          <el-menu-item-group #title>
            <router-link to="/student">
              <el-menu-item index="1-1">
              未答卷              
              </el-menu-item>
            </router-link>

            <router-link to="/student/answer">
              <el-menu-item index="1-2">
              已答卷
              </el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-sub-menu>

        <el-sub-menu index="2" >
          <template #title>
            <el-icon><location /></el-icon>
            <span>账户设置</span>
          </template>
          <el-menu-item-group #title>
            <router-link to="/student/personalData">
              <el-menu-item index="2-1">
              个人资料             
              </el-menu-item>
            </router-link>
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
          </el-menu-item-group>
        </el-sub-menu>
      </el-menu>
    </el-col>
  </el-row>
  </el-aside>
 </div> 
</template>

<script>
import { ref } from 'vue'
export default {
    name:'aside',
    
}
</script>

<style>
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

.aside{
  width: 300px;
  height: 600px;
  float:left;
}
</style>