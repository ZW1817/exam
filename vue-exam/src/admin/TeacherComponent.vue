<template>
<el-main>
  <el-table :data="filterTableData" style="width: 100%" height:600px>
    <el-table-column label="教师编号" prop="tno" />
    <el-table-column label="姓名" prop="name" />
    <el-table-column label="性别" prop="sex" />
    <el-table-column label="主教学科" prop="major" />
    <el-table-column label="籍贯" prop="jiguan" />
    <el-table-column label="学历" prop="xueli" />
    <el-table-column label="职称" prop="zhicheng" />
    <el-table-column label="联系方式" prop="tel" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-row>
          <el-col :span="12">
            <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >修改</el-button
        >
          </el-col>
          <el-col :span="12">
            <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
          </el-col>
        </el-row>
        
        
      </template>
    </el-table-column>
  </el-table>
 </el-main>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

interface User {
  tno: string
  name: string
  sex: string
  major:String
  jiguan:String
  xueli:String
  zhicheng:String
  tel:String
}

const search = ref('')
const filterTableData = computed(() =>
  tableData.filter(
    (data) =>
      !search.value ||
      data.name.toLowerCase().includes(search.value.toLowerCase())
  )
)
const handleEdit = (index: number, row: User) => {
  console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
  ElMessageBox.confirm(
    '您确定要删除该老师吗？',
    'Warning',
    {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning',
    }
  )
    .then(() => {
      ElMessage({
        type: 'success',
        message: '删除成功',
      })
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: '取消删除',
      })
    })
  console.log(index, row)
}

const tableData: User[] = [
  {
    tno: "t2018001",
    name: "张老师",
    sex: "男",
    major:"java",
    jiguan:"陕西省",
    xueli:"博士",
    zhicheng:"副教授",
    tel:"18979897979"
  },
  {
    tno: "t2018002",
    name: "张老师",
    sex: "男",
    major:"c语言",
    jiguan:"甘肃省",
    xueli:"博士",
    zhicheng:"教授",
    tel:"18979897979"
  },
]
</script>
<style scoped>
.el-table{
    height: 620px;
}
.el-main{
    width: 1200px;
}

</style>