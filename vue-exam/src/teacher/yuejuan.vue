<template>
  <el-main>
    <div class="shijuan" v-if="ruleForm.length !== 0">
      <el-form v-model="ruleForm" ref="ruleForm">
        <div
          class="e-content"
          v-for="(item, index) in ruleForm"
          :key="item.relationsubject"
        >
          <div v-if="item.qtype == 0">
            <div class="e-top">
              {{ index + 1 }}、{{ item.title }} ({{
                item.fenshu
              }}
              分)&nbsp;&nbsp;&nbsp;&nbsp;得分：{{ item.defen }}
            </div>
            <div>
              学生答案：{{ item.daan }}&nbsp;&nbsp;&nbsp;&nbsp;正确答案：{{
                item.correct
              }}
            </div>
            <el-radio-group v-model="item.choice" disabled="true">
              <el-radio :label="'A'">{{ item.choicea }}</el-radio>
              <el-radio :label="'B'">{{ item.choiceb }}</el-radio>
              <el-radio :label="'C'">{{ item.choicec }}</el-radio>
              <el-radio :label="'D'">{{ item.choiced }}</el-radio>
            </el-radio-group>
          </div>
        </div>
        <div
          class="e-content"
          v-for="(item, index) in ruleForm"
          :key="item.relationsubject"
        >
          <div v-if="item.qtype == 1">
            <div class="e-top">
              {{ index + 1 }}、{{ item.title }} ({{
                item.fenshu
              }}
              分)&nbsp;&nbsp;&nbsp;&nbsp;得分：{{ item.defen }}
            </div>
            <div>
              学生答案：{{ item.daan }}&nbsp;&nbsp;&nbsp;&nbsp;正确答案：{{
                item.correct
              }}
            </div>
          </div>
        </div>
        <div
          class="e-content"
          v-for="(item, index) in ruleForm"
          :key="item.relationsubject"
        >
          <div v-if="item.qtype == 2">
            <div class="e-top">
              {{ index + 1 }}、{{ item.title }} ({{ item.fenshu }} 分)
            </div>
            <div>学生答案：{{ item.daan }}</div>
            <el-input-number v-model="item.defen" :min="0" :max="item.fenshu" />
          </div>
        </div>
        <div
          class="e-content"
          v-for="(item, index) in ruleForm"
          :key="item.relationsubject"
        >
          <div v-if="item.qtype == 3">
            <div class="e-top">
              {{ index + 1 }}、{{ item.title }} ({{ item.fenshu }} 分)
            </div>
            <div>学生答案：{{ item.daan }}</div>
            <el-input-number v-model="item.defen" :min="0" :max="item.fenshu" />
          </div>
        </div>
        <el-form-item>
          <el-button type="primary" @click="submitForm(ruleForm)" style="margin-top: 30px"
            >提交</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </el-main>
</template>

<style scoped>
.shijuan {
  background-color: rgb(233, 239, 244);
  width: 1200px;
  height: 660px;
  color: black;
  line-height: 2em;
  text-align: left;
}
</style>

<script>
import axios from "axios";
import qs from "querystring";
export default {
  name: "yuejuan",
  data() {
    return {
      ruleForm: [],
    };
  },
  methods: {
    submitForm(ruleForm) {
      let papers = ruleForm;
      let s = { papers };
      axios
        .post("http://localhost:8080/exam/teacher/yuejuan", JSON.stringify(s), {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(function (reponse) {
          window.alert(reponse.data.msg);
        });
    },
  },
  mounted() {
    this.ruleForm = this.$store.state.shijuanList;
    console.log(this.ruleForm);
    console.log(this.ruleForm.length);
  },
};
</script>
