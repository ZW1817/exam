<script>
import axios from 'axios';
import { now } from 'lodash';
import qs from 'qs'
export default {
    name: "zujuan",
    data() {
        return {
            ruleForm: {
                form: [{
                    qtype: 0,
                    title: "java",
                    tnum: 10,
                    score: 2,
                }, {
                    "qtype": 1,
                    title: "java",
                    tnum: 10,
                    score: 2,
                }, {
                    qtype: 2,
                    title: "java",
                    tnum: 10,
                    score: 3,
                }, {
                    qtype: 3,
                    title: "java",
                    tnum: 3,
                    score: 10,
                },
                ],
                shijuanname: "",
                date: [],
            },
            rules: {
                date: [
                    { required: true, message: '请选择日期', trigger: 'change' },
                ],
                shijuanname: [
                    { required: true, message: '请输入试卷名', trigger: 'blur' },
                    { min: 9, max: 20, message: '长度在 9到 20 个字符', trigger: 'blur' }
                ]
            },
            total: 0,
            // pickerOptions: {
            //     disabledDate(time) {
            //         return time.getTime() < Date.now() - 8.64e7
            //     }
            // }
        }
    },
    methods: {
        // sub() {
        //     let zujuans = this.ruleForm.form
        //     console.log(zujuans);
        //     console.log(JSON.stringify(this.ruleForm.form));
        //     let shijuanname = this.ruleForm.shijuanname;
        //     console.log(shijuanname);
        //     console.log(JSON.stringify(this.ruleForm.shijuanname));
        //     for (let i = 0; i < zujuans.length; i++) {
        //         this.total += zujuans[i].tnum * zujuans[i].score
        //     }
        //     let total = this.total
        //     console.log(total);
        //     console.log(JSON.stringify(this.total));
        //     let tno = this.$store.state.user.tno
        //     let shijuanLists = {
        //         zujuans, shijuanname, total, tno
        //     }
        //     console.log(shijuanLists);
        //     console.log(JSON.stringify(shijuanLists))
        //     // axios.headers.post['Content-Type'] = 'application/json';
        //     // axios.defaults.headers.post['Content-Type'] = 'application/json';
        //     axios.post("http://localhost:8080/exam/paperstate/zujuan",
        //         // JSON.stringify(this.form)
        //         //参数列表
        //         // JSON.stringify(this.form),
        //         JSON.stringify(shijuanLists)
        //         ,
        //         //请求头配置   
        //         {
        //             headers: { 'Content-Type': 'application/json' }
        //         }
        //     ).then((req) => {
        //         if (req.data = 1) {
        //             alert("添加成功")
        //             that.$router.push("/teacher");
        //         }
        //     })

        // },
        getBirthDate(val) {
            this.ruleForm.date = val
        },
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    let zujuans = this.ruleForm.form
                    let shijuanname = this.ruleForm.shijuanname;
                    for (let i = 0; i < zujuans.length; i++) {
                        this.total += zujuans[i].tnum * zujuans[i].score
                    }
                    let total = this.total
                    let tno = this.$store.state.user.tno
                    let date = this.ruleForm.date
                    let ShijuanLists = {
                        zujuans, shijuanname, total, tno,date
                    }
                    let that=this;
                    console.log(this.ruleForm.date);
                    axios.post("http://localhost:8080/exam/paperstate/zujuan", JSON.stringify(ShijuanLists) , {
                            headers: { 'Content-Type': 'application/json' }
                        }).then((req) => {
                            if (req.data == 1) {
                                alert("添加成功")
                                that.$router.push("/teacher");
                            }
                        })
                } 
                else {
                    console.log('error submit!!');
                    return false;
                }
            });
        }
    },
}
</script>

<template>
    <div class="left">
        <el-main>
            <el-row>
                <div class="grid-content ep-bg-purple-dark">
                    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px">
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>选择题型</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[0].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[0].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[0].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>填空题型</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[1].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[1].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[1].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>判断题型</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[2].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[2].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[2].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>简答题型</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[3].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[3].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="ruleForm.form[3].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>

                        <el-form-item label="考试时间" required>
                            <el-col :span="24">
                                <el-form-item prop="date">
                                    <el-date-picker type="datetimerange" placeholder="选择日期" v-model="ruleForm.date"
                                        style="width: 100%;" format="YYYY-MM-DD HH:mm:ss"
                                        value-format="YYYY-MM-DD HH:mm:ss" range-separator="至" start-placeholder="开始时间"
                                        end-placeholder="结束时间">
                                    </el-date-picker>
                                </el-form-item>
                            </el-col>
                        </el-form-item>

                        <el-form-item label="试卷名" prop="shijuanname" required>
                            <el-input v-model="ruleForm.shijuanname" />
                        </el-form-item>
                        <el-button type="success" @click="submitForm('ruleForm')">组卷</el-button>
                    </el-form>
                </div>
            </el-row>
        </el-main>
    </div>
</template>

<style scoped>
.left {
    width: 1200px;
    height: 600px;
    margin-left: 0;
    float: left;
}
</style>