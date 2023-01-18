import {createRouter , createWebHashHistory} from "vue-router";
import Login from "@/components/Mylogin.vue";
import Home from "@/components/MyHome.vue";
import MyUsers from "@/components/menus/MyUsers.vue";
import MyGoods from "@/components/menus/MyGoods.vue";
import DataAnalysis from "@/components/menus/DataAnalysis.vue";
import MyOrders from "@/components/menus/MyOrders.vue";
import MySettings from "@/components/menus/MySettings.vue";
import MyUserDetail from "@/components/user/MyUserDetail.vue";
import StudentSubmit from "./components/menus/StudentSubmit.vue";
const router=createRouter({
    history:createWebHashHistory(),
    routes:[
        {path:'/',redirect:"/login"},
        {path:'/login',component:Login},
        {path:'/home',component:Home,name:"home",children:[
                {path:"users",component:MyUsers},
                {path:"goods",component:MyGoods},
                {path:"analysis",component:DataAnalysis},
                {path:"orders",component:MyOrders},
                {path:"settings",component:MySettings},
                {path:'users/:id',component:MyUserDetail,props:true},
            ],            redirect:'/home/users'

        },
        {path:"/studentsubmit",component:StudentSubmit},
        {path:"/home",component:Home}

    ]
})

router.beforeEach((to,from,next)=>{
    if(to.path === '/login') return next()
    const token =localStorage.getItem("token")
    if(!token){
        return next("/login")
    }
    next()
})
export default  router
