<template>
    <el-main >
     <el-row>
        <el-col :span="24">
            <div class="grid-content ep-bg-purple-dark" >
                <el-table :data="dajuan" v-model="dajuan" style="width: 100%">
                    <el-table-column prop="status" label="序号" width="180" />
                    <el-table-column prop="tixing" label="名称" width="180" />
                    <el-table-column prop="banji" label="班级" width="180" />
                    <el-table-column prop="sno" label="学号" width="180" />
                    <el-table-column prop="Sstatus" label="状态" width="180" >
                        <template v-slot="scope" >
                           {{ scope.row.Sstatus  ? '已阅卷' : '未阅卷' }}
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="180" >
                    <template v-slot="scope" >
                        <el-button type="primary" v-if="scope.row.Sstatus==0" @click="yue">阅卷</el-button>
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
                status:1,
                tixing:'java',
                banji:'1班',
                sno:12345674,
                Sstatus:true,
            },{
                status:2,
                tixing:'java2',
                banji:'2班',
                sno:12345676,
                Sstatus:false,
            },{
                status:3,
                tixing:'java2',
                banji:'2班',
                sno:12345675,
                Sstatus:true,
            },{
                status:4,
                tixing:'java2',
                banji:'2班',
                sno:12345674,
                Sstatus:false,
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