<template>
    <el-main >
     <h2>答卷查询</h2>
     <el-row>
        <el-col :span="24">
            <div class="grid-content ep-bg-purple-dark" >
                <el-table :data="dajuan" style="width: 100%;margin-top: 30px;">
                    <el-table-column prop="tindex" label="序号" width="180" />
                    <el-table-column prop="title" label="试卷名" width="180" />
                    <el-table-column prop="banji" label="班级" width="180" />
                    <el-table-column prop="stno" label="学号" width="180" />
                    <el-table-column prop="Sscore" label="学生成绩" width="180" />
                    <el-table-column prop="Dstatus" label="答卷状态" width="180" >
                         <template v-slot="scope" >
                           {{ scope.row.Dstatus ? '已答卷' : '未答卷' }}
                        </template>
                    </el-table-column>
                    <el-table-column prop="Ystatus" label="阅卷状态" width="180" >
                        <template v-slot="scope" >
                           {{ scope.row.Ystatus ? '已阅卷' : '未阅卷' }}
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="180" >
                    <template v-slot="scope" >
                        <el-button type="primary" v-if="scope.row.Dstatus==1&&scope.row.Ystatus==0" @click="yue(scope.row)">阅卷</el-button>
                    </template>
                    </el-table-column>
                </el-table>
            </div>
        </el-col>
      </el-row>
    </el-main>
</template>

<style>

</style>

<script>
import axios from 'axios';
   export default {
    name:'dajuan',
    data() {
        return {
            dajuan:[
                // {
                // tindex:1,
                // title:'',
                // banji:'',
                // stno:0,
                // Sscore:0,
                // Dstatus:true,
                // Ystatus:true,
                // }
            ]
        }
    },
    methods: {
        yue(row){
            console.log(row);
            this.Sstatus=true
            console.log(this.Sstatus);
        },
        findAll(){
          axios.post('http://localhost:8080/exam/paperstate/findALL')
            .then((req)=>{
              console.log(req.data);
              this.dajuan=req.data;
            })  
        }
    },
    beforeMount(){
        this.findAll();
    },
}
</script>