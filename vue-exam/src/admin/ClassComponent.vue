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

  <el-table :data="tableData.slice((currentPage - 1) * pageSize, currentPage * pageSize)" style="width: 100%">
    <el-table-column label="班级编号" prop="id" />
    <el-table-column label="班级名称" prop="name" />
    <el-table-column label="教师" prop="teachername" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-button
          size="small"
          type="primary"
          @click="update(scope.row)"
          >修改</el-button
        >
<!-- 修改弹框 -->
      <el-drawer title="我是标题" v-model="drawer1" direction="ltr" :with-header="false">
      <div class="demo-drawer__content">
        <el-form :model="teaform">
          
          <el-form-item label="请选择教师" prop="teacherName">
          <el-select v-model="teaform.depatmen" size="mini" placeholder="请选择" @change="conntno($event)">
            <el-option v-for="item in depss" :key="item.id" :label="item.teachername" :value="item.teachername"></el-option>
          
          </el-select>
          </el-form-item>
          <el-form-item label="请选择教师号" prop="tno">
          <el-select v-model="teaform.depatment" size="mini" placeholder="请选择" @change="conntname($event)">
            <el-option v-for="item in depss" :key="item.id" :label="item.tno" :value="item.tno"></el-option>
          </el-select>
        </el-form-item>
          <div class="demo-drawer__footer">
        <el-button @click="cancelForm">取消</el-button>
        <el-button type="primary" :loading="loading" @click="onClick1">{{
          loading ? 'Submitting ...' : '提交'
        }}</el-button>
      </div>
        </el-form>
      </div>
    </el-drawer>

        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
        :current-page="currentPage"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="tableData.length"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="[2, 5, 10, 15]"
      >    
      </el-pagination>
</el-main>
</template>

<script>
import axios from 'axios';
import qs from 'qs'
export default {
    name:"teacher",
      methods: {
        // open() {
        //   this.drawer = true;
        // },
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
        },
        handleSizeChange(val) {
          this.pageSize = val;
        },
        handleCurrentChange(val) {
          this.currentPage = val;
        },
        onClick1(){
          this.drawer1 = false;
          let tno = this.teaform.depatment;
          let id = this.teaform.id;
          console.log(tno);
          console.log(id);
          let c = {
            tno:tno,
            id:id
          }
         axios({
          headers:{
            deviceCode: "A95ZEF1-47B5-AC90BF3",
          },
          method:'post',
          url:'http://localhost:8080/exam/sysUser/updateClass',
          data:qs.stringify(c),
        }).then(function(response){
          if(response.data.code==1){
            window.alert(response.data.msg);
          }
        }).catch(function(err){
          window.alert("操作异常");
        })
        },
        cancelForm(){
          this.drawer1 = false;
        },

        // 下拉框双向联动
        conntno(value){
          let i = 0;
          for(i=0;i<this.depss.length;i++){
            if(this.depss[i].teachername == value){
              this.teaform.depatment = this.depss[i].tno;
              break;
            }
          }
        },
        conntname(value){
          let i = 0;
          for(i=0;i<this.depss.length;i++){
            if(this.depss[i].tno == value){
              this.teaform.depatmen = this.depss[i].teachername;
              break;
            }
          }
        },
      update(row){
        this.drawer1 = true;
        this.teaform.id = row.id;
      }
},
    data() {
      return {
        tableData: [],
         search: '',
         drawer: false,
         drawer1:false,
         
         currentPage: 1,
         pageSize: 5,
         
         teaform:{
           id:"",
           tno:"",
           depatment:"",
           depatmen:"",
           depss:[],
         },
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
        that.tableData = JSON.parse(JSON.stringify(choice));
        that.depss = JSON.parse(JSON.stringify(choice))
      })
    },

    }

</script>
<style scoped>
.el-table{
    height: 490px;
}

.el-main{
    width: 1200px;
}
.demo-drawer__content{
  margin-top: 40px;
}
</style>