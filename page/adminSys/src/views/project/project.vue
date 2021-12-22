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
          <el-button size="mini" type="primary" plain icon="el-icon-plus" title="添加项目"
                     @click="addPro"
          >添加项目
          </el-button>
        </template>
        <template #default="scope">
          <el-button size="mini" type="" icon="el-icon-edit" title="修改"
                     @click="editPro(scope.row)"
          >修改
          </el-button>
          <el-popconfirm title="确定要删除该项目吗?" @confirm="delPro(scope.row.id)">
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
          <el-form-item label="项目名称">
            <el-input v-model="dialogs.addOrUpdate.form.name" size="small"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <el-button type="primary" @click="addSubPro">确认</el-button>
          <el-button @click="dialogs.addOrUpdate.show=false">取消</el-button>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {API} from "@/api";


export default {
  name: "project",
  data() {
    return {
      table: {
        data: [],
        structure: [
          {prop: "name", label: "项目名称"}
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
    //点击添加项目的按钮
    addPro() {
      this.dialogs.addOrUpdate.show = true
      this.dialogs.addOrUpdate.form.name = ""
      this.dialogs.addOrUpdate.form.id = ""
    },
    //提交添加项目
    addSubPro() {
      let form = this.dialogs.addOrUpdate.form;
      API.project.addOrUpdate(form, () => {
        this.dialogs.addOrUpdate.show = false;
      });
      if (form.id === "") this.table.data.push(form);
    },
    //删除项目
    delPro(id) {
      API.project.del({id: id}, () => {
        this.init();
      })
    },
    //修改项目
    editPro(row) {
      this.dialogs.addOrUpdate.form = row
      this.dialogs.addOrUpdate.show = true
    },
    init() {
      API.project.page({}, data => {
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