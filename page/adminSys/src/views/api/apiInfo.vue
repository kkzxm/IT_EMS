<template>
  <div>
    <el-table
        :data="table.data"
        style="width: 100%">
      <el-table-column v-for="(stru,index) in table.structure" :key="index"
                       :prop="stru.prop"
                       :label="stru.label">
      </el-table-column>
      <el-table-column>
        <template #header>
          <el-button size="mini" type="primary" plain icon="el-icon-refresh" title="添加子菜单"
                     @click="addApi"
          >添加接口
          </el-button>
        </template>
        <template #default="scope">
          <el-button size="mini" type="" icon="el-icon-edit" title="修改"
                     @click="editApi(scope.$index, scope.row)"
          >修改
          </el-button>
          <el-popconfirm title="确定要删除该菜单项吗?" @confirm="delApi(scope, scope.row)">
            <template #reference>
              <el-button size="mini" type="danger" plain icon="el-icon-delete" title="删除">
                删除
              </el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {API} from "@/api";

export default {
  name: "apiInfo",
  data() {
    return {
      table: {
        data: [],
        structure: [
          {prop: "apiname", label: "名称"},
          {prop: "address", label: "地址"},
          {prop: "method", label: "请求方式"},
          // {prop: "group", label: "分组"},
          {prop: "reqField", label: "访问参数"},
          {prop: "resField", label: "返回参数"},
        ],
      }
    }
  },
  methods: {
    init() {
      API.apiManager.page({}, (data) => {
        this.table.data = data.records
        console.log(data);
      })
    },
    delApi() {

    },
    addApi() {
    },
    editApi() {
    }
  },
  created() {
    this.init();
  }
}
</script>

<style scoped>

</style>