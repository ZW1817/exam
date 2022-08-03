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
      <el-button type="primary" @click="updateTiankong">Update</el-button>
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
        updateTiankong(){
          axios.post("http://localhost:8080/exam/tiankong/update",qs.stringify(this.form) ,{
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
      console.log(JSON.parse(this.$route.query.formdata));
      this.form = JSON.parse(this.$route.query.formdata);
    }

}
</script>