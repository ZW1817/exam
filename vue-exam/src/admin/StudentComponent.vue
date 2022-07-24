<template>
  <el-main>
  <el-table :data="filterTableData" style="width: 100%" height:600px>
    <el-table-column label="学号" prop="stno" >
    </el-table-column>
    <el-table-column label="姓名" prop="name" />
    <el-table-column label="性别" prop="sex" />
    <el-table-column label="班级" prop="className" />
    <el-table-column label="专业" prop="zhuanye" />
    <el-table-column label="联系方式" prop="mobile" />
    <el-table-column label="家庭住址" prop="address" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >修改</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  </el-main>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

interface User {
  stno: string
  name: string
  sex: string
  className:String
  zhuanye:String
  mobile:String
  address:String
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
    '您确定要删除该学生吗？',
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
    stno: "20181302012",
    name: "张三",
    sex: "男",
    className:"信管",
    zhuanye:"信息管理与信息系统",
    mobile:"18167988989",
    address:"陕西省",
  },
  {
    stno: "20181302012",
    name: "张四",
    sex: "男",
    className:"计算机",
    zhuanye:"计算机科学与技术",
    mobile:"18167988989",
    address:"陕西省",
  },
  {
    stno: "20181302012",
    name: "张五",
    sex: "女",
    className:"计算机",
    zhuanye:"计算机科学与技术",
    mobile:"18167988989",
    address:"陕西省",
  },
  {
    stno: "20181302012",
    name: "张六",
    sex: "女",
    className:"信管",
    zhuanye:"信息管理与信息系统",
    mobile:"18167988989",
    address:"陕西省",
  },

]
</script>
<style scoped>
.el-table{
    height: 620px;
}
.el-main{
    width: 1200px;
    height: 540px;
}
</style>