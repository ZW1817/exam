<script >
export default {
  name:'HelloWorld',
  data() {
    return {
      sname:"",
          options : [
      {
        value: 'Option1',
        label: 'Option1',
      },
      {
        value: 'Option2',
        label: 'Option2',
      },
      {
        value: 'Option3',
        label: 'Option3',
      },
      {
        value: 'Option4',
        label: 'Option4',
      },
      {
        value: 'Option5',
        label: 'Option5',
      },
    ],
    value:"",
    tableData :[{
      status:1,
      date: '2016-05-03',
      name: 'Tom',
      city: 'Los Angeles',
      address: 'No. 189, Grove St, Los Angeles',
      score: 'Home',
  },
  {
    status:2,
    date: '2016-05-02',
    name: 'Tom',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    score: 'Office',
  },
  {
    status:3,
    date: '2016-05-04',
    name: 'Tom',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    score: 'Home',
  },
  {
    status:3,
    date: '2016-05-01',
    name: 'Tom',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    score: 'Office',
  }]
    }
  },
}
 

</script>

<template>
  <el-main>
    <el-row>
      <el-col :span="24"><div class="grid-content ep-bg-purple-dark" > <label >班级:</label>
            <el-select v-model="value" class="m-2" placeholder="Select">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
        </el-select>
        <label>姓名:</label>
        <el-input v-model="sname" style="width:300px" ></el-input>  
        <el-button type="primary" >查询</el-button></div></el-col>
    </el-row> 
    <el-row>
      <el-col :span="24">
        <div class="grid-content ep-bg-purple" >
          <el-table :data="tableData" style="width: 1000px;max-height:1000px">
              <el-table-column prop="status" label="序号" width="180" />
              <el-table-column prop="date" label="学号" width="180" />
              <el-table-column prop="name" label="班级" width="180" />
              <el-table-column prop="address" label="专业" width="180"/>
              <el-table-column prop="city" label="政治面貌" width="180" />
              <el-table-column prop="score" label="成绩" width="180" />
          </el-table>
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<style scoped>

</style>
