<script >
 export default {
   name:'aside',
 }
</script>

<template>
  <el-aside style="height:650px">
          <el-row >     
            <el-col :span="24">
              <el-menu
                class="el-menu-vertical-demo"
                default-active="1"
                background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
              >
                <el-sub-menu index="1" >
                  <template #title>
                    <el-icon><location /></el-icon>
                    <span>题库管理</span>
                  </template>
                  <el-menu-item-group #title>
                    <router-link to="/teacherShow/selectTable"><el-menu-item index="1-1">选择题</el-menu-item></router-link>
                    <!-- <router-link :to="{name:'selectTable',params:{name:choiceList}"><el-menu-item index="1-1">选择题</el-menu-item></router-link> -->
                    <router-link to="/teacherShow/judgeTable"><el-menu-item index="1-2">判断题</el-menu-item></router-link>
                    <router-link to="/teacherShow/fillTable"><el-menu-item index="1-3">填空题</el-menu-item></router-link>
                    <router-link to="/teacherShow/simpleTable"><el-menu-item index="1-4">简答题</el-menu-item></router-link>
                    <router-link to="/teacherShow/Zujuan"><el-menu-item index="1-5">组卷</el-menu-item></router-link>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="2">
                  <template #title>
                    <el-icon><icon-menu /></el-icon>
                    <span>学生管理</span>
                  </template>
                  <el-menu-item-group #title>
                    <router-link to="/teacherShow/teacher"><el-menu-item index="2-1">学生查询</el-menu-item></router-link>
                    <router-link to="/teacherShow/dajuan"><el-menu-item index="2-2">答卷查询</el-menu-item></router-link>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-menu-item index="3">
                  <el-icon><document /></el-icon>
                  <span>账户设置</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>
</template>

<style scoped>

</style>