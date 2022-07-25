<template>
<el-main>
  <el-form :model="form" label-width="90px" style="margin-top:30px">
    <el-form-item label="标题">
      <el-input v-model="form.name" />
    </el-form-item>
    
    <el-form-item label="考试时间">
      <el-col :span="11">
        <el-date-picker
          v-model="form.date1"
          type="date"
          placeholder="开始时间"
          style="width: 100%"
        />
      </el-col>
      <el-col :span="2" class="text-center">
        <span class="text-gray-500">-</span>
      </el-col>
      <el-col :span="11">
        <el-time-picker
          v-model="form.date2"
          placeholder="结束时间"
          style="width: 100%"
        />
      </el-col>
    </el-form-item>
    <el-form-item label="内容">
      <el-input v-model="form.desc" type="textarea" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">确定</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
  </el-main>
</template>

<script lang="ts" setup>
import { reactive } from 'vue'

// do not use same name with ref
const form = reactive({
  name: '',
  date1: '',
  date2: '',
  desc: '',
})

const onSubmit = () => {
  console.log('submit!')
}

</script>
<style scoped>
.el-main{
    width: 1200px;
    height: 658px;
    background-color: aliceblue;
}
</style>
