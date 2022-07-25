<template>
<el-main>
  <el-table :data="filterTableData" style="width: 100%" height:600px>
    <el-table-column label="课程号" prop="id" />
    <el-table-column label="课程名称" prop="cName" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="输入关键字搜索..." />
      </template>
      <template #default="scope">
        <el-button
          size="small"
          type="primary"
          @click="handleUpdate(scope.$index, scope.row)"
          >添加课程</el-button
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
  cName: string
}

const search = ref('')
const filterTableData = computed(() =>
  tableData.filter(
    (data) =>
      !search.value ||
      data.cName.toLowerCase().includes(search.value.toLowerCase())
  )
)
const handleEdit = (index: number, row: User) => {
  console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
  ElMessageBox.confirm(
    '您确定要删除该课程吗？',
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
    id: "1896537557001",
    cName: "erp",
  },
  {
    id: "1896757897002",
    cName: "python",
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