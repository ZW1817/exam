<template>
<body>
      <div class="login">
        <h2>Login</h2>
        <el-form
          :model="loginForm"
          status-icon
          :rules="rules"
          ref="loginForm"
          label-width="90px"
          class="demo-loginForm"
        >
          <el-form-item label="用户名" prop="userId">
            <el-input
              type="text"
              v-model="loginForm.userId"
              autocomplete="off"
              placeholder="请输入账号"
              input-style="width:210px"
            ></el-input>
          </el-form-item>
          <el-form-item label="密 码" prop="passWord">
            <el-input
              type="password"
              v-model="loginForm.passWord"
              autocomplete="off"
              placeholder="请输入密码"
              input-style="width:210px"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="角色：">
              <el-radio-group v-model="loginForm.role">
                  <el-radio :label="2">老师</el-radio>
                  <el-radio :label="1">学生</el-radio>
                  <el-radio :label="0">管理员</el-radio>
              </el-radio-group>
          </el-form-item>
          
          <el-form-item prop="rememberPwd">
            <div class="remberBox">
              <el-checkbox v-model="loginForm.remember" />
              记住密码
            </div>
          </el-form-item>
          <el-form-item class="box">
            <el-button
              type="primary"
              @click="submitForm()"
              size="small "
              >登录</el-button
            >
            <el-button type="primary" @click="registerBtn()" class="zhuce" size="small"
              >注册</el-button
            >
          </el-form-item>
        </el-form>
  </div>
</body>

</template>
  
<script>
import axios from 'axios'
import qs from 'qs'
export default {
  name: "Login",
  data() {
    return {
      underline: false,
      loginForm: {
        userId: "",
        passWord: "",
        remember: false,
        role:1,
      },
      rules: {
        userId: [
          { required: true, message: "请输入账号", trigger: "blur" },
          {
            min: 5,
            max: 12,
            message: "长度在 5 到 12 个字符",
            trigger: "blur",
          },
        ],
        passWord: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 5, max: 16, message: "长度在 5 到 16个字符", trigger: "blur" },
        ],
        role:[
          {required:true,trigger: "blur"}
        ]
      },
    };
  },
  created() {
    let account = sessionStorage.getItem("userId");
    let password = sessionStorage.getItem("passWord");
    let role = sessionStorage.getItem("role");
    // 如果存在赋值给表单，并且将记住密码勾选
    if (account) {
      this.loginForm.userId = account;
      this.loginForm.passWord = password;
      this.loginForm.remember = true;
      this.loginForm.role = role;
    }
  },
  methods: {
    submitForm() {
      let username = this.loginForm.userId;
      let password = this.loginForm.passWord;
      let role = this.loginForm.role;
      let that = this;
      console.log(role);
      axios({
        headers:{
          'deviceCode':'A95ZEF1-47B5-AC90BF3'
        },
        method:'post',
        url:'http://localhost:8080/exam/login',
        data:qs.stringify({
          username:username,
          password:password,
          role:role
      }),
      }).then(function(response){
        if(response.data.code==1){
          // window.alert("登录成功！");
          let user = response.data.data;
          // console.log(user);
          that.$store.commit("add",user);
          console.log(that.$store.state.user)
          if(role == 0){
            that.$router.push("/admin");
          }else if(role == 1){
            that.$router.push("/student")
          }else{
            that.$router.push("/teacher")
          }
        }
      }).catch(function(err){
        window.alert("账号或者密码输入错误");
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    registerBtn() {
      let role = this.loginForm.role;
      if(role == 0){
        window.alert("管理员不可注册！");
        $("#zhuce").removeClass("disabled");
      }else if(role == 1){
        this.$router.push({path:"register",query:{role:"1"}});
      }else if(role == 2){
        this.$router.push({path:"register",query:{role:"2"}});
      }
    },
  },
};
</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
.el-form-item__content {
  line-height: 5px;
}

.el-form-item__label {
  font-size: 18px;
  font-weight: bold;
}

.el-button{
  margin-right: 60px;
}

.el-divider {
  background-color: rgb(180, 174, 174);
  margin-left: 120px;
}

h3 {
  text-align: center;
  margin-bottom: 10px;
}

.background {
  width: 100%;
  /* height: 800px; */
  background-size: 100% 100%;
  position: fixed;
  z-index: -1;
}

.content {
  height: 350px;
  width: 700px;
  position: absolute;
  top: 25%;
}

.login {
  position: absolute;
  top: 50%;
  left: 50%;
  opacity: 0.9;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  width: 360px;
  padding: 16px;
  border-radius: 15px;
  box-shadow: 5px 5px 5px #b5b5b6;
  background-color: rgb(246, 250, 250);
}
body{
      width: 1520px;
			background-image: url("../assets/background.jpg");
			background-size: 100%;
      /* height: 1000px; */
      background-repeat: cover;
			/* opacity: 0.8; */
		}

.el-form {
  font-size: 25px;
  font-weight: bold;
}

h2{
  text-align: center;
}

</style>