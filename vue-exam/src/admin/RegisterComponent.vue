<template>
  <body>
    <div class="login">
      <el-form
        :model="registerForm"
        status-icon
        :rules="rules"
        ref="registerForm"
        label-width="130px"
        class="demo-loginForm"
      >
        <h1 class="title" style="padding-top: 20px; margin-bottom: 10px">
          注册页面
        </h1>
        <el-form-item label="姓 名" prop="userId">
          <el-input
            type="text"
            v-model="registerForm.userId"
            autocomplete="off"
            placeholder="请输入姓名"
            input-style="width:240px"
          ></el-input>
        </el-form-item>
        <el-form-item label="密 码" prop="passWord">
          <el-input
            type="password"
            v-model="registerForm.passWord"
            autocomplete="off"
            placeholder="请输入密码"
            input-style="width:240px"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="repassWord">
          <el-input
            type="password"
            v-model="registerForm.repassWord"
            autocomplete="off"
            placeholder="请输入密码"
            input-style="width:240px"
          ></el-input>
        </el-form-item>

        <el-form-item label="请选择班级" prop="banjiName" v-if="this.role==1">
          <el-select v-model="registerForm.depatment" size="mini" placeholder="请选择">
            <el-option v-for="item in depss" :key="item.id" :label="item.name" :value="item.name"></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="请选择班级" prop="banjiName">
          <el-select  v-model="registerForm.depatment" multiple filterable size="small" >
            <el-option v-for="(item,index) in depss" :key="item.id" :label="item.name" :value="item.name">{{ item.name }}</el-option>
          </el-select>
        </el-form-item> -->

        <el-form-item label="验证码" prop="sidentify">
          <el-input
            v-model="registerForm.sidentify"
            style="width: 50%; float: left"
            autocomplete="off"
            placeholder="请输入验证码"
          />
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
import axios from "axios";
import qs from "qs";
export default {
  name: "register",
  data() {
    let checkPwd = (rule, value, callback) => {
      if (value.trim().length == 0) {
        callback("请输入确认密码");
      } else if (value != this.registerForm.passWord) {
        callback("两次密码输入不一致");
      } else {
        callback();
      }
    };
    const sidentify = (rule, value, callback) => {
      let newVal = value.toLowerCase();
      let identifyStr = this.identifyCode.toLowerCase();
      if (newVal === "") {
        callback(new Error("请输入验证码"));
      } else if (newVal !== identifyStr) {
        callback(new Error("验证码不正确"));
      } else {
        callback();
      }
    };
    return {
      role: "",
      identifyCodes: "1234567890ABCDEFGHIGKLMNoPQRSTUVWXYZ",
      identifyCode: "", //验证码
      registerForm: {
        userId: "",
        passWord: "",
        repassWord: "",
        depatment:"",
        sidentify: "",
        remember: false,
      },
      depss:[],
      rules: {
        userId: [
          { required: true, message: "请输入姓名", trigger: "blur" },
          { min: 2, max: 4, message: "长度为2-4", trigger: "blur" },
        ],
        passWord: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 5, max: 16, message: "长度为5-12", trigger: "blur" },
        ],
        repassWord: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 5, max: 16, message: "长度为5-12", trigger: "blur" },
          { validator: checkPwd, required: true, trigger: "blur" },
        ],
        sidentify: [{ required: true, validator: sidentify, trigger: "blur" }],
        banjiName:[
          {required: true, message: "请选择班级", trigger: "blur" }
        ]
      },
    };
  },
  components: {
    SIdentify: SIdentify,
  },
  mounted() {
    this.identifyCode = "";
    this.makeCode(this.identifyCodes, 4);
    this.role = this.$route.params.role;
    console.log(this.role);
    this.handleChange();
    console.log(this.role);
  },
  methods: {
    // 生成随机数
    randomNum(min, max) {
      return Math.floor(Math.random() * (max - min) + min);
    },
    // 生成四位随机验证码
    makeCode(o, l) {
      for (let i = 0; i < l; i++) {
        this.identifyCode +=
          this.identifyCodes[this.randomNum(0, this.identifyCodes.length)];
      }
    },
    // 切换验证码
    refreshCode() {
      this.identifyCode = "";
      this.makeCode(this.identifyCodes, 4);
    },
    //注册表单==============
    submitForm() {
      let username = this.registerForm.userId;
      let password = this.registerForm.passWord;
      let zhuanye = this.registerForm.depatment;
      // console.log(zhuanye);
      let role = this.role;
      console.log(role);
      let newVal = this.registerForm.sidentify.toLowerCase();
      let identifyStr = this.identifyCode.toLowerCase();
      let that = this;
      if (newVal === "") {
        callback(new Error("请输入验证码"));
      } else if (newVal === identifyStr) {
        // callback(new Error('验证码不正确'))
        axios({
          headers: {
            "Context-Type": "application/x-www-form-urlencoded;Charset=UTF-8",
          },
          method: "post",
          url: "http://localhost:8080/exam/sign",
          data: qs.stringify({
            username: username,
            password: password,
            zhuanye:zhuanye,
            role: role,
          }),
        }).then(function (response) {
          if (response.data != null) {
            let no = response.data;
            window.alert("注册成功！您的登录账号为：" + no);
            that.$router.push("/");
          } else if (response.data == 0) {
            window.alert("注册失败！");
          }
        });
      } else {
        // callback(new Error('验证码不正确'))
        window.alert("验证码不正确");
      }
    },
    returnLogin() {
      this.$router.push("/");
    },
    handleChange() {
      let that = this;
      axios
        .post("http://localhost:8080/exam/banji", {
          Headers: {
            "Context-Type": "application/x-www-form-urlencoded",
          },
        })
        .then(function (response) {
          let banji = response.data;
          that.depss = JSON.parse(JSON.stringify(banji));
        });
    },
  },
};
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

.el-button {
  margin-right: 40px;
}

body {
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