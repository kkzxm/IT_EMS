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
          <el-button size="mini" type="primary" plain icon="el-icon-plus" title="添加子菜单"
                     @click="addEmp"
          >添加员工
          </el-button>
        </template>
        <template #default="scope">
          <el-button size="mini" type="" icon="el-icon-edit" title="修改"
                     @click="editEmp(scope.row)"
          >修改
          </el-button>
          <el-popconfirm title="确定要删除该菜单项吗?" @confirm="delEmp(scope.row.id)">
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
          <el-form-item label="姓名">
            <el-input v-model="dialogs.addOrUpdate.form.name" size="small"></el-input>
          </el-form-item>
          <el-form-item label="电话号码">
            <el-input v-model="dialogs.addOrUpdate.form.phone" size="small"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <el-button type="primary" @click="addSubEmp">确认</el-button>
          <el-button @click="dialogs.addOrUpdate.show=false">取消</el-button>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {API} from "@/api";


export default {
  name: "employees",
  data() {
    return {
      table: {
        data: [],
        structure: [
          {prop: "name", label: "姓名"},
          {prop: "phone", label: "电话号码"}
        ]
      },
      dialogs: {
        addOrUpdate: {
          show: false,
          form: {name: "", phone: "", id: ""}
        }
      }
    }
  },
  methods: {
    //点击添加员工的按钮
    addEmp() {
      this.dialogs.addOrUpdate.show = true
      this.dialogs.addOrUpdate.form.name = ""
      this.dialogs.addOrUpdate.form.phone = ""
      this.dialogs.addOrUpdate.form.id = ""
    },
    //提交添加员工
    addSubEmp() {
      let form = this.dialogs.addOrUpdate.form;
      API.employees.addOrUpdate(form, () => {
        this.dialogs.addOrUpdate.show = false;
      });
      if (form.id === "") this.table.data.push(form);
    },
    //删除员工
    delEmp(id) {
      API.employees.del({id: id}, () => {
        this.init();
      })
    },
    //修改员工
    editEmp(row) {
      this.dialogs.addOrUpdate.form = row
      this.dialogs.addOrUpdate.show = true
    },
    init() {
      API.employees.page({}, data => {
        this.table.data = data.records
      })
    }
  },
  created() {
    this.init();
  }

}
</script>

<style scoped>

</style>