<template>

  <el-form
  :model="ruleForm"
  status-icon
  :rules="rules"
  ref="ruleForm"
  label-width="100px"
  class="demo-ruleForm"
  
>
<div class="update">
<el-row>
    <el-col :span="11">
        <el-form-item label="旧密码" prop="pass">
        <el-input
        type="password"
        v-model="ruleForm.pass"
        autocomplete="off"
        ></el-input>
  </el-form-item>
  <el-form-item label="新密码" prop="checkPass">
    <el-input
      type="password"
      v-model="ruleForm.checkPass"
      autocomplete="off"
    ></el-input>
  </el-form-item>
    </el-col>
</el-row>
  
  
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
    <el-button @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
  </div>
</el-form>

</template>

<script>
import axios from 'axios'
import qs from 'qs'
  export default {
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'))
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass')
          }
          callback()
        }
      }
      
      return {
        ruleForm: {
          pass: '',
          checkPass: '',
          
        },
        rules: {
          pass: [{ validator: validatePass, trigger: 'blur' }],
          checkPass: [{ trigger: 'blur' }],
          
        },
      }
    },
    methods: {
      submitForm(formName) {
        let data = this.ruleForm;
        let i = {
          stno:this.$store.state.user.stno,
          password:data.checkPass
        }
        if(data.pass != this.$store.state.user.password){
          window.alert("密码输入错误");
        }else{
          axios.post("http://localhost:8080/exam/student/update",
           qs.stringify(i),
          ).then(function(response){
            window.alert(response.data.msg);

          }).catch(function(err){
            window.alert("服务器已崩溃")
          })
        }
      },
      resetForm(formName) {
        this.$refs[formName].resetFields()
      },
    },
  }
</script>

<style scoped>
    .el-form{
  width: 1200px;
  height: 650px;
  float:left;
   background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 100px;
    margin-top: 0; 
 }
   .update{
    margin-top:200px;
    margin-left: 350px;
   } 

</style>