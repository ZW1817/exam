<script>
import Aside from './aside.vue'
import Header from './header.vue'
// import Answer from './student/answer.vue'
import NotAnswer from './notAnswer.vue'
  export default{
    name:'App',
    components: {
    Header,
    Aside,
    // Answer
    NotAnswer
}
}
</script>

<template>
<el-container class="con"> 
    <el-header>
  <Header></Header>
  </el-header>
  <el-container style="height:350px">
    <Aside></Aside>  
  <router-view></router-view>
  </el-container>
</el-container> 
</template>

<style scoped>
.el-main{
  background-color: #f9f9f9;
  color:#333;
  /* text-align: center;
  line-height: 160px; */
}
.con{
    width:100%;
}
</style>