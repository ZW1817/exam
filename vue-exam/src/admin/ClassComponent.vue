<template>

<el-main>
<!-- 弹框 -->
  <el-button @click="drawer = true" type="primary" style="margin-left: 16px">
      添加班级
    </el-button>
    <el-drawer title="我是标题" v-model="drawer" direction="ltr" :with-header="false">
      <div class="demo-drawer__content">
        <el-form :model="form">
          <el-form-item label="班级id" :label-width="formLabelWidth">
            <el-input v-model="form.id" autocomplete="off" />
          </el-form-item>
          <el-form-item label="班级名称" :label-width="formLabelWidth">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <div class="demo-drawer__footer">
        <el-button @click="cancelForm">取消</el-button>
        <el-button type="primary" :loading="loading" @click="onClick">{{
          loading ? 'Submitting ...' : '提交'
        }}</el-button>
      </div>
        </el-form>
      </div>
    </el-drawer>

  <el-table :data="tableData" style="width: 100%">
    <el-table-column label="班级编号" prop="id" />
    <el-table-column label="班级名称" prop="name" />
    <el-table-column label="班主任" prop="tName" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-button
          size="small"
          type="primary"
          @click="dialog = true"
          >添加班级</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</el-main>
</template>

<script>
import axios from 'axios';
import qs from 'qs'
export default {
    name:"teacher",
      methods: {
        open() {
          this.drawer = true;
        },
        handleDelete(index,row){
          let that = this;
          let id = row.id;
          axios({
            headers:{
              'deviceCode':'A95ZEF1-47B5-AC90BF3'
            },
            method:'post',
            url:'http://localhost:8080/exam/sysUser/deleteClass',
            data:qs.stringify({
              id:id
            }),
        }).then(function(response){
          if(response.data.code==1){
            window.alert(response.data.msg);
            that.$router.push("/admin/classes");
          }
        })
        },
        onClick(){
      // let id = this.form.id;
      let name = this.form.name;
      let c = {
        name:name
      }
      axios({
        headers:{
          'Content-Type': 'application/json'
        },
        method:'post',
        url:'http://localhost:8080/exam/sysUser/insertClass',
        data:qs.stringify(c),
      }).then(function(response){
        if(response.data.code==1){
          window.alert(response.data.msg);
        }
      }).catch(function(err){
        window.alert("操作异常");
      })
    }
      },
    data() {
      return {
        tableData: [],
         search: '',
         drawer: false,
         form: {
          name:'',
          id: "",
          date1: "",
          date2: "",
          delivery: false,
          type: [],
          resource: "",
          desc: "",
      },
      }
    },
    mounted(){
      let that = this;
      console.log(this);
      axios.post("http://localhost:8080/exam/sysUser/findBanji",{
        Headers:{
          'Context-Type':'application/x-www-form-urlencoded'
        }
      }).then(function(response) {
        let choice = response.data;
        that.tableData = JSON.parse(JSON.stringify(choice))
      })
    }
    }

</script>
<style scoped>
.el-table{
    height: 620px;
}

.el-main{
    width: 1200px;
}
</style>