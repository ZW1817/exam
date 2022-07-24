<template>
<el-main>
<el-form :model="form" label-width="120px">
    <el-form-item label="题目" style="width:'100px';">
      <el-input v-model="form.title" />
    </el-form-item>
    <el-form-item label="正确答案">
      <el-input v-model="form.daan" />
    </el-form-item>
    <el-form-item label="选项A">
      <el-input v-model="form.choicea" />
    </el-form-item>
    <el-form-item label="选项B">
      <el-input v-model="form.choiceb" />
    </el-form-item>
    <el-form-item label="选项C">
      <el-input v-model="form.choicec" />
    </el-form-item>
    <el-form-item label="选项D">
      <el-input v-model="form.choiced" />
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
    name:'insertOne',
    data(){
        return{
            form:{
                title: '',
                daan: '',
                choicea: '',
                choiceb: '',
                choicec: '',
                choiced: '',
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

<style>
</style>