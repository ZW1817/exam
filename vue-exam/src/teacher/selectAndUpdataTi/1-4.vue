<template>
<el-main>
 <router-link to="/teacher/addSimple"><el-button type="success">新增简答题</el-button></router-link>
  <el-table :data="jiandaList" style="width: 100%;margin-top: 30px;">
    <el-table-column prop="id" label="序号"/>
    <el-table-column prop="title" label="题目" width="200px" />
    <el-table-column prop="daan" label="正确答案" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="Type to search" />
      </template>
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >Edit</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >Delete</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</el-main>
</template>

<script>
import axios from 'axios'
import qs from 'querystring'
export default{
    name:'panduan',
    data(){
       return{
         jiandaList:[]
       }
    },
    methods:{
        handleEdit(number, User){
            console.log(index, row)
        },
        handleDelete( number,  User){
          axios.post("http://localhost:8080/exam/jianda/delete",qs.stringify(User),
              {
                // withCredentials: true,
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
              }
            }
           ).then(function(response){
            let message = response.data.msg;
              window.alert(message + "  请重新刷新页面")
           }).catch(function(err){
            window.alert("请稍后重试")
           })
        }
    },
    mounted() {
      let that = this;
      axios.post("http://localhost:8080/exam/jianda/findAll",
        {
          // withCredentials: true,
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        }
      ).then(function (response){
        let choice = response.data;
        that.jiandaList = JSON.parse(JSON.stringify(choice));
    }).catch(function(err){
            window.alert("请稍后重试")
           })
    },
}
import { computed, ref} from 'vue'

const search = ref('')

</script>
<style>

</style>
