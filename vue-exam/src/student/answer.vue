<template>
  <!-- 主体 -->
  <el-main>
    已答卷
    <el-table
      :data="
        tableData.filter(
          (data) => !search || data.name.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column label="开始时间" prop="starttime"> </el-table-column>
      <el-table-column label="试卷名称" prop="title"> </el-table-column>
      <el-table-column label="发起人" prop="name"> </el-table-column>
      <el-table-column label="阅卷状态" prop="ystate"> </el-table-column>
      <el-table-column label="提交时间" prop="submittime"> </el-table-column>
      <el-table-column label="得分" prop="score"> </el-table-column>
      <el-table-column align="right">
        <template #header>
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <template v-slot="scope">
          <el-button size="mini" type="success" 
          v-if="scope.row.ystate == true"
          @click="view(scope.$index, scope.row)"
            >查看试卷</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </el-main>
</template>

<script>
import axios from "axios";
import qs from "querystring";
export default {
  name: "notAnswer",
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    seeRow(index, rows) {
      rows.splice(index, 1);
    },
    view(index, row) {
      console.log(row);
      console.log(row.shijuanid);
      let _this = this;
      let shijuanid = row.shijuanid;
      let stno = this.$store.state.user.stno;
      let s = {
        stno: stno,
        shijuanid: shijuanid,
      };
      axios
        .post("http://localhost:8080/exam/student/view", qs.stringify(s))
        .then(function (response) {
          _this.$store.commit("insert", response.data.data);
          console.log(_this.$store.state.shijuanList);
          _this.$router.push("/student/shijuan");
        });
    },
  },
  data() {
    return {
      tableData: [],
      search: "",
    };
  },
  mounted() {
    let that = this;
    let stno = {
      stno: that.$store.state.user.stno,
    };
    axios
      .post("http://localhost:8080/exam/an/findAllAnswer", qs.stringify(stno), {
        Headers: {
          "Context-Type": "application/x-www-form-urlencoded",
        },
      })
      .then(function (response) {
        let choice = response.data;
        console.log(choice);
        that.tableData = JSON.parse(JSON.stringify(choice));
      });
  },
};
</script>

<style scoped>
.el-table {
  height: 600px;
}
.el-main {
  /* width: 1200px; */
  height: 658px;
}
</style>
