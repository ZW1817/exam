<template>
<el-main>
<el-form :model="form" label-width="120px">
    <el-form-item label="题目">
      <el-input v-model="form.title" />
    </el-form-item>
    <el-form-item label="正确答案">
      <el-input v-model="form.daan" />
    </el-form-item>
  </el-form>
</el-main>
</template>

<script>

export default {
    name:'insertThree',
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