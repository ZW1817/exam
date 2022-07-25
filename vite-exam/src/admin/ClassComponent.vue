<template>
<el-main>
  <el-table :data="filterTableData" style="width: 100%" height:600px>
    <el-table-column label="班级编号" prop="id" />
    <el-table-column label="班级名称" prop="name" />
    <el-table-column label="班主任" prop="tName" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-button
          size="small"
          type="primary"
          @click="handleUpdate(scope.$index, scope.row)"
          >添加班级</el-button
        >
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
  id: string
  name: string
  tName: string
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
    '您确定要删除该班级吗？',
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
    id: "1",
    name: "信管",
    tName: "张老师",
  },
  {
    id: "2",
    name: "计算机一班",
    tName: "王老师",
  },
  {
    id: "3",
    name: "计算机二班",
    tName: "李老师",
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