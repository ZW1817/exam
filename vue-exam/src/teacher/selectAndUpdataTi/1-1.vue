<template>
<el-main>
<router-link to="/teacherShow/addSelect"><el-button type="success">新增选择题</el-button></router-link>
  <el-table :data="choice" style="width: 100%;margin-top: 30px;">
    <el-table-column prop="id" label="序号"/>
    <el-table-column prop="title" label="题目" width="200px" />
    <el-table-column prop="choicea" label="A" />
    <el-table-column prop="choiceb" label="B" />
    <el-table-column prop="choicec" label="C" />
    <el-table-column prop="choiceb" label="D" />
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
export default{
    name:'xuanze',
    data(){
       return{
        choice:[]
        //  date:  {
        //     type:String
        //   },
        //   name:  {
        //       type:String
        //   },
        //   address:  {
        //       type:String
        //   },
        // choice:{
        //     type:Object,
        //     default:[]
        // }
       }
    },
    methids:{
        handleEdit(number, User){
            console.log(index, row)
        },
        handleDelete( number,  User){
            console.log(index, row)
        }
    }
}
import { computed, ref} from 'vue'



const search = ref('')

</script>
<style>

</style>
