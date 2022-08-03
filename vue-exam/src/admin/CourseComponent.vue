<script lang="ts">
import axios from "axios";
import qs from "qs";

export default {
  name: "App",

  methods: {
    open() {
      this.drawer = true;
    },
    handleDelete(index, row) {
      let that = this;
      let id = row.id;
      axios({
        headers: {
          deviceCode: "A95ZEF1-47B5-AC90BF3",
        },
        method: "post",
        url: "http://localhost:8080/exam/sysUser/deleteCourse",
        data: qs.stringify({
          id: id,
        }),
      }).then(function (response) {
        if (response.data.code == 1) {
          window.alert(response.data.msg);
          that.$router.push("/admin/course");
        }
      });
    },
    onClick(){
      // let id = this.form.id;
      let name = this.form.name;
      
      axios({
        headers:{
          'deviceCode':'A95ZEF1-47B5-AC90BF3'
        },
        method:'post',
        url:'http://localhost:8080/exam/sysUser/insertCourse',
        data:qs.stringify({
          name:name
        }),
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
  },
  data() {
    return {
      tableData: [],
      search: "",
      drawer: false,
      currentPage: 1,
      pageSize: 5,
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
    };
  },
  mounted() {
    let that = this;
    console.log(this);
    axios
      .post("http://localhost:8080/exam/sysUser/findKemu", {
        Headers: {
          "Context-Type": "application/x-www-form-urlencoded",
        },
      })
      .then(function (response) {
        let choice = response.data;
        that.tableData = JSON.parse(JSON.stringify(choice));
      });
  },
  
};
</script>

<template>
  <el-main>
    <el-button @click="drawer = true" type="primary" style="margin-left: 16px">
      添加课程
    </el-button>
    <el-drawer title="我是标题" v-model="drawer" direction="ltr" :with-header="false">
      <div class="demo-drawer__content">
        <el-form :model="form">
          <el-form-item label="课程号" :label-width="formLabelWidth">
            <el-input v-model="form.id" autocomplete="off" />
          </el-form-item>
          <el-form-item label="课程名称" :label-width="formLabelWidth">
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
      <el-table-column label="课程号" prop="id" />
      <el-table-column label="课程名称" prop="name" />
      <el-table-column align="right">
        <template #header>
          <el-input
            v-model="search"
            size="small"
            placeholder="输入关键字搜索..."
          />
        </template>
        <template #default="scope">
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


<style scoped>
.el-table {
  height: 490px;
}

.el-main {
  width: 1200px;
}
</style>