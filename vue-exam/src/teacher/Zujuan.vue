<script>
   export default {
    name:"zujuan",
    data() {
        return {
            ttnum:1,
            ganderset:1,
            zujuan:[{
                status:1,
                tixing:"java",
                tnum:5,
                gander:100,
            }],
        }
    },
   }
</script>

<template>
    <el-main >
     <el-row>
        <el-col :span="24">
            <div class="grid-content ep-bg-purple-dark" >
                <el-table :data="zujuan" style="width: 1000px;max-height:1000px">
                    <el-table-column prop="status" label="序号" width="180" />
                    <el-table-column prop="tixing" label="题型" width="180" />
                    <el-table-column prop="tnum" label="出题个数" width="180" >
                        <el-input-number v-model="ttnum"></el-input-number> 
                    </el-table-column>
                    <el-table-column prop="gander" label="分值" width="180" >
                        <el-input-number v-model="ganderset" ></el-input-number> 
                    </el-table-column>
                </el-table>
            </div>
        </el-col>
      </el-row>
    </el-main>
</template>

<style>

</style>