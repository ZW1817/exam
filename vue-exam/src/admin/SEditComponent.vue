<template>
<el-main>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
    :size="formSize"
    status-icon
  >
    <el-row>
      <el-col :span="12">
        <el-form-item label="重置密码" prop="password" >
        <el-input v-model="ruleForm.password" :disabled="true" ></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item>
      <el-button type="primary" @click="updateSubmitForm(ruleFormRef)"
        >修改</el-button
      >
      <el-button @click="resetForm(ruleFormRef)">重置</el-button>
    </el-form-item>
  </el-form>
</el-main>
</template>

<script lang="ts">
import axios from 'axios'
import qs from 'qs'
import { mapState } from "vuex";

export default{
  name:'update',
   computed: mapState({
    ruleForm: 'stu'
  }),
  data(){
    return{
      ruleForm:{
        password:'123456'
      }
    }
  },
  methods:{
    updateSubmitForm(){
      // let stno = this.$route.query.stu;
      // let password = this.ruleForm.password;
      let stu = {
        stno:this.$route.query.stu,
        password:this.ruleForm.password
      }
      axios({
            headers:{
              'deviceCode':'A95ZEF1-47B5-AC90BF3'
            },
            method:'post',
            url:'http://localhost:8080/exam/student/update',
            data:qs.stringify(stu),
        }).then(function(response){
          if(response.data.code==1){
            window.alert(response.data.msg);
            // that.$router.push("/admin");
          }
        })
          .catch(function(err){
          window.alert("操作异常");
        })
    }
  },
  mounted(){
    let stno = this.$route.query.stu;
  //  this.ruleForm = this.$store.start.stu;
    console.log(stno);
  }
}
</script>

<style scoped>
  

</style>
