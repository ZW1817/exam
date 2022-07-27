<template>
<el-main>
<el-form :model="form" label-width="120px">
    <el-form-item label="题目">
      <el-input v-model="form.title" />
    </el-form-item>
    <el-form-item label="正确答案">
      <el-input v-model="form.daan" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="careteTiankong">Create</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</el-main>
</template>

<script>
import axios from 'axios'
import qs from 'querystring'
export default {
    name:'insertThree',
    data(){
        return{
            form:{
                title: '',
                daan:''
            }
        }     
    },
    methods:{
        careteTiankong(){
          let formdata = null;
          formdata = this.form;
          axios.post("http://localhost:8080/exam/tiankong/insert",qs.stringify(formdata) ,{
            // withCredentials: true,
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          }).then(function(response){
            console.log(response);
            if(response.data == 1){
              window.alert('添加成功');
            }else {
              window.alert('添加失败');
            }
          }).catch(function (err) {
            window.alert('服务器无响应，请重试！');
          });
        }
    }
}
</script>