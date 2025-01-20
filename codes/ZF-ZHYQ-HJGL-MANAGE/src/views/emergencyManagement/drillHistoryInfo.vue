<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="单位名称" prop="enterpriseCode">
        <el-select v-model="queryParams.enterpriseCode" placeholder="请选择单位名称" clearable filterable style="width: 240px">
          <el-option v-for="item in enterpriseInfoList" :key="item.enterpriseCode" :label="item.enterpriseName" :value="item.enterpriseCode" />
        </el-select>
      </el-form-item>
      <el-form-item label="演练时间" prop="drillTime">
        <el-date-picker
                        v-model="drillTime"
                        type="daterange"
                        range-separator="至"
                        start-placeholder="开始日期"
                        end-placeholder="结束日期"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择演练时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin_api:drillHistoryInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="drillHistoryInfoList">
      <el-table-column label="序号" align="center" type="index" />
      <el-table-column label="园区名称" align="center" prop="gardenCode" :formatter="formatGardenName" />
      <el-table-column label="企业名称" align="center" prop="enterpriseCode" :formatter="formatEnterpriseName"/>
      <el-table-column label="应急演练预案" align="center" prop="planId" :formatter="formatPlanName"/>
      <el-table-column label="演练内容" align="center" prop="drillName" />
      <el-table-column label="演练时间" align="center" prop="drillTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.drillTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="地址" align="center" prop="address" />
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import {
  listDrillHistoryInfo,
  getDrillHistoryInfo,
  delDrillHistoryInfo,
  addDrillHistoryInfo,
  updateDrillHistoryInfo,
  logicalDeletionDrillHistoryInfo
} from '@/api/emergencyManagement/drillHistoryInfo'
import { listPlanInfoNoPage } from '@/api/emergencyManagement/planInfo'
import { listGardenNotPage } from '@/api/packInformatization/gardenInfo'
import { getEnterpriseBaseInfoNoPage } from '@/api/enterpriseArchives/enterpriseBaseInfo'

export default {
  name: "DrillHistoryInfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 应急演练档案表格数据
      drillHistoryInfoList: [],
      // 企业信息
      enterpriseInfoList: [],
      // 应急预案信息
      planInfoList: [],
      // 园区信息列表
      gardenInfoList: [],
      // 演练事件查询条件（[开始时间，结束时间]）
      drillTime: null,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        gardenCode: null,
        enterpriseCode: null,
        planId: null,
        drillName: null,
        drillTime: null,
        address: null,
        delFlag: '0'
      },
    };
  },
  created() {
    this.getEnterpriseInfo();
    this.getGardenList()
    this.getPlanInfoList();
    this.getList();
  },
  methods: {
    /** 查询应急演练档案列表 */
    getList() {
      this.loading = true;
      this.queryParams.beginDrillTime = null;
      this.queryParams.endDrillTime = null;
      if (this.drillTime && this.drillTime.length === 2) {
        this.queryParams.beginDrillTime = this.drillTime[0];
        this.queryParams.endDrillTime = this.drillTime[1];
      }
      listDrillHistoryInfo(this.queryParams).then(response => {
        this.drillHistoryInfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 获取企业信息 */
    getEnterpriseInfo() {
      let params = {
        delFlag: '0'
      };
      getEnterpriseBaseInfoNoPage(params).then(response => {
        if(response.code === 200 && response.data.length > 0){
          this.enterpriseInfoList = response.data;
        }
      });
    },
    /** 获取应急演练预案数据 */
    getPlanInfoList() {
      let params = {
        delFlag: '0'
      };
      listPlanInfoNoPage(params).then(response => {
        console.log(response)
        if (response.code === 200 && response.data.length > 0) {
          this.planInfoList = response.data;
        }
      });
    },
    /** 获取园区列表 */
    getGardenList() {
      let params = {
        delFlag: '0'
      };
      listGardenNotPage(params).then(response => {
        if(response.code === 200 && response.data.length > 0){
          this.gardenInfoList = response.data;
        }
      });
    },
    // 格式化企业名称
    formatEnterpriseName(row) {
      let find = this.enterpriseInfoList.find(item => item.enterpriseCode === row.enterpriseCode)
      return find ? find.enterpriseName : ''
    },
    // 格式化演练预案
    formatPlanName(row) {
      let find = this.planInfoList.find(item => item.id === row.planId)
      return find ? find.planName : ''
    },
    // 格式化园区名称
    formatGardenName(row) {
      let find = this.gardenInfoList.find(item => item.gardenCode === row.gardenCode)
      return find ? find.gardenName : ''
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.drillTime = null;
      this.handleQuery();
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin_api/drillHistoryInfo/export', {
        ...this.queryParams
      }, `应急演练档案${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
