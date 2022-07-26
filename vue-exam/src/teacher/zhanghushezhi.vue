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
        <el-col :span="8">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" />
          </el-form-item>

          <el-form-item label="职称" prop="zhicheng">
            <el-input v-model="ruleForm.zhicheng" />
          </el-form-item>

          <el-form-item label="性别" prop="sex">
            <el-input v-model="ruleForm.sex" />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="学位" prop="xueli">
            <el-input v-model="ruleForm.xueli" />
          </el-form-item>

          <el-form-item label="民族" prop="nation">
            <el-input v-model="ruleForm.nation" />
          </el-form-item>

          <el-form-item label="籍贯" prop="jiguan">
            <el-input v-model="ruleForm.jiguan" />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-row>
            <el-col :span="7"> </el-col>
            <el-col :span="1">
              <el-upload
                class="avatar-uploader"
                action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
              >
                <img v-if="imageUrl" :src="imageUrl" class="avatar" />
                <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
              </el-upload>
            </el-col>
          </el-row>
        </el-col>
      </el-row>

      <el-form-item label="" required>
        <el-col :span="10">
          <!-- <el-form-item prop="date1">
          <el-date-picker
            v-model="ruleForm.date1"
            type="date"
            label="Pick a date"
            placeholder="Pick a date"
            style="width: 100%"
          /> -->
          <!-- </el-form-item> -->
        </el-col>
      </el-form-item>
      <el-row>
        <el-col :span="11">
          <el-form-item label="电话" prop="tell">
            <el-input v-model="ruleForm.tell" />
          </el-form-item>
        </el-col>
        <el-col :span="11">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="ruleForm.email" />
          </el-form-item>
        </el-col>
      </el-row>

      <el-form-item label="主修" prop="major">
        <el-input v-model="ruleForm.major" />
      </el-form-item>

      <el-form-item label="介绍" prop="jieshao">
        <el-input v-model="ruleForm.jieshao" type="textarea" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="updateSubmitForm(ruleFormRef)"
          >修改</el-button
        >
        <el-button @click="resetForm()">重置</el-button>
      </el-form-item>
    </el-form>
  </el-main>
</template>

<script lang="ts">
import axios from 'axios'
import qs from 'querystring'
import { reactive, ref } from "vue";
import type { FormInstance, FormRules } from "element-plus";

import { mapState } from "vuex";
export default {
  computed: mapState({
    ruleForm: 'user'
    // ruleForm:'u.profile.items'
  }),

  methods: {
    updateSubmitForm(){
      let that = this;
      let d = this.ruleForm;
      let s ={
         tno:d.tno,
         name:d.name,
         zhicheng:d.zhicheng,
        xueli:d.xueli,
        nation:d.nation,
        jiguan:d.jiguan,
        tell:d.tell,
        email:d.email,
        major:d.major,
        jieshao:d.jieshao,
      }
      axios.post("http://localhost:8080/exam/teacher/update",qs.stringify(s),
          {
            // withCredentials: true,
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          }
      ).then(
        function(reponse){
          window.alert(reponse.data.msg);
          if(reponse.data.data == 1){
            that.$store.commit('add',d);
          }
        }
      ).catch(function(err){
        window.alert("服务器已崩溃")
      })
      
    }
  },
//   mounted() {
//     console.log(this.$store.state.user);
//     console.log(this.ruleForm);

//     // this.ruleForm = this.$store.state.user;
    
//   // this.$store.commit('add',sessionStorage.getItems("user"));
//   // this.ruleForm = this.$store.state.user;
//   // }
// };
}

//上传头像
// import { ref } from 'vue'
import { ElMessage } from "element-plus";
import { Plus } from "@element-plus/icons-vue";
import type { UploadProps } from "element-plus";
const formSize = ref("default");

const ruleFormRef = ref<FormInstance>();

const rules = reactive<FormRules>({
  youxiang: [
    { required: true, message: "Please input Activity name", trigger: "blur" },
  ],
  name: [
    { required: true, message: "Please input Activity name", trigger: "blur" },
    { min: 3, max: 5, message: "长度 3 to 5", trigger: "blur" },
  ],
  sex: [
    { required: true, message: "Please input Activity name", trigger: "blur" },
    { min: 1, max: 1, message: "必须是男女", trigger: "blur" },
  ],
  zhicheng: [
    { required: true, message: "请输入职称", trigger: "blur" },
    { min: 3, max: 10, message: "职称尽量写得简洁", trigger: "blur" },
  ],
  xuewei: [
    { required: true, message: "请输入职称", trigger: "blur" },
    { min: 2, max: 6, message: "重新填写职位", trigger: "blur" },
  ],
  region: [
    {
      required: true,
      message: "Please select Activity zone",
      trigger: "change",
    },
  ],
  count: [
    {
      required: true,
      message: "Please select Activity count",
      trigger: "change",
    },
  ],
  // date1: [
  //   {
  //     type: 'date',
  //     required: true,
  //     message: 'Please pick a date',
  //     trigger: 'change',
  //   },
  // ],
  date2: [
    {
      type: "date",
      required: true,
      message: "Please pick a time",
      trigger: "change",
    },
  ],
  type: [
    {
      type: "array",
      required: true,
      message: "Please select at least one activity type",
      trigger: "change",
    },
  ],
  resource: [
    {
      required: true,
      message: "Please select activity resource",
      trigger: "change",
    },
  ],
  desc: [
    { required: true, message: "Please input activity form", trigger: "blur" },
  ],
});

const updateSubmitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log("submit!");
    } else {
      console.log("error submit!", fields);
    }
  });
};

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.resetFields();
};

const options = Array.from({ length: 10000 }).map((_, idx) => ({
  value: `${idx + 1}`,
  label: `${idx + 1}`,
}));

const imageUrl = ref("");

const handleAvatarSuccess: UploadProps["onSuccess"] = (
  response,
  uploadFile
) => {
  imageUrl.value = URL.createObjectURL(uploadFile.raw!);
};

const beforeAvatarUpload: UploadProps["beforeUpload"] = (rawFile) => {
  if (rawFile.type !== "image/jpeg") {
    ElMessage.error("Avatar picture must be JPG format!");
    return false;
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error("Avatar picture size can not exceed 2MB!");
    return false;
  }
  return true;
};
</script>

<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
.flex-grow {
  flex-grow: 1;
}
</style>
