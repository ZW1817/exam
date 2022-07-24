import { createRouter, createWebHashHistory } from 'vue-router'
import login from '../admin/LoginComponent.vue'
import register from '../admin/RegisterComponent.vue'
import adminPage from '../admin/AdminPage.vue'
import students from '../admin/StudentComponent.vue'
import teachers from '../admin/TeacherComponent.vue'
import classes from '../admin/ClassComponent.vue'
import course from '../admin/CourseComponent.vue'
import notice from '../admin/NoticeComponent.vue'
import edit from '../admin/EditComponent.vue'

// =====================
import doTi from '../student/doTi.vue'
import personalData from '../student/personalData.vue'
import stuShow from '../student/studentShow.vue'
import answer from '../student/answer.vue'
import notAnswer from '../student/notAnswer.vue'

// =====================
import teacherShow from '../teacher/teacherShow.vue'
import Teacher from '../teacher/Teacher.vue'
import Zujuan from '../teacher/Zujuan.vue'
import Dajuan from '../teacher/dajuan.vue'
import Zhanghushezhi from '../teacher/zhanghushezhi.vue'

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
        name: 'login',
        component: login
    },
    {
        path: '/register',
        name: 'register',
        component: register
    },
    {
        path: '/adminPage',
        name: 'adminPage',
        component: adminPage,
        children: [{
                path: 'students',
                component: students
            },
            {
                path: "teachers",
                component: teachers
            },
            {
                path: "classes",
                component: classes
            },
            {
                path: "course",
                component: course
            },
            {
                path: "edit",
                component: edit
            },
            {
                path: 'notice',
                component: notice
            },

        ]
    },

    // =======student======
    {
        path: '/stuShow',
        name: 'stuShow',
        component: stuShow,
        children: [{
                path: 'notAnswer',
                component: notAnswer
            },
            {
                path: "answer",
                component: answer
            },
            {
                path: "doTi",
                component: doTi
            },
            {
                path: "personalData",
                component: personalData
            }
        ]
    },

    // =======teacher======
    {
        path: '/teacherShow',
        component: teacherShow,
        children: [{
                path: 'teacher',
                component: Teacher
            },
            {
                path: 'Zujuan',
                component: Zujuan
            },
            {
                path: 'dajuan',
                component: Dajuan
            },
            {
                path: 'selectTable',
                component: selectTable
            },
            {
                path: 'judgeTable',
                component: judgeTable
            },
            {
                path: 'fillTable',
                component: fillTable
            },
            {
                path: 'simpleTable',
                component: simpleTable
            },
            {
                path: "addSelect",
                component: addSelect
            },
            {
                path: "addJudge",
                component: addJudge
            },
            {
                path: "addFill",
                component: addFill
            },
            {
                path: 'addSimple',
                component: addSimple
            },
            {
                path: 'Zhanghushezhi',
                component: Zhanghushezhi
            }
        ]
    },

]

const router = createRouter({
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})


export default router