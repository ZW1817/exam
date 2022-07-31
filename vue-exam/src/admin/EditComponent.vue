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
      <el-form-item label="编号" prop="id">
        <!-- <el-input  :disabled="true"/> -->
        <el-input v-model="ruleForm.id" />
        </el-form-item>
        
        <el-form-item label="姓名" prop="realname">
        <el-input v-model="ruleForm.realname" />
        </el-form-item>

        <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username" />
        </el-form-item>
    
    </el-col>
    <el-col :span="8">
        <el-form-item label="性别" prop="sex">
        <el-input v-model="ruleForm.sex" />
        </el-form-item>

        <el-form-item label="联系方式" prop="tell">
        <el-input v-model="ruleForm.tell" />
        </el-form-item>

    </el-col>

    <el-col :span="8">
      <el-row>
      <el-col :span="7">
      </el-col>
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
    <el-form-item label="描述" prop="desc">
      <el-input v-model="ruleForm.desc" type="textarea" />
    </el-form-item>

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
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'

//上传头像
// import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import type { UploadProps } from 'element-plus'
const formSize = ref('default')

export default{
  data(){
    return{
      ruleForm:
        'user'
    
    }
  },
  mounted(){
    this.ruleForm = this.$store.state.user;
  }
}
const ruleFormRef = ref<FormInstance>()

const rules = reactive<FormRules>({
  username: [
    { required: true, message: 'Please input username', trigger: 'blur' },
    { min: 3, max: 5, message: '长度 3 to 5', trigger: 'blur' },
  ],
   sex: [
    { required: true, message: 'Please input sex', trigger: 'blur' },
    { min: 1, max: 1, message: '必须是男女', trigger: 'blur' },
  ],
  tell: [
    { required: true, message: 'Please input tell', trigger: 'blur' },
  ],
  realname: [
    { required: true, message: 'Please input realname', trigger: 'blur' },
    { min: 3, max: 5, message: '长度 3 to 5', trigger: 'blur' },
  ],
  
  count: [
    {
      required: true,
      message: 'Please select Activity count',
      trigger: 'change',
    },
  ],
  date1: [
    {
      type: 'date',
      required: true,
      message: 'Please pick a date',
      trigger: 'change',
    },
  ],
  date2: [
    {
      type: 'date',
      required: true,
      message: 'Please pick a time',
      trigger: 'change',
    },
  ],
  type: [
    {
      type: 'array',
      required: true,
      message: 'Please select at least one activity type',
      trigger: 'change',
    },
  ],
  resource: [
    {
      required: true,
      message: 'Please select activity resource',
      trigger: 'change',
    },
  ],
  desc: [
    { required: true, message: 'Please input activity form', trigger: 'blur' },
  ],
})

const updateSubmitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!', fields)
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

const options = Array.from({ length: 10000 }).map((_, idx) => ({
  value: `${idx + 1}`,
  label: `${idx + 1}`,
}))

const imageUrl = ref('')

const handleAvatarSuccess: UploadProps['onSuccess'] = (
  response,
  uploadFile
) => {
  imageUrl.value = URL.createObjectURL(uploadFile.raw!)
}

const beforeAvatarUpload: UploadProps['beforeUpload'] = (rawFile) => {
  if (rawFile.type !== 'image/jpeg') {
    ElMessage.error('Avatar picture must be JPG format!')
    return false
  } else if (rawFile.size / 1024 / 1024 > 2) {
    ElMessage.error('Avatar picture size can not exceed 2MB!')
    return false
  }
  return true
}
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
.el-main{
    height: 600px;
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 100px;
    height: 660px;
}
.demo-ruleForm{
  padding-inline: 10px;
  margin-top: 30px;
}
</style>
