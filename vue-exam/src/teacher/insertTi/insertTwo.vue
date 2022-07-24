<template>
<el-main>
<el-form :model="form" label-width="120px">
    <el-form-item label="题目">
      <el-input v-model="form.title" />
    </el-form-item>
    <el-form-item label="答案">
      <el-radio-group v-model="form.daan">
        <el-radio label="正确" />
        <el-radio label="错误" />
      </el-radio-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</el-main>
</template>
<script>

export default {
    name:'insertTwo',
    data(){
        return{
            form:{
                title: '',
                daan:''
            }
        }     
    },
    methods:{
            onsubmit(){
                console.log('submit!')
            }
        }
}
</script>