<template>
  <el-main>
    <h2>答卷查询</h2>
    <el-row>
      <el-col :span="24">
        <div class="grid-content ep-bg-purple-dark">
          <!-- <el-table :data="dajuan" style="width: 100%; margin-top: 30px"> -->
          <el-table :data="dajuan" style="width: 100%">
            <el-table-column label="序号" width="100" />
            <el-table-column prop="title" label="试卷名" width="180" />
            <el-table-column prop="banji" label="班级" width="100" />
            <el-table-column prop="stno" label="学号" width="180" />
            <el-table-column prop="Sscore" label="学生成绩" width="120" />
            <el-table-column prop="Dstatus" label="答卷状态" width="180">
              <template v-slot="scope">
                {{ scope.row.Dstatus ? "已答卷" : "未答卷" }}
              </template>
            </el-table-column>
            <el-table-column prop="Ystatus" label="阅卷状态" width="180">
              <template v-slot="scope">
                {{ scope.row.Ystatus ? "已阅卷" : "未阅卷" }}
              </template>
            </el-table-column>
            <el-table-column label="操作" width="180">
              <template v-slot="scope">
                <el-button
                  type="primary"
                  v-if="scope.row.Dstatus == 1 && scope.row.Ystatus == 0"
                  @click="yue(scope.row)"
                  >阅卷</el-button
                >
                <el-button
                  type="success"
                  v-if="scope.row.Dstatus == 1 && scope.row.Ystatus == 1"
                  @click="view(scope.$index, scope.row)"
                  >查看试卷</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<style></style>

<script>
import axios from "axios";
import qs from "querystring";
export default {
  name: "dajuan",
  data() {
    return {
      dajuan: [],
    };
  },
  methods: {
    yue(row) {
      let that = row;
      let _this = this;
      console.log(row);

      let stno = that.stno;
      let shijuanid = that.id;
      axios
        .post(
          "http://localhost:8080/exam/teacher/yue",
          qs.stringify({
            stno: stno,
            shijuanid: shijuanid,
          })
        )
        .then((req) => {
          // that.Ystatus = true;
          console.log(req.data.data);
          _this.$store.commit("insert", req.data.data);
          _this.$router.push("/teacher/yuejuan");
        });
    },
    view(index, row) {
      console.log(row);
      console.log(row.shijuanid);
      let _this = this;
      let that = row;

      let stno = that.stno;
      let shijuanid = that.id;
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
    findAll() {
      axios.post("http://localhost:8080/exam/paperstate/findALL").then((req) => {
        console.log(req.data);
        this.dajuan = req.data;
      });
    },
  },
  beforeMount() {
    this.findAll();
  },
};
</script>
