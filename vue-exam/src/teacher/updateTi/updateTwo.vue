<template>
<el-main>
<el-form :model="form" label-width="120px">
    <el-form-item label="题目">
      <el-input v-model="form.title" />
    </el-form-item>
    <el-form-item label="答案">
      <el-radio-group v-model="form.daan">
        <el-radio checked label="正确" />
        <el-radio label="错误" />
      </el-radio-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="updatePanduan">Update</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</el-main>
</template>
<script>
import axios from 'axios'
import qs from 'querystring'
export default {
    name:'insertTwo',
    data(){
        return{
            form:{
                title: '',
                daan:''
            }
        }     
    },
    methods:{
        updatePanduan(){
          axios.post("http://localhost:8080/exam/panduan/update",qs.stringify(this.form) ,{
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