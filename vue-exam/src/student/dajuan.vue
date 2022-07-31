<template>
<div class="shijuan" v-if="question.length !== 0">
<el-form :model="ruleForm" ref="ruleForm">
    <div class="e-content" v-for="(item,index) in question" :key="item.relationsubject">
        <div v-if="item.qtype==0">
        <div class="e-top">
            {{index+1}}、{{item.title}}
        </div>
        <div><input type="radio" name ='choice'/>{{item.choicea}}</div>
        <div><input type="radio" name ='choice'/>{{item.choiceb}}</div>
        <div><input type="radio" name ='choice'/>{{item.choicec}}</div>
        <div><input type="radio" name ='choice'/>{{item.choiced}}</div>
        </div>
    </div>
    <div class="e-content" v-for="(item,index) in question" :key="item.relationsubject">
        <div v-if="item.qtype==1">
        <div class="e-top">{{index+1}}、{{item.title}}</div>
        <div><input type="radio" name ='panduan'/>正确</div>
        <div><input type="radio" name ='panduan'/>错误</div>
        </div>
    </div>
    <div class="e-content" v-for="(item,index) in question" :key="item.relationsubject">
        <div v-if="item.qtype==2">
        <div class="e-top">{{index+1}}、{{item.title}}</div>
        <el-input type="textarea" />
        </div>
    </div>
    <div class="e-content" v-for="(item,index) in question" :key="item.relationsubject">
        <div v-if="item.qtype==3">
        <div class="e-top">{{index+1}}、{{item.title}}</div>
        <el-input type="textarea" />
        </div>
    </div>
    <el-form-item>
        <el-button type="primary" @click="submitForm(ruleForm)" style="margin-top:30px">提交</el-button>
    </el-form-item>
</el-form>
</div>
</template>

<script lang="ts">
import axios from 'axios'
import { reactive } from 'vue'
import qs from 'qs'
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})

export default{
    name:"shijuan",
    data() {
      return {
        ruleForm:[],
        question: [
        {
            // "answeroptions": 
            choicea:"A.选项一",
            choiceb:"B.选项二",
            choicec:"C.选项三",
            choiced:"D.选项四",
            qtype:"0",
            title: "通常所说的主机是指∶"
        },
        {
            qtype:"1",
            title: "软件与程序的区别是∶"
        },
        {
            "title": "简述orcle和mysql数据库的区别：",
            qtype:"2",
        },
         {
            "title": "springMVC：",
            qtype:"3",
        },
        ],
      }
      
    },
   methods:{
	submitForm(){
        let dajuan = this.ruleForm;
        let that = this;
        let dajuanModel = {
            stno:this.$store.state.user.stno,
            dajuan:dajuan
        }
        axios({
            headers:{
              'deviceCode':'A95ZEF1-47B5-AC90BF3'
            },
            method:'post',
            url:'http://localhost:8080/exam/student/update',
            data:qs.stringify(dajuanModel),
        }).then(function(response){
          if(response.data.code==1){
            window.alert(response.data.msg);
          }
        })
          .catch(function(err){
          window.alert("操作异常");
        })
    }
   },
    mounted(){
      let that = this;
      console.log(this);
      axios.post("http://10.0.3.91:8080/exam/student/findAllTi",{
        Headers:{
          'Context-Type':'application/x-www-form-urlencoded'
        }
      }).then(function(response) {
        let questions = response.data;
        that.question = JSON.parse(JSON.stringify(questions))
      })
    }
}


const onSubmit = () => {
  console.log('submit!')
}
</script>

<style scoped>
.shijuan{
    background-color: aliceblue;
    width: 1200px;
    margin-left: 300px;
    height: 650px;
}
.el-from{
    margin-top: 100px;
}
</style>