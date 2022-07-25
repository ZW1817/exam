import { createRouter, createWebHistory } from 'vue-router'
import login from '../admin/LoginComponent.vue'
import register from '../admin/RegisterComponent.vue'
import students from '../admin/StudentComponent.vue'
import teachers from '../admin/TeacherComponent.vue'
import classes from '../admin/ClassComponent.vue'
import course from '../admin/CourseComponent.vue'
import notice from '../admin/NoticeComponent.vue'
import edit from '../admin/EditComponent.vue'
import Aside1 from '../admin/AsideComponent.vue'
import Head1 from '../admin/HeadComponent.vue'

// =====================
import doTi from '../student/doTi.vue'
import personalData from '../student/personalData.vue'
import Head2 from '../student/header.vue'
import Aside2 from '../student/aside.vue'
import answer from '../student/answer.vue'
import notAnswer from '../student/notAnswer.vue'

// =====================
import Student from '../teacher/Student.vue'
import Zujuan from '../teacher/Zujuan.vue'
import Dajuan from '../teacher/dajuan.vue'
import Head3 from '../teacher/Head.vue'
import Aside3 from '../teacher/aside.vue'
import zhanghu from '../teacher/zhanghushezhi.vue'

import selectTable from '../teacher/selectAndUpdataTi/1-1.vue'
import judgeTable from '../teacher/selectAndUpdataTi/1-2.vue'
import fillTable from '../teacher/selectAndUpdataTi/1-3.vue'
import simpleTable from '../teacher/selectAndUpdataTi/1-4.vue'

import addSelect from '../teacher/insertTi/insertOne.vue'
import addJudge from '../teacher/insertTi/insertTwo.vue'
import addFill from '../teacher/insertTi/insertThree.vue'
import addSimple from '../teacher/insertTi/insertFour.vue'

const routes = [{
        path: '/',
        component: login
    },
    {
        path: '/register',
        name: 'register',
        component: register
    },

    {
        path: '/admin',
        children: [
            { path: "", components: { default: students, top: Head1, left: Aside1 } },
            { path: "teachers", components: { default: teachers, top: Head1, left: Aside1 } },
            { path: "classes", components: { default: classes, top: Head1, left: Aside1 } },
            { path: "course", components: { default: course, top: Head1, left: Aside1 } },
            { path: "edit", components: { default: edit, top: Head1, left: Aside1 } },
            { path: "notice", components: { default: notice, top: Head1, left: Aside1 } },
        ]

    },

    // =======student======
    {
        path: '/student',
        children: [
            { path: "", components: { default: notAnswer, top: Head2, left: Aside2 } },
            { path: "answer", components: { default: answer, top: Head2, left: Aside2 } },
            { path: "personalData", components: { default: personalData, top: Head2, left: Aside2 } },
            { path: "doTi", components: { default: doTi, top: Head2, left: Aside2 } },
        ]

    },

    // =======teacher======
    {
        path: '/teacher',
        children: [
            { path: "", components: { default: Student, top: Head3, left: Aside3 } },
            { path: "zujuan", components: { default: Zujuan, top: Head3, left: Aside3 } },
            { path: "dajuan", components: { default: Dajuan, top: Head3, left: Aside3 } },
            { path: "selectTable", components: { default: selectTable, top: Head3, left: Aside3 } },
            { path: "judgeTable", components: { default: judgeTable, top: Head3, left: Aside3 } },
            { path: "fillTable", components: { default: fillTable, top: Head3, left: Aside3 } },
            { path: "simpleTable", components: { default: simpleTable, top: Head3, left: Aside3 } },
            { path: "addSelect", components: { default: addSelect, top: Head3, left: Aside3 } },
            { path: "addJudge", components: { default: addJudge, top: Head3, left: Aside3 } },
            { path: "addFill", components: { default: addFill, top: Head3, left: Aside3 } },
            { path: "addSimple", components: { default: addSimple, top: Head3, left: Aside3 } },
            { path: "zhanghu", components: { default: zhanghu, top: Head3, left: Aside3 } },
            { path: "Student", components: { default: Student, top: Head3, left: Aside3 } },
        ]

    },

]
const router = createRouter({
    history: createWebHistory(),
    routes, // `routes: routes` 的缩写
})


export default router