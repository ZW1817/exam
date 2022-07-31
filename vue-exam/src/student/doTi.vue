<template>
  <div class="timeCount-container">
    <el-card class="box-card" id="asidecrad">
      <div slot="header" class="clearfix">
        <span>剩余时间</span>
      </div>
      <div>{{ this.hour }} 时 {{ this.minute }} 分 {{ this.second }} 秒</div>
    </el-card>
  </div>
  <!-- :model="ruleForm" -->
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
              {{ index + 1 }}、{{ item.title }} ({{ item.fenshu }} 分)
            </div>
            <el-radio-group v-model="item.choice">
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
              {{ index + 1 }}、{{ item.title }} ({{ item.fenshu }} 分)
            </div>
            <div>
              <input type="radio" value="正确" v-model="item.panduan" /><span>正确</span>
            </div>
            <div>
              <input type="radio" value="错误" v-model="item.panduan" /><span>错误</span>
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
            <el-input type="textarea" v-model="item.tiankong" />
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
            <el-input type="textarea" v-model="item.jianda" />
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

<script>
import axios from "axios";
import qs from "qs";
import { mapState } from "vuex";
export default {
  //  computed:mapState({
  //   ruleForm:this.$store.shijuanList
  // }),
  name: "timeCount",
  data() {
    return {
      endTime: 0,
      hour: 0,
      minute: 0,
      second: 0,
      interval: null,
      ruleForm: [],
      question: [],
    };
  },
  //传值
  props: {
    //倒计时时间
    longTime: {
      type: Number,
      default: 7200,
    },
    //弹出框标题
    messageTitle: {
      type: String,
      default: "通知",
    },
    //弹出框内容
    messageText: {
      type: String,
      default: "考试时间到了,请考生点击确定提交试卷",
    },
  },
  // mounted() {
  //   //结束时间
  //   this.endTime = Date.parse(new Date()) + this.longTime * 1000;
  //   //开始倒计时
  //   this.countdown();
  // },
  beforeDestroy() {
    //提前结束则销毁倒计时
    clearTimeout(this.interval);
  },
  methods: {
    countdown() {
      //计算运行时间
      const end = this.endTime;
      const now = Date.parse(new Date());
      const msec = end - now;
      //计算剩余时间
      this.second = (msec / 1000) % 60;
      this.minute = parseInt((msec / 1000 / 60) % 60);
      this.hour = parseInt(msec / 1000 / 60 / 60);

      // console.log(this.hour, this.minute, this.second);

      // console.log(msec);
      // console.log(this.question);
      const that = this;
      //结束则弹框
      if (msec === 0) {
        this.$alert(this.messageTitle, this.messageText, {
          confirmButtonText: "确定",
          callback: () => {
            that.submitForm();
            this.$router.push("/student");
          },
        });
      } else {
        //进入下一秒倒计时
        this.interval = setTimeout(that.countdown, 1000);
      }
    },
    submitForm() {
      let papers = this.ruleForm;
      let that = this;
      let stno = this.$store.state.user.stno;
      let paper = {
        papers,
        stno,
      };
      console.log(paper);
      axios({
        headers: {
          "Content-Type": "application/json",
        },
        method: "post",
        url: "http://localhost:8080/exam/student/submitTi",
        data: JSON.stringify(paper),
      })
        .then(function (response) {
          window.alert(response.data.msg);
          if (response.data.data == 1) that.$router.push("/student");
        })
        .catch(function (err) {
          window.alert("操作异常");
        });
    },
  },
  mounted() {
    //结束时间
    this.endTime = Date.parse(new Date()) + this.longTime * 1000;
    //开始倒计时
    this.countdown();
    console.log(this.$store.state.shijuanList);

    this.ruleForm = this.$store.state.shijuanList;
    console.log(this.ruleForm);
  },
};
</script>

<style scoped>
.timeCount-container {
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
  text-align: center;
}

.shijuan {
  background-color: rgb(233, 239, 244);
  width: 100%;
  height: 660px;
  color: black;
  line-height: 2em;
  text-align: left;
}

.el-card.is-always-shadow {
  position: fixed;
  top: 70px;
  left: 80%;
  background-color: beige;
  float: top;
  z-index: 1;
}
.el-from {
  margin-top: 100px;
}
</style>
