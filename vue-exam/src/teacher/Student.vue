<script>
import axios from "axios";
export default {
  name: "HelloWorld",
  beforeMount() {
    this.findAll();
  },
  data() {
    return {
      sname: "",
      options: [
        {
          value: "Option1",
          label: "Option1",
        },
        {
          value: "Option2",
          label: "Option2",
        },
        {
          value: "Option3",
          label: "Option3",
        },
        {
          value: "Option4",
          label: "Option4",
        },
        {
          value: "Option5",
          label: "Option5",
        },
      ],
      value: "",
      studentData: [
        {
          id: 0,
          stno: "",
          name: "",
          classname: "",
          zhuanye: "",
        },
      ],
    };
  },
  methods: {
    findAll() {
      axios.post("http://localhost:8080/exam/student/findALL").then((req) => {
        console.log(req.data);
        this.studentData = req.data;
      });
    },
  },
};
</script>

<template>
  <el-main>
    <el-row>
      <el-col :span="24"
        ><div class="grid-content ep-bg-purple-dark">
          <label>班级:</label>
          <el-select v-model="value" class="m-2" placeholder="Select">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
          <label>姓名:</label>
          <el-input v-model="sname" style="width: 300px"></el-input>
          <el-button type="primary">查询</el-button>
        </div></el-col
      >
    </el-row>
    <el-row>
      <el-col :span="24">
        <div class="grid-content ep-bg-purple">
          <el-table :data="studentData" style="width: 100%; margin-top: 30px">
            <el-table-column prop="id" label="序号" width="180" />
            <el-table-column prop="stno" label="学号" width="180" />
            <el-table-column prop="name" label="学生姓名" width="180" />
            <el-table-column prop="classname" label="学生班级" width="180" />
            <el-table-column prop="zhuanye" label="学生专业" width="180" />
          </el-table>
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<style scoped></style>
