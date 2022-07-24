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
                           {{ scope.row.Dstatus ==1 ? '已答卷' : '未答卷' }}
                        </template>
                    </el-table-column>
                    <el-table-column prop="Ystatus" label="阅卷状态" width="180" >
                        <template v-slot="scope" >
                           {{ scope.row.Ystatus ==1 ? '已阅卷' : '未阅卷' }}
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="180" >
                    <template v-slot="scope" >
                        <el-button type="primary" v-if="scope.row.Dstatus==1&&scope.row.Ystatus==0" @click="yue">阅卷</el-button>
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
   export default {
    name:'dajuan',
    data() {
        return {
            dajuan:[{
                tindex:15,
                title:'java',
                banji:'1班',
                stno:12345674,
                Sscore:0,
                Dstatus:1,
                Ystatus:1,
            },{
                tindex:14,
                title:'java',
                banji:'1班',
                stno:12345674,
                Sscore:0,
                Dstatus:1,
                Ystatus:0,
            },{
                tindex:13,
                title:'java',
                banji:'1班',
                stno:12345674,
                Sscore:0,
                Dstatus:1,
                Ystatus:1,
            },{
               tindex:12,
                title:'java',
                banji:'1班',
                stno:12345674,
                Sscore:0,
                Dstatus:1,
                Ystatus:0,
            }]
        }
    },methods: {
        yue(){
            this.Sstatus=true
            console.log(this.Sstatus);
        }
    },
}
</script>