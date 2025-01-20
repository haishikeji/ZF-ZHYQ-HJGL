<template>
  <div class="main-body">
    <el-col :span="7">
      <dl class="block-box block-left">
        <dt>预警分析</dt>
        <dd ref="electricityStatisticsDD">
        </dd>
      </dl>
      <dl class="block-box block-left">
        <dt class="longTitle">大气实时环境监测</dt>
        <dd class="real-time-monitoring">
          <vue-seamless-scroll :data="airRealMonitorList" :class-option="classOption"
                               style="height: 20.5vh;overflow: hidden;">
            <div v-for="(item, index) in airRealMonitorList">
              <div class="enterprise-name">
                <span> {{ index + 1 }} </span>
                <span> {{ item.enterprise }} </span>
              </div>
              <template v-for="index in Math.ceil(Object.keys(item.value).length / 4)">
                <div class="real-time-indicator">
                  <div class="real-time-indicator-box"
                       v-for="argument in Object.keys(item.value).slice((index -1 )*4, (index - 1)*4+4)">
                    <div class="title">
                      <span> {{ argument }} </span>
                      <span> ({{ item.value[argument].unit }}) </span>
                    </div>
                    <div class="value">
                      {{ item.value[argument].value }}
                    </div>
                  </div>
                </div>
              </template>
            </div>
          </vue-seamless-scroll>
        </dd>
      </dl>
      <dl class="block-box block-left">
        <dt>告警明细</dt>
        <dd class="alarm-detail">
          <ul>
            <li class="title">
              <span>企业名称</span>
              <span>时间</span>
              <span>告警内容</span>
              <span>处理状态</span>
            </li>
            <vue-seamless-scroll :data="alarmDetail" :class-option="classOptionShort" style="height: 16.5vh;overflow: hidden;">
              <li v-for="(item, index) in alarmDetail" class="content" @click="toPath('/warning/environmentQualityWarning')">
                <span>{{ item.workName }}</span>
                <span>{{ parseTime(item.alarmTime, '{m}-{d} {h}:{i}') }}</span>
                <span>{{ item.alarmOutline }}</span>
                <span style="color: #ff4949;" v-if="item.status === '1'">未处理</span>
                <span style="color: rgb(238,174,56);" v-else-if="item.status === '2'">处理中</span>
                <span style="color: rgb(20,182,20);" v-else-if="item.status === '3'">已完成</span>
              </li>
            </vue-seamless-scroll>
          </ul>
        </dd>
      </dl>
    </el-col>
    <el-col :span="10" class="">
      <div class="index-group">
        <div v-for="(item,index) in mapIndexConfig" class="map-index-item">
          <div>
            <img :src="item.img">
          </div>
          <div>
            {{ item.title }}
          </div>
          <div>
            <span>{{ item.value }}</span>
            <span>{{ item.unit }}</span>
          </div>
        </div>
      </div>
      <xiangYinMap id="map"/>
    </el-col>
    <el-col :span="7" class="">
      <dl class="block-box block-right">
        <dt>应急物资
          <span style="display: flex">
              <input class="input-box" type="text" v-model="emergencyMaterialName" placeholder="请输入物资名称">
              <el-button class="search-btn" @click="getEmergencyMaterialList">
                <img src="../assets/images/screenImg/search.png">
              </el-button>
            </span>
        </dt>
        <dd class="emergency-supplies">
          <ul>
            <vue-seamless-scroll :key="emergencyMaterial.length" :data="emergencyMaterial"
                                 :class-option="classOptionShort" style="height: 20vh;overflow: hidden;">
              <li v-for="(item, index) in emergencyMaterial" class="content"
                  @click="toPath('/emergencyManagement/emergencySupplies')">
                <span>{{ (index + 1) }}</span>
                <span>{{ item.materialsName }}</span>
                <span>{{ formatEnterpriseName(item.enterpriseCode) }}</span>
                <span>数量</span>
                <span>{{ item.stockNumber }}</span>
                <span>{{ item.stockUnit }}</span>
              </li>
            </vue-seamless-scroll>
          </ul>
        </dd>
      </dl>
      <dl class="block-box block-right">
        <dt class="longTitle">排口实时环境监测</dt>
        <dd class="real-time-monitoring">
          <vue-seamless-scroll :data="sewageOutletRealMonitorList" :class-option="classOption"
                               style="height: 21.5vh;overflow: hidden;">
            <div v-for="(item, index) in sewageOutletRealMonitorList">
              <div class="enterprise-name">
                <span> {{ index + 1 }} </span>
                <span> {{ item.enterprise }} </span>
              </div>
              <template v-for="index in Math.ceil(Object.keys(item.value).length / 4)">
                <div class="real-time-indicator">
                  <div class="real-time-indicator-box"
                       v-for="argument in Object.keys(item.value).slice((index -1 )*4, (index - 1)*4+4)">
                    <div class="title">
                      <span> {{ argument }} </span>
                      <span> ({{ item.value[argument].unit }}) </span>
                    </div>
                    <div class="value">
                      {{ item.value[argument].value }}
                    </div>
                  </div>
                </div>
              </template>
            </div>
          </vue-seamless-scroll>
        </dd>
      </dl>
      <dl class="block-box column-last-box block-right">
        <dt>应急预案</dt>
        <dd class="emergency-plan">
          <ul>
            <li class="title">
              <span>序号</span>
              <span>预案名称</span>
              <span>预案类型</span>
            </li>
            <vue-seamless-scroll :data="emergencyPlanList" :class-option="classOptionShort" style="height: 16.5vh;overflow: hidden;">
              <li v-for="(item, index) in emergencyPlanList" class="content" @click="toPath('/emergencyManagement/planInfo')">
                <span>{{ (index + 1).toString().padStart(2, '0') }}</span>
                <span>{{ item.planName }}</span>
                <span>
                  <dict-tag :options="dict.type.emergency_plan_type" :value="item.planType"/>
                </span>
              </li>
            </vue-seamless-scroll>
          </ul>
        </dd>
      </dl>
    </el-col>
  </div>

</template>

<script>
import vueSeamlessScroll from 'vue-seamless-scroll'
import * as echarts from 'echarts'
import xiangYinMap from '@/screenViews/screenMap'
import {getAirRunInfo} from '@/screenApi/airMonitor'
import { getEnterpriseList, getGardenInfoById} from '@/screenApi/gardenInfo'
import { getAlarmDetail, getEarlyWarning, getEarlyWarningStatistics } from '@/screenApi/emergencySupplie'
import {getSewageOutletRunInfo} from '@/screenApi/sewageOutletMonitor'

import anime from 'animejs'
import {getPlanInfo} from '@/screenApi/planInfo'
import {getEmergencySuppliesList} from '@/screenApi/emergencySupplie'
import screenfull from 'screenfull'
import dayjs from "dayjs";


export default {
  name: 'emergencyOverview',
  dicts: ['emergency_plan_type'],
  props: {
    isLeave: {
      type: String
    }
  },
  data() {
    return {
      // 地图上方指标配置
      mapIndexConfig: [
        {
          img: require('@/assets/images/screenImg/emergencyOverview/indexLogo1.png'),
          title: '总次数',
          value: '',
          unit: ''
        },
        {
          img: require('@/assets/images/screenImg/emergencyOverview/indexLogo2.png'),
          title: '污染源',
          value: '',
          unit: ''
        },
        {
          img: require('@/assets/images/screenImg/emergencyOverview/indexLogo3.png'),
          title: '用电监测',
          value: '',
          unit: ''
        },
        {
          img: require('@/assets/images/screenImg/emergencyOverview/indexlogo4.png'),
          title: '环境质量',
          value: '',
          unit: ''
        }
      ],
      // 园区信息
      gardenInfo: {},
      // 园区企业信息
      enterprisesList: [],
      // 排口实时数据
      sewageOutletRealMonitorList: [],
      // 空气微站实时数据
      airRealMonitorList: [],
      // 告警明细配置
      alarmDetail: [
        {enterpriseName: '', contactPerson: '', time: '', content: '', status: ''},
        {enterpriseName: '', contactPerson: '', time: '', content: '', status: ''},
        {enterpriseName: '', contactPerson: '', time: '', content: '', status: ''},
        {enterpriseName: '', contactPerson: '', time: '', content: '', status: ''}
      ],
      // 应急物资
      emergencyMaterial: [],
      // 应急物资搜索框绑定值
      emergencyMaterialName: '',
      // 应急预案
      emergencyPlanList: [],
      //预警分析
      earlyWarning: {
        waterCount: [],//污染源预警
        airCount: [],//境质量预警
        electricCount: [],//用电预警
        recordDate: []// 日期
      },
      // //预警统计
      earlyWarningStatistics: {
        totaLwaterCount: [],//总共污染源预警
        totaLairCount: [],//总共境质量预警
        totaLelectricCount: [],//总共用电预警
        totalCount: []  //全部统计
      },
    }
  },
  computed: {
    classOption() {
      // 屏幕高度
      let height = document.documentElement.clientHeight;
      return {
        openWatch: true,
        limitMoveNum: 2,
        singleHeight: height * 0.12, // 单步运动停止的高度(默认值0是无缝不停止的滚动) direction => 0/1
        waitTime: 10000 // 单步运动停止的时间(默认值1000ms)
      };
    },
    classOptionShort() {
      // 屏幕高度
      let height = document.documentElement.clientHeight;
      return {
        // limitMoveNum: 1,
        // openWatch: true,
        singleHeight: height * 0.043, // 单步运动停止的高度(默认值0是无缝不停止的滚动) direction => 0/1
        waitTime: 10000 // 单步运动停止的时间(默认值1000ms)
      };
    },
  },
  components: {
    vueSeamlessScroll,
    xiangYinMap
  },
  mounted() {
    this.getEarlyWarningTimeData()
    // this.drawElectricityStatistics()
    this.getEnterpriseList()
    this.getAirRealMonitorList()
    this.getPlanInfoList()
    this.getGardenInfo()
    this.enterAnimation()
    this.getEarlyWarningStatisticsTota()
    this.getEmergencyMaterialDetail()
  },
  methods: {
    // 获取企业列表
    getEnterpriseList() {
      if (sessionStorage.getItem('enterprisesList') == null) {
        let params = {
          delFlag: '0'
        };
        getEnterpriseList(params).then(response => {
          this.enterprisesList = response.rows
          // 将 enterprisesList 存入 sessionStorage
          sessionStorage.setItem('enterprisesList', JSON.stringify(this.enterprisesList));
        })
      } else {
        this.enterprisesList = JSON.parse(sessionStorage.getItem('enterprisesList'))
      }
      this.getSewageOutletRealMonitorList()
    },
    // 排口实时数据
    getSewageOutletRealMonitorList() {
      getSewageOutletRunInfo().then(res => {
        // 组合数据
        let recordsList = res.recordsList
        let sewageOutletRealMonitorList = this.enterprisesList.map((enterprise) => {
          // 过滤出该企业的所有记录
          let enterpriseRecords = recordsList.filter(record => record.enterpriseCode === enterprise.enterpriseCode); // 根据实际需求修改 airCode

          // 如果没有监测数据，返回 null
          if (enterpriseRecords.length === 0) {
            return null;
          }
          // 构建实时监测数据对象
          let values = {};
          enterpriseRecords.forEach(record => {
            let unitMap = new Map([['瞬时流量', 'L/s'], ['累计流量', 'm³'], ['PH', ' ']]);
            if (record.curValue > 10000) {
              record.curValue = (record.curValue / 10000).toFixed(2),
                unitMap.set(record.factorName, '万' + unitMap.get(record.factorName))
            }
            values[record.factorName] = {
              value: record.curValue.toString(),
              unit: unitMap.get(record.factorName) || 'mg/L'
            };
          });

          return {
            enterprise: enterprise.enterpriseName,
            value: values
          };
        }).filter(item => item !== null); // 过滤掉没有监测数据的企业
        this.sewageOutletRealMonitorList = sewageOutletRealMonitorList
      })
    },
    //空气微站实时数据
    getAirRealMonitorList() {
      getAirRunInfo().then(res => {
        let microstationInfos = res.microstationInfos
        let recordsList = res.recordsList
        // 组合数据
        let realTimeEnvMonitoring = microstationInfos.map((enterprise) => {
          // 过滤出该企业的所有记录
          let enterpriseRecords = recordsList.filter(record => record.airCode === enterprise.microstationCode); // 根据实际需求修改 airCode

          // 构建实时监测数据对象
          let values = {};
          enterpriseRecords.forEach(record => {
            values[record.factorName] = {
              value: record.curValue.toString(),
              unit: record.factorName === '温度' ? '°C' : record.factorName === '湿度' ? '%' : record.factorName === 'PH' ? '' : 'μg/m³'
            };
          });

          return {
            enterprise: enterprise.microstationName,
            value: values
          };
        });
        this.airRealMonitorList = realTimeEnvMonitoring
      })
    },
    // 获取应急预案列表
    getPlanInfoList() {
      let params = {
        delFlag: '0'
      };
      getPlanInfo(params).then(response => {
        this.emergencyPlanList = response.data
      })
    },
    // 获取应急物资
    getEmergencyMaterialList() {
      let params = {
        delFlag: '0',
        materialsName: this.emergencyMaterialName
      };
      getEmergencySuppliesList(params).then(response => {
        this.emergencyMaterial = response.data

      })
    },
    // 获取预警统计
    getEarlyWarningStatisticsTota() {
        getEarlyWarningStatistics().then(response => {
          this.mapIndexConfig[0].value = response.data[0].totalCount
          this.mapIndexConfig[1].value = response.data[0].totaLwaterCount
          this.mapIndexConfig[2].value = response.data[0].totaLelectricCount
          this.mapIndexConfig[3].value = response.data[0].totaLairCount

        })
    },
    // 获取告警明细
    getEmergencyMaterialDetail() {
      let params = {orderByColumn: 'alarm_time', isAsc: 'desc', pageSize: 10, pageNum: 1}
      getAlarmDetail(params).then(res => {
        this.alarmDetail = res.rows
      })
    },
    // 格式化企业名称
    formatEnterpriseName(enterpriseCode) {
      if (enterpriseCode) {
        let find = this.enterprisesList.find(item => item.enterpriseCode === enterpriseCode)
        return find ? find.enterpriseName : ''
      } else {
        return this.gardenInfo.gardenName
      }
    },
    // 获取园区基本信息
    getGardenInfo() {
      if (sessionStorage.getItem('screenGardenInfo') == null) {
        getGardenInfoById('1').then(res => {
          this.gardenInfo = res.data
          sessionStorage.setItem('screenGardenInfo', JSON.stringify(this.gardenInfo));
          this.getEmergencyMaterialList()
        })
      } else {
        this.gardenInfo = JSON.parse(sessionStorage.getItem('screenGardenInfo'))
        this.getEmergencyMaterialList()
      }
    },
    // 页面切换路由
    toPath(path) {
      screenfull.exit();
      this.$router.push(path)
    },
    // 预警分析
    getEarlyWarningTimeData() {
      this.earlyWarning = {waterCount: [], airCount: [], electricCount: [], recordDate: []}
      let params = {
        startTime: dayjs().subtract(9, 'day').startOf('day').format('YYYY-MM-DD HH:mm:ss'), // 添加时间部分，设置为当天的午夜
        endTime: dayjs().endOf('day').format('YYYY-MM-DD HH:mm:ss') // 同样，确保时间部分是正确的
      }
      getEarlyWarning(params).then(res => {
        let nowTime = dayjs();
        let days = res.data.length === 0 ? 5 : 10
        for (let i = 0; i < days; i++) {
          let find = res.data.find(item => dayjs(item.recordDate).format('YYYY-MM-DD') === nowTime.format('YYYY-MM-DD'))
          if (find) {
            this.earlyWarning['waterCount'].push(find.waterCount.toFixed(2))
            this.earlyWarning['airCount'].push(find.airCount.toFixed(2))
            this.earlyWarning['electricCount'].push(find.electricCount.toFixed(2))
            this.earlyWarning['recordDate'].push(dayjs(find.recordDate).format('MM-DD'))
          } else {
            this.earlyWarning['waterCount'].push('0')
            this.earlyWarning['airCount'].push('0')
            this.earlyWarning['electricCount'].push('0')
            this.earlyWarning['recordDate'].push(dayjs(nowTime).format('MM-DD'))
          }
          nowTime = nowTime.subtract(1, 'day');
        }
        this.drawElectricityStatistics(this.earlyWarning)
      }).catch(error => {
        console.error('获取预警列表失败:', error);
      });
    },
    drawElectricityStatistics(data) {
      let myEcharts = echarts.init(this.$refs.electricityStatisticsDD);
      let option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        color: ['#03AAEE', '#00CE8B', '#00F2F9'],
        legend: {
          data: [{
            name: "污染源",
            icon: "rect",
            itemStyle: {
              color: '#03AAEE'
            }
          },
            {
              name: "用电监测",
              icon: "rect",
              itemStyle: {
                color: '#00CE8B'
              }
            },
            {
              name: "环境质量",
              icon: "rect",
              itemStyle: {
                color: '#00F2F9'
              }
            }],
          right: 10,
          top: '5%',
          textStyle: {
            color: "#B5C5D4",
          },
          icon: "rect",
          itemWidth: 10,
          itemHeight: 10,
          itemGap: 35,
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          top: '20%',
          containLabel: true,
        },
        xAxis: [
          {
            type: "category",
            data: data.recordDate,
            axisLine: {
              show: true,
              lineStyle: {
                color: "#063374",
                width: 1,
                type: "solid",
              },
            },
            axisTick: {
              show: false,
            },
            axisLabel: {
              show: true,
              textStyle: {
                color: "#B5C5D4",
              },
            },
          },
          {
            type: "category",
            gridIndex: 0,
            data: data.recordDate,
            splitLine: {
              show: false,
            },
            axisLine: {
              show: false,
            },
            axisTick: {
              show: false,
            },
            axisLabel: {
              show: false,
            },
          }
        ],
        yAxis: [
          {
            type: "value",
            name: "单位：次",
            axisTick: {
              show: false,
            },
            axisLine: {
              show: false,
              lineStyle: {
                color: "#B5C5D4",
                width: 1,
                type: "solid",
              },
            },
            splitLine: {
              show: true,
              lineStyle: {
                type: 'dashed',
                color: '#172C4B',
                width: 2
              }
            },
          },
          {
            type: "value",
            gridIndex: 0,
            splitLine: {
              show: false,
            },
            axisLine: {
              show: false,
            },
            axisTick: {
              show: false,
            },
            axisLabel: {
              show: false,
            },
          }
        ],
        dataZoom: [
          {
            type: "inside",
            show: true,
            startValue: 0,
            endValue: 4,
          },
        ],
        series: [
          {
            name: "污染源",
            type: "bar",
            zlevel: 2,
            data: data.waterCount,
            barWidth: 9, //柱子宽度
            itemStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: "#00ABEE",
                  },
                  {
                    offset: 1,
                    color: "#0D305A",
                  },
                ]),
                opacity: 1,
              },
            },
          },
          {
            name: "用电监测",
            type: "bar",
            zlevel: 2,
            data: data.electricCount,
            barWidth: 9,
            itemStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: "#09E78D",
                  },
                  {
                    offset: 1,
                    color: "#033850",
                  },
                ]),
                opacity: 1,
              },
            },
          },
          {
            name: "环境质量",
            type: "bar",
            zlevel: 2,
            data: data.airCount,
            barWidth: 9,
            barGap: .35,
            itemStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: "#00F3FB",
                  },
                  {
                    offset: 1,
                    color: "#043653",
                  },
                ]),
                opacity: 1,
              },
            },
          },
          {
            name: "背景",
            type: "bar",
            zlevel: 1,
            barWidth: 60,
            xAxisIndex: 1,
            yAxisIndex: 1,
            tooltip: {show: false},
            barGap: "-155%",
            data: [
              100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100
            ],
            itemStyle: {
              normal: {
                color: "rgba(4,40,98,0.5)",
              },
            }
          },
        ],
      };
      myEcharts.setOption(option, {
        notMerge: true,  // 不合并之前的配置
        animation: true,  // 开启切换动画
        animationDuration: 5000,  // 配置切换动画持续时间
        animationEasing: 'cubicOut'  // 配置切换动画缓动效果
      })

      if (data.recordDate.length > 5) {
        myEcharts.clear();
        this.ElectricityInterval = setInterval(function () {
          let recordDate = data.recordDate;
          let waterCount = data.waterCount
          let airCount = data.airCount
          let electricCount = data.electricCount

          // 把第一个元素移动到最后一个元素+
          recordDate.push(recordDate.shift());
          waterCount.push(waterCount.shift());
          airCount.push(airCount.shift());
          electricCount.push(electricCount.shift());

          option.xAxis.data = recordDate;
          option.series[0].data = waterCount;
          option.series[1].data = airCount;
          option.series[2].data = electricCount;

          myEcharts.setOption(option, true);
        }, 5000)
      }

      myEcharts.setOption(option);

      window.onresize = function () {
        myEcharts.resize();
      };
    },
    // 进入动画
    enterAnimation() {
      // 获取所有 class 为 'block-left' 的元素
      let blockLeftList = document.getElementsByClassName('block-left');
      let blockRightList = document.getElementsByClassName('block-right')
      let map = document.getElementById('map')
      let indexItemList = document.getElementsByClassName('map-index-item')

      // 创建并启动动画时间轴
      anime.timeline({
        easing: 'easeOutBack',
        duration: 1000,
      })
        .add({
          targets: blockLeftList,
          delay: (el, i) => i * 150, // 每个元素延迟递增
          translateX: [
            {value: '-20%', duration: 0},
            {value: '0', duration: 600}
          ],
          opacity: [0, 1],
          easing: 'easeOutBack',
        })
        // .block-right 元素添加带延迟的动画
        .add({
          targets: blockRightList,
          delay: (el, i) => i * 150, // 每个元素延迟递增
          translateX: [
            {value: '20%', duration: 0},
            {value: '0', duration: 600}
          ],
          opacity: [0, 1],
          easing: 'easeOutBack',
        }, 0)
        .add({
          targets: map,
          opacity: [
            {value: 0, duration: 0},
            {value: 1, duration: 2000}
          ],
          easing: 'easeOutBack',
        }, 0)
        .add({
          targets: indexItemList,
          delay: (el, i) => i * 150,
          opacity: [
            {value: 0, duration: 0},
            {value: 1, duration: 600}
          ],
          // 绕y轴旋转
          rotateY: [
            {value: 0, duration: 0},
            {value: 360, duration: 600}
          ],
          scale: [
            {value: 0, duration: 0},
            {value: 1, duration: 600}
          ],
          easing: 'easeOutBack',
        }, 0)
    },
    leaveAnimation() {
      let blockLeftList = document.getElementsByClassName('block-left');
      let blockRightList = document.getElementsByClassName('block-right')
      let map = document.getElementById('map')
      let indexItemList = document.getElementsByClassName('map-index-item')

      anime.timeline({
        easing: 'easeOutBack',
        duration: 1000,
      })
        .add({
          targets: blockLeftList,
          delay: (el, i) => i * 150, // 每个元素延迟递增
          translateX: [
            {value: '0%', duration: 0},
            {value: '-100%', duration: 600}
          ],
          opacity: [1, 0],
          easing: 'easeOutBack',
        })
        // .block-right 元素添加带延迟的动画
        .add({
          targets: blockRightList,
          delay: (el, i) => i * 150, // 每个元素延迟递增
          translateX: [
            {value: '0%', duration: 0},
            {value: '100%', duration: 600}
          ],
          opacity: [1, 0],
        }, 0)
        .add({
          targets: map,
          opacity: [
            {value: 1, duration: 0},
            {value: 0, duration: 600}
          ],
          easing: 'linear',
        }, 0)
        .add({
          targets: indexItemList,
          opacity: [
            {value: 1, duration: 0},
            {value: 0, duration: 600}
          ],
          scale: [
            {value: 1, duration: 0},
            {value: 0, duration: 600}
          ]
        }, 0)
    },
    // 格式化应急预案类型
    formatPlanType(val) {
      let find = this.dict.type['emergency_plan_type'].find(item => item.value === val)
      return find ? find.label : ''
    },
  },
  watch: {
    isLeave(val) {
      if (val !== '3') {
        this.leaveAnimation()
      }
    },
  }
}
</script>

<style scoped lang="scss">
@import "../assets/styles/screen.scss";

.pack-info {
  height: 35.5vh !important;

  dd {
    height: 29.5vh !important;
    padding: 1.5vh 1vw;

    div:nth-child(2) {
      padding-top: .5vh
    }
  }
}

.emission-statistics {
  height: 19.3vh !important;

  dd {
    height: 15vh !important;
  }
}

.complaints-suggestions {
  margin-top: 1.7vh;
  height: 26vh !important;

  dd {
    height: 23vh !important;
  }

  //  投诉与建议legend样式
  .complaints-suggestions-legend {
    position: relative;
    top: -22vh;
    left: 15vw;

    div {
      width: 11vw;
      height: 3vh;
      margin-top: 3vh;
      border-bottom: 1px dashed var(--babyBlue);

      span:nth-child(1) {
        display: inline-block;
        width: 1vw;
        height: 1vw;
        border-radius: 50%;
        position: relative;
        top: 0.2vh
      }

      span:nth-child(2) {
        display: inline-block;
        width: 3vw;
        margin-left: .2vw
      }

      span:nth-child(3) {
        display: inline-block;
        width: 5vw;
        text-align: right;
        font-weight: 900;
      }
    }

    div:nth-child(1) {
      span:nth-child(1) {
        border: .4vh solid var(--skyBlue);
      }

      span:nth-child(3) {
        color: var(--skyBlue);
      }
    }

    div:nth-child(2) {
      span:nth-child(1) {
        border: .4vh solid var(--lightCyan);
      }

      span:nth-child(3) {
        color: var(--lightCyan);
      }
    }

    div:nth-child(3) {
      span:nth-child(1) {
        border: .4vh solid var(--brightGreen);
      }

      span:nth-child(3) {
        color: var(--brightGreen);
      }
    }
  }
}

.index-group {
  margin-top: 5vh;
  padding: 0 3.5vw;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;

  div {
    text-align: center;

    div:nth-child(1) {
      img {
        width: 7vh
      }
    }
  ;

    div:nth-child(2) {
      width: 80%;
      margin: 0 auto;
      line-height: 3vh;
      font-size: var(--font-small);
      background-image: url("../assets/images/screenImg/index/indexTitleBg.png");
      letter-spacing: 2px
    }

    div:nth-child(3) {
      margin-top: .8vh;

      span:nth-child(1) {
        font-family: PangMenZhengDao, serif;
        color: var(--lightCyan);
        font-size: var(--font-large)
      }
    }
  }
}

.online-situation {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  column-gap: .65vw;
  padding: 2.3vh .9vw;
  height: 100%;

  .online-situation-box {
    background-image: url("../assets/images/screenImg/index/onlineSituationBg.png");
    text-align: center;

    div:nth-child(1) {
      margin-top: 4.2vh;
      font-family: DINAlternateBold, serif;
      background: linear-gradient(0deg, #00F7FF 40%, #FFFFFF 70%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      font-size: var(--font-xlarge);
    }

    div:nth-child(2) {
      height: 9.8vh;
      margin: 0 .5vw;
      padding-top: 2.2vh;
    }
  }

  .online-situation-box:nth-child(1) div:nth-child(2) {
    background-image: url("../assets/images/screenImg/index/onlineSituation1.png");
    color: var(--lightCyan);
  }

  .online-situation-box:nth-child(2) div:nth-child(2) {
    background-image: url("../assets/images/screenImg/index/onlineSituation2.png");
    color: var(--brightGreen);
  }

  .online-situation-box:nth-child(3) div:nth-child(2) {
    background-image: url("../assets/images/screenImg/index/onlineSituation3.png");
    color: var(--orange);
  }

  .online-situation-box:nth-child(4) div:nth-child(2) {
    background-image: url("../assets/images/screenImg/index/onlineSituation4.png");
    color: var(--deepRed);
  }
}

.energy-analyze {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  column-gap: .75vw;
  padding: 2.3vh .9vw;
  text-align: center;

  .energy-analyze-box {
    background-image: url("../assets/images/screenImg/index/energyAnalyzeBg.png");

    div:nth-child(1) {
      font-size: var(--font-small);
      margin-top: 3.5vh
    }

    div:nth-child(2) span:nth-child(1) {
      font-family: DINAlternateBold, serif;
      font-size: var(--font-xlarge);
      background: linear-gradient(0deg, #00F7FF 40%, #FFFFFF 70%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      margin-top: .4vh;
    }

    div:nth-child(3) {
      height: 7.5vh;
      margin: 0 1.2vw;
    }
  }

  .energy-analyze-box:nth-child(1) div:nth-child(3) {
    background-image: url("../assets/images/screenImg/index/energyAnalyze1.png");
  }

  .energy-analyze-box:nth-child(2) div:nth-child(3) {
    background-image: url("../assets/images/screenImg/index/energyAnalyze2.png");
  }

  .energy-analyze-box:nth-child(3) div:nth-child(3) {
    background-image: url("../assets/images/screenImg/index/energyAnalyze3.png");
  }
}

.video-surveillance {
  padding: 1vw;
}

.real-time-monitoring {
  padding: 0 .5vw;

  .enterprise-name {
    line-height: 2.2vh;
    margin-top: .5vh;
    margin-bottom: .2vh;

    span {
      font-size: var(--font-small);
    }

    span:nth-child(1) {
      font-style: italic;
      background: radial-gradient(circle at 50% 50%, #073872, #026DA5);
      display: inline-block;
      width: 1vw;
      height: 1vw;
      line-height: 1vw;
      border-radius: 50%;
      padding-left: .2vw;
    }
  }

  .real-time-indicator {
    display: flex;
    background-image: url("~@/assets/images/screenImg/emergencyOverview/bgBox1.png");
    padding: 0 1vw;
    height: 4.5vh;

    .real-time-indicator-box {
      width: 25%;
      font-family: DINAlternateBold, serif;
      display: flex;
      padding-left: .2vw;

      .title {
        width: 50%;
        margin-top: .6vh;

        span {
          display: block;
          color: var(--lightCyan);
          text-align: center;
        }

        font-size: calc(var(--font-small) - .1vw);
      }

      .value {
        width: 50%;
        text-align: center;
        line-height: 4.5vh;
        margin-left: .2vw;
        font-size: calc(var(--font-xlarge) - .1vw);
        background: linear-gradient(0deg, #00F7FF 12.3046875%, #FFFFFF 72%);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
      }
    }
  }
}

.alarm-detail {
  padding: 1.2vh;
  font-size: var(--font-small);

  .title {
    background-image: url("~@/assets/images/screenImg/emergencyOverview/listTitle.png");
    height: 3.6vh;
    line-height: 3.6vh;
    margin-bottom: .2vh;

    span {
      color: var(--lightCyan)
    }
  }

  .content {
    background-image: url("~@/assets/images/screenImg/emergencyOverview/listBg.png");
    height: 3.5vh;
    margin-top: .8vh;
    line-height: 3.5vh
  }

  .content:hover {
    background-image: url("~@/assets/images/screenImg/emergencyOverview/listHoverBg.png")
  }

  li {
    span {
      display: inline-block;
      text-align: center;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    span:nth-child(1) {
      padding-left: 0.5vw;
      width: 42%;
    }

    span:nth-child(2) {
      width: 20%;
    }

    span:nth-child(3) {
      width: 23%;
    }

    span:nth-child(4) {
      width: 15%;
    }
  }
}

/* 应急预案 */
.emergency-plan {
  padding: 1.2vh;
  font-size: var(--font-small);

  .title {
    background-image: url("~@/assets/images/screenImg/emergencyOverview/listTitle.png");
    height: 3.6vh;
    line-height: 3.6vh;
    margin-bottom: .2vh;

    span {
      color: var(--lightCyan)
    }
  }

  .content {
    background-image: url("~@/assets/images/screenImg/emergencyOverview/listBg.png");
    height: 3.5vh;
    margin-top: .8vh;
    line-height: 3.5vh;

    span:nth-child(1) {
      font-family: DINAlternateBold, serif;
      background: linear-gradient(0deg, #00F7FF 12.3046875%, #FFFFFF 72%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
    }

    span:nth-child(2) {
      text-align: left
    }
  }

  .content:hover {
    background-image: url("~@/assets/images/screenImg/emergencyOverview/listHoverBg.png")
  }

  li {
    span {
      display: inline-block;
      text-align: center;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    span:nth-child(1) {
      width: 10%;
    }

    span:nth-child(2) {
      width: 67%;
    }

    span:nth-child(3) {
      width: 20%;
    }
  }
}

.emergency-supplies {
  padding: 1.2vh;
  cursor: pointer;
  user-select: none;

  li:hover {
    transform: scale(1.02)
  }

  li {
    background-image: url("~@/assets/images/screenImg/emergencyOverview/listBg2.png");
    height: 3.5vh;
    line-height: 4vh;
    margin-top: .5vh;

    span {
      display: inline-block;
      text-align: center;
      /* 文本不换行 */
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    span:nth-child(1) {
      background-image: url("~@/assets/images/screenImg/emergencyOverview/indexBg.png");
      width: 3vh;
      height: 3vh;
      line-height: 2.8vh;
      font-family: DINAlternateBold, serif;
      position: relative;
      top: -.5vh;
      margin-left: 1vw
    }

    span:nth-child(2) {
      width: 24%
    }

    span:nth-child(3) {
      width: 37%;
      color: var(--lightCyan);
      text-align: left
    }

    span:nth-child(4) {
      width: 8%;
      text-align: right
    }

    span:nth-child(5) {
      width: 10%;
      text-align: right;
      font-family: DINAlternateBold, serif;
      font-size: var(--font-large);
      background: linear-gradient(0deg, #00F7FF 12.3046875%, #FFFFFF 72%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
    }

    span:nth-child(6) {
      width: 10%
    }
  }
}

.indexTitle {
  font-size: var(--font-large);
}

</style>
