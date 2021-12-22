<template>
  <div>
    <el-table
        :data="table.data"
        style="width: 100%">
      <el-table-column v-for="(str,index) in table.structure"
                       :key="index"
                       :prop="str.prop"
                       :label="str.label">
      </el-table-column>
      <el-table-column>
        <template #header>
          <el-button size="mini" type="primary" plain icon="el-icon-plus" title="添加部门"
                     @click="openDiaLog"
          >添加部门
          </el-button>
        </template>
        <template #default="scope">
          <el-button size="mini" type="" icon="el-icon-edit" title="修改"
                     @click="editDep(scope.row)"
          >修改
          </el-button>
          <el-popconfirm title="确定要删除该菜单项吗?" @confirm="delDep(scope.row.id)">
            <template #reference>
              <el-button size="mini" type="danger" plain icon="el-icon-delete" title="删除">
                删除
              </el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div class="dialogs">
      <el-dialog v-model="dialogs.addOrUpdate.show" :title="dialogs.addOrUpdate.title"
                 :center="true"
                 custom-class="editDialog"
                 v-if="dialogs.addOrUpdate.show">
        <el-form ref="form" :model="dialogs.addOrUpdate.form">
          <el-form-item label="部门名称">
            <el-input v-model="dialogs.addOrUpdate.form.name" size="small"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <el-button type="primary" @click="addSubDep">确认</el-button>
          <el-button @click="dialogs.addOrUpdate.show=false">取消</el-button>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {API} from "@/api";

export default {
  name: "department",
  data() {
    return {
      table: {
        data: [],
        structure: [
          {prop: "name", label: "部门名称"}
        ]
      },
      dialogs: {
        addOrUpdate: {
          title: "",
          show: false,
          form: {},
        }
      }
    }
  },
  methods: {
    init() {
      API.department.page({}, (data) => {
        this.table.data = data.records
      })
    },
    openDiaLog() {
      this.dialogs.addOrUpdate.form = {id: "", name: ""}
      this.dialogs.addOrUpdate.show = true
      this.dialogs.addOrUpdate.title = "添加部门"
    },
    delDep(id) {
      API.department.del({id}, () => {
        this.init();
      });
    },
    editDep(data) {
      this.dialogs.addOrUpdate.show = true
      this.dialogs.addOrUpdate.title = "修改部门"
      this.dialogs.addOrUpdate.form = data
    },
    addSubDep() {
      let form = this.dialogs.addOrUpdate.form;
      API.department.addOrUpdate(form, () => {
        if (form.id === "") this.init();
        this.dialogs.addOrUpdate.show = false;
      });
    }
  },
  created() {
    this.init();
  }
}
</script>

<style scoped>

</style>