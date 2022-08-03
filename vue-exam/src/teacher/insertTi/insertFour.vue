<template>
  <el-main>
    <el-form :model="form" :rules="baserules" :ref="baseForm" label-width="120px">
      <el-form-item label="题目">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="答案">
        <el-input v-model="form.daan" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="createJianda">Create</el-button>
        <el-button @click="cancel">Cancel</el-button>
      </el-form-item>
    </el-form>
  </el-main>
</template>

<script>
import axios from "axios";
import qs from "querystring";
export default {
  name: "insertFour",
  data() {
    return {
      form: {
        title: "",
        daan: "",
      },
      baserules: {
        title: [{ required: true, message: "请输入题目", trigger: "blur" }],
        daan: [{ required: true, message: "请输入正确答案", trigger: "blur" }],
      },
    };
  },
  methods: {
    createJianda() {
      this.$refs.baseForm.validate((valid) => {
        if (valid) {
          let formdata = null;
          formdata = this.form;
          axios
            .post("http://localhost:8080/exam/jianda/insert", qs.stringify(formdata), {
              // withCredentials: true,
              headers: {
                "Content-Type": "application/x-www-form-urlencoded",
              },
            })
            .then(function (response) {
              console.log(response);
              if (response.data == 1) {
                window.alert("添加成功");
              } else {
                window.alert("添加失败");
              }
            })
            .catch(function (err) {
              window.alert("服务器无响应，请重试！");
            });
        } else {
          return false;
        }
      });
    },
    cancel() {
      this.$router.push("/teacher/simpleTable");
    },
  },
};
</script>
