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
import tedit from '../admin/TEditComponent.vue'
import sedit from '../admin/SEditComponent.vue'
import updatePass1 from '../admin/updatePassword.vue'


// =====================
import Head2 from '../student/header.vue'
import Aside2 from '../student/aside.vue'


// =====================
import Head3 from '../teacher/Head.vue'
import Aside3 from '../teacher/aside.vue'

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
            { path: "tedit", components: { default: tedit, top: Head1, left: Aside1 } },
            { path: "sedit", components: { default: sedit, top: Head1, left: Aside1 } },
            { path: "updatePass", components: { default: updatePass1, top: Head1, left: Aside1 } },
            { path: "dajuan", components: { default: import ('../student/dajuan.vue'), top: Head1, left: Aside1 } },
        ]

    },

    // =======student======
    {
        path: '/student',
        children: [
            { path: "", components: { default: import ('../student/notAnswer.vue'), top: Head2, left: Aside2 } },
            { path: "answer", components: { default: import ('../student/answer.vue'), top: Head2, left: Aside2 } },
            { path: "personalData", components: { default: import ('../student/personalData.vue'), top: Head2, left: Aside2 } },
            { path: "doTi", components: { default: import ('../student/doTi.vue'), top: Head2, left: Aside2 } },
            { path: "updatePassword", components: { default: import ('../student/updatePassword.vue'), top: Head2, left: Aside2 } },
        ]
    },

    // =======teacher======
    {
        path: '/teacher',
        children: [
            { path: "", components: { default: import ('../teacher/Student.vue'), top: Head3, left: Aside3 } },
            { path: "zujuan", components: { default: import ('../teacher/Zujuan.vue'), top: Head3, left: Aside3 } },
            { path: "dajuan", components: { default: import ('../teacher/dajuan.vue'), top: Head3, left: Aside3 } },
            { path: "selectTable", components: { default: import ('../teacher/selectAndUpdataTi/1-1.vue'), top: Head3, left: Aside3 } },
            { path: "judgeTable", components: { default: import ('../teacher/selectAndUpdataTi/1-2.vue'), top: Head3, left: Aside3 } },
            { path: "fillTable", components: { default: import ('../teacher/selectAndUpdataTi/1-3.vue'), top: Head3, left: Aside3 } },
            { path: "simpleTable", components: { default: import ('../teacher/selectAndUpdataTi/1-4.vue'), top: Head3, left: Aside3 } },
            { path: "addSelect", components: { default: import ('../teacher/insertTi/insertOne.vue'), top: Head3, left: Aside3 } },
            { path: "addJudge", components: { default: import ('../teacher/insertTi/insertTwo.vue'), top: Head3, left: Aside3 } },
            { path: "addFill", components: { default: import ('../teacher/insertTi/insertThree.vue'), top: Head3, left: Aside3 } },
            { path: "addSimple", components: { default: import ('../teacher/insertTi/insertFour.vue'), top: Head3, left: Aside3 } },
            { path: "updateSelect", components: { default: import ('../teacher/updateTi/updateOne.vue'), top: Head3, left: Aside3 } },
            { path: "updateJudge", components: { default: import ('../teacher/updateTi/updateTwo.vue'), top: Head3, left: Aside3 } },
            { path: "updateFile", components: { default: import ('../teacher/updateTi/updateThree.vue'), top: Head3, left: Aside3 } },
            { path: "updateSimple", components: { default: import ('../teacher/updateTi/updateFour.vue'), top: Head3, left: Aside3 } },
            { path: "zhanghu", components: { default: import ('../teacher/zhanghushezhi.vue'), top: Head3, left: Aside3 } },
            { path: "Student", components: { default: import ('../teacher/Student.vue'), top: Head3, left: Aside3 } },
            { path: "modify", components: { default: import ('../teacher/updatePassword.vue'), top: Head3, left: Aside3 } }
        ]

    },

]
const router = createRouter({
    history: createWebHistory(),
    routes, // `routes: routes` 的缩写
})


export default router