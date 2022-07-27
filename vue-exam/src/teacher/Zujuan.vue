<script>
import axios from 'axios';
import qs from 'qs'
export default {
    name: "zujuan",
    data() {
        return {
            form: [{
                qtype: 0,
                title: "java",
                tnum: 10,
                score: 2,
            }, {
                qtype: 1,
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
            }],
            shijuanname: "",
            total: 0
        }
    },
    methods: {
        sub() {
            let zujuans = this.form
            console.log(zujuans);
            console.log(JSON.stringify(this.form));
            let shijuanname = this.shijuanname;
            console.log(shijuanname);
            console.log(JSON.stringify(this.shijuanname));
            for(let i=0;i<zujuans.length;i++){
                this.total+=zujuans[i].tnum*zujuans[i].score
            }
            let total = this.total
            console.log(total);
            console.log(JSON.stringify(this.total));
            let tno = this.$store.state.user.tno
            let shijuanLists = {
                zujuans,shijuanname, total,tno
            }
            console.log(shijuanLists);
            console.log(JSON.stringify(shijuanLists))
            // axios.headers.post['Content-Type'] = 'application/json';
            // axios.defaults.headers.post['Content-Type'] = 'application/json';
            axios.post("http://localhost:8080/exam/paperstate/zujuan",
                // JSON.stringify(this.form)
                //参数列表
                // JSON.stringify(this.form),
                JSON.stringify(shijuanLists)
                ,
                //请求头配置   
                {
                    headers: { 'Content-Type': 'application/json' }
                }
            )
            .then((req)=>{
                if(req.data=1){
                    alert("添加成功")
                }
            })
        }
    },
}
</script>

<template>
    <div class="left">
        <el-main>
            <el-row>
                <div class="grid-content ep-bg-purple-dark">
                    <el-form :model="form" label-width="120px">
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>选择题型</label>
                                <el-col :span="6">
                                    <el-input v-model="form[0].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="form[0].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="form[0].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>填空题型</label>
                                <el-col :span="6">
                                    <el-input v-model="form[1].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="form[1].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="form[1].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>判断题型</label>
                                <el-col :span="6">
                                    <el-input v-model="form[2].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="form[2].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="form[2].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>
                        <el-form-item>
                            <el-row :gutter="20">
                                <label>简答题型</label>
                                <el-col :span="6">
                                    <el-input v-model="form[3].title" label="题型" placeholder="java" disabled />
                                </el-col>
                                <label>题目个数</label>
                                <el-col :span="6">
                                    <el-input v-model="form[3].tnum" label="题目个数" placeholder="10" />
                                </el-col>
                                <label>分值</label>
                                <el-col :span="6">
                                    <el-input v-model="form[3].score" label="分值" placeholder="10" />
                                </el-col>
                            </el-row>
                        </el-form-item>
                        <el-form-item label="试卷名">
                            <el-input v-model="shijuanname" />
                        </el-form-item>
                        <el-button type="success" @click="sub">组卷</el-button>
                    </el-form>
                </div>
            </el-row>
            <!-- <el-row>
        <el-col :span="24">
            <div class="grid-content ep-bg-purple-dark" >
            <el-form :model="form" label-width="120px">

                <el-form-item label="题型">
                <el-input v-model="form.title" />
                </el-form-item>

                <el-form-item label="出题个数">
                <el-input-number v-model="form.qtype"></el-input-number> 
                </el-form-item>

                <el-form-item label="分值">
                <el-input-number v-model="form.gander" ></el-input-number> 
                </el-form-item>
                <el-form-item>
                <el-button type="primary" @click="onSubmit">Create</el-button>
                <el-button>Cancel</el-button>
                </el-form-item>
            </el-form>
            </div>
        </el-col>
      </el-row>
      <el-button type="success" @click="sub">提交题型</el-button> -->
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