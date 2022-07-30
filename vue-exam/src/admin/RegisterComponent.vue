<template>
  <body>
    <div class="login">
      <el-form :model="registerForm" status-icon :rules="rules" ref="registerForm" label-width="130px" class="demo-loginForm">
        <h1 class="title" style="padding-top: 20px;margin-bottom: 10px;">
          注册页面
        </h1>
        <el-form-item label="姓 名" prop="userId">
          <el-input type="text" v-model="registerForm.userId" autocomplete="off" placeholder="请输入姓名" input-style="width:240px"></el-input>
        </el-form-item>
        <el-form-item label="密 码" prop="passWord">
          <el-input type="password" v-model="registerForm.passWord" autocomplete="off" placeholder="请输入密码" input-style="width:240px"></el-input>
        </el-form-item>
        <el-form-item label="验证码" prop="sidentify">
          <el-input v-model="registerForm.sidentify" style="width: 50%;float: left;" autocomplete="off"
            placeholder="请输入验证码" />
          <div class="coderight" @click="refreshCode">
            <SIdentify :identifyCode="identifyCode"></SIdentify>
          </div>
        </el-form-item>
        <el-form-item class="box">
          <el-button type="primary" @click="submitForm()">注册</el-button>
          <el-button @click="returnLogin()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </body>
</template>

<script>
  import SIdentify from "./identify.vue";
  import axios from 'axios'
  import qs from 'qs'
  export default {
    name: 'register',
    data() {
      const sidentify = (rule, value, callback) => {
        let newVal = value.toLowerCase()
        let identifyStr = this.identifyCode.toLowerCase()
        if (newVal === '') {
          callback(new Error('请输入验证码'))
        } else if (newVal !== identifyStr) {
          callback(new Error('验证码不正确'))
        } else {
          callback()
        }
      };
      return {
        role:'',
        identifyCodes: '1234567890ABCDEFGHIGKLMNoPQRSTUVWXYZ',
        identifyCode: '', //验证码
        registerForm: {
          userId: '',
          passWord: '',
          sidentify: '',
          remember: false,
        },
        rules: {
          userId: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '长度为2-4', trigger: 'blur' }
          ],
          passWord: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 5, max: 16, message: '长度为5-12', trigger: 'blur' }
          ],

          sidentify: [{ required: true, validator: sidentify, trigger: 'blur' }]
        },
      };
    },
    components: {
      SIdentify: SIdentify
    },
    mounted() {
      this.identifyCode = "";
      this.makeCode(this.identifyCodes, 4);
      this.role=this.$route.query.role;
      // console.log(this.role);
    },
    methods: {
      // 生成随机数
      randomNum(min, max) {
        return Math.floor(Math.random() * (max - min) + min)
      },
      // 生成四位随机验证码
      makeCode(o, l) {
        for (let i = 0; i < l; i++) {
          this.identifyCode += this.identifyCodes[this.randomNum(0, this.identifyCodes.length)]
        }
      },
      // 切换验证码
      refreshCode() {
        this.identifyCode = ''
        this.makeCode(this.identifyCodes, 4)
      },
      //注册表单==============
      submitForm() {
        let username = this.registerForm.userId;
        let password = this.registerForm.passWord;
        let role = this.role;
        console.log(role);
      axios({
        headers:{
          'deviceCode':'A95ZEF1-47B5-AC90BF3'
        },
        method:'post',
        url:'http://localhost:8080/exam/sign',
        data:qs.stringify({
          username:username,
          password:password,
          role:role
      }),
      })
      .then(function(response){
        if(response.data!=null){
          let no = response.data;
          window.alert("注册成功！您的登录账号为："+no);
          // this.$router.push('/')
          // this.returnLogin();
          window.location.href="http://127.0.0.1:5173/";
        }else if(response.data==0){
          window.alert("注册失败！");
        }
      })
      },
      returnLogin() {
        this.$router.push('/')
      }
    }
  }
</script>

<style scoped>
  .el-form-item__content {
    line-height: 5px;
  }

  .background {
    width: 100%;
    height: 100%;
    background-size: 100% 100%;
    position: fixed;
    z-index: -1;
  }

  .login {
    position: absolute;
    top: 50%;
    left: 50%;
    -webkit-transform: translate(-50%, -50%);
    -moz-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    -o-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    opacity: 0.9;
  }

  .el-form {
    width: 400px;
    border-radius: 15px;
    padding: 3px 3px;
    box-shadow: 5px 5px 5px #9fa0a1;
    background-color: rgb(246, 250, 250);
  }

  .el-form,
  .title {
    font-size: 25px;
    font-weight: bold;
    text-align: center;
    padding-bottom: 8px;
    margin-left: 50px;
  }

  .el-form,
  .box {
    padding-right: 55px;
    line-height: 10px;
  }

  .el-button{
    margin-right: 40px;
  }

  body{
      width: 1520px;
			background-image: url("../assets/background.jpg");
			background-size: 100%;
      background-repeat: no-repeat;
			/* opacity: 0.8; */
  }

  .remberBox {
    float: left;
  }

</style>