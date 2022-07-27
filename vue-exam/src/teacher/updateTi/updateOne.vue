<template>
<el-main>
<el-form :model="form" label-width="120px">
    <el-form-item label="题目" style="width:'100px';">
      <el-input v-model="form.title" />
    </el-form-item>
    <el-form-item label="正确答案">
      <el-input v-model="form.daan" />
    </el-form-item>
    <el-form-item label="选项A">
      <el-input v-model="form.choicea" />
    </el-form-item>
    <el-form-item label="选项B">
      <el-input v-model="form.choiceb" />
    </el-form-item>
    <el-form-item label="选项C">
      <el-input v-model="form.choicec" />
    </el-form-item>
    <el-form-item label="选项D">
      <el-input v-model="form.choiced" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="updateXuanze">Update</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</el-main>
</template>

<script>
import axios from 'axios'
import qs from 'querystring'
export default {
    name:'insertOne',
    data(){
        return{
            form:{
                title: '',
                daan: '',
                choicea: '',
                choiceb: '',
                choicec: '',
                choiced: '',
            }
        }     
    },
    methods:{
      updateXuanze(){
         axios.post("http://localhost:8080/exam/xuanze/update",qs.stringify(this.form) ,{
            // withCredentials: true,
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          }).then(function(response){
            window.alert(response.data.msg);
          }).catch(function (err) {
            window.alert('服务器无响应，请重试！');
          });
      }
    },
     mounted(){
      this.form = JSON.parse(this.$route.query.formdata);
    }
}
</script>

<style>
</style>