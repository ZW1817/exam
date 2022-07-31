<script>
export default {
  name: "aside",
};
</script>

<template>
  <div class="left">
    <el-aside style="height: 650px">
      <el-row>
        <el-col :span="24">
          <el-menu
            class="el-menu-vertical-demo"
            default-active="1"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-sub-menu index="1">
              <template #title>
                <el-icon><location /></el-icon>
                <span>题库管理</span>
              </template>
              <el-menu-item-group #title>
                <router-link to="/teacher/selectTable"
                  ><el-menu-item index="1-1">选择题</el-menu-item></router-link
                >
                <!-- <router-link :to="{name:'selectTable',params:{name:choiceList}"><el-menu-item index="1-1">选择题</el-menu-item></router-link> -->
                <router-link to="/teacher/judgeTable"
                  ><el-menu-item index="1-2">判断题</el-menu-item></router-link
                >
                <router-link to="/teacher/fillTable"
                  ><el-menu-item index="1-3">填空题</el-menu-item></router-link
                >
                <router-link to="/teacher/simpleTable"
                  ><el-menu-item index="1-4">简答题</el-menu-item></router-link
                >
                <router-link to="/teacher/Zujuan"
                  ><el-menu-item index="1-5">组卷</el-menu-item></router-link
                >
              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>
                <el-icon><icon-menu /></el-icon>
                <span>学生管理</span>
              </template>
              <el-menu-item-group #title>
                <router-link to="/teacher/Student"
                  ><el-menu-item index="2-1">学生查询</el-menu-item></router-link
                >
                <router-link to="/teacher/dajuan"
                  ><el-menu-item index="2-2">答卷查询</el-menu-item></router-link
                >
              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="3">
              <template #title>
                <el-icon><icon-menu /></el-icon>
                <span>账户设置</span>
              </template>
              <el-menu-item-group #title>
                <router-link to="/teacher/zhanghu"
                  ><el-menu-item index="2-1">修改资料</el-menu-item></router-link
                >
                <router-link to="/teacher/modify"
                  ><el-menu-item index="2-2">修改密码</el-menu-item></router-link
                >
              </el-menu-item-group>
            </el-sub-menu>
          </el-menu>
        </el-col>
      </el-row>
    </el-aside>
  </div>
</template>

<style scoped>
.left {
  width: 300px;
  height: 600px;
  margin-left: 0;
  float: left;
}
</style>
