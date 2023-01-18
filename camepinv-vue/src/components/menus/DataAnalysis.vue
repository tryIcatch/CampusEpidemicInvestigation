<template>
  <div class="chart-box">
    <div id="pie" style="width: 800px;height:380px;"></div>
    <div id="bar" style="width:800px;height:380px;"></div>
  </div>


  <div class="position-fixed bottom-0 right-0 p-3" style="z-index: 5; right: 0; bottom: 0;">
    <div id="liveToast"  :class="isShow" role="alert" aria-live="assertive" aria-atomic="true" data-delay="2000" ref="ishow">
      <div class="toast-header">
        <img src="../../assets/提示.png" class="rounded mr-2" alt="..."  style="width:20px;height:20px">
        <strong class="mr-auto">学生健康状况建议</strong>
        <small>刚刚</small>
        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close" @click="hiden">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="toast-body" ref="content" id="content">

      </div>
    </div>
  </div>




</template>

<script>
import * as echarts from 'echarts';
import {onMounted, ref} from "vue";
import axios from "axios";
export default {
  name: "DataAnalysis",
  data(){
    return {
      isShow:"toast hide"

    }
  },
  methods:{
    hiden(){
     document.getElementById("liveToast").className="toast hide"
    }
  },
  created() {
  },
  setup() {
    let main = ref(null)
    let content= ref(null)
    let ishow= ref(null)


    // 需要在生命周期获取
    onMounted(()=>{
      var myPie = echarts.init(document.getElementById('pie'));
      var myBar= echarts.init(document.getElementById('bar'));
      var BarData=""
      var Bars=[]
      var BarNums=[]

      var PieData=""
      var Pies=[]
      var PieNums=[]
      var PieDatas=[]

      var  healthdata=0
      var  total=0


      axios.get("/analysis").then(({data:res})=>{
        BarData=res.data

      }).finally(()=>{
        for (let i = 0; i <BarData.length ; i++) {
          Bars.push(BarData[i].date)
          BarNums.push(BarData[i].num)
        }
        myBar.setOption(
            {
              xAxis: {
                type: 'category',
                data: Bars,
              },
              yAxis: {
                type: 'value'
              },
              series: [
                {
                  data: [2,2,2,3],
                  type: 'bar',
                  showBackground: true,
                  backgroundStyle: {
                    color: 'rgba(180, 180, 180, 0.2)'
                  }
                }
              ]
            }
        )
      })
      axios.get("/analysis/healthnum").then(({data:res})=>{
        PieData=res.data
      }).finally(()=>{

        for (let i = 0; i <PieData.length ; i++) {
          Pies.push(PieData[i].health)
          PieNums.push(PieData[i].num)
          total+=PieData[i].num
          if(PieData[i].health==="健康" || PieData[i].health==="良好"){
            healthdata+=PieData[i].num
          }
        }


        for (let i = 0; i <Pies.length ; i++) {
          let obj={}
          obj["value"]=PieNums[i]
          obj["name"]=Pies[i]
          PieDatas.push(obj)
        }
        if(healthdata>total-healthdata){
          document.getElementById("liveToast").className="toast show"
          document.getElementById("content").innerHTML="健康人数占多数,建议让健康学生先入校"
        }else {
          document.getElementById("liveToast").className="toast show"
          document.getElementById("content").innerHTML="生病人数占多数，建议推迟返校"
        }

        myPie.setOption(
            {
              title: {
                text: '学生健康状况分析图',
                left: 'center'
              },
              tooltip: {
                trigger: 'item'
              },
              legend: {
                orient: 'vertical',
                left: 'left'
              },
              series: [
                {
                  type: 'pie',
                  radius: '50%',
                  data:PieDatas,
                  emphasis: {
                    itemStyle: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                  }
                }
              ]
            }
        )
      })

      window.addEventListener('resize', function() {
        myBar.resize();
        myPie.resize();
      });
    })
    return {main ,content ,ishow };
  },

};

</script>

<style scoped>
body {
  width: 100%;
}
.chart-box{
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>