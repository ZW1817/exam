<template>
<div class="students">
  <el-main >
  <el-table :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%">
    <el-table-column label="学号" prop="stno" >
    </el-table-column>
    <el-table-column label="姓名" prop="name" />
    <el-table-column label="性别" prop="sex" />
    <el-table-column label="班级" prop="classname" />
    <el-table-column label="专业" prop="zhuanye" />
    <el-table-column label="联系方式" prop="tell" />
    <el-table-column label="家庭住址" prop="address" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        
        <el-button size="small" @click="updateStu(scope.$index, scope.row)">修改</el-button>
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.row)"
          >删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  </el-main>
  </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'

export default {
    name:"student",
      methods: {
        handleEdit(index,row){
          console.log(index);
          console.log(row);
        },
        handleDelete(row){
          let that = this;
          let stno = row.stno;
          this.$confirm("确定要删除该学生吗！",{
            confirmButtonText:"确定",
            cancelButtonText: '取消',
            type:"warning"
          }).then(() => {
            axios({
            headers:{
              'deviceCode':'A95ZEF1-47B5-AC90BF3'
            },
            method:'post',
            url:'http://localhost:8080/exam/sysUser/deleteStudent',
            data:qs.stringify({
              stno:stno
        }),
        }).then(function(response){
          if(response.data.code==1){
            window.alert(response.data.msg);
            that.$router.push("/admin");
          }
        })
          .catch(function(err){
          window.alert("删除异常");
        })
        .catch(() => {
          this.$message({
            type:"info",
            message:"已取消"
          })
        });
      })   
      },
      updateStu(index,row){
        let stno = row.stno;
        this.$router.push({path:"/admin/sedit",query:{stu:stno}});
        // this.$store.commit("modifyStu",row);
        // this.$router.push("/admin/sedit");
      }
      },
    data() {
      return {
        tableData: [],
         search: '',
      }
    },
    mounted(){
      let that = this;
      console.log(this);
      axios.post("http://localhost:8080/exam/sysUser/findStudent",{
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
    height: 600px;
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 100px;
    height: 660px;
}
.student{
  width: 1200px;
  height: 600px;
  float:left;
}
</style>