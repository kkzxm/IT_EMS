<template>
  <div>
    <el-table
        :data="table.data"
        style="width: 100%"
        row-key="id"
        border
        :expand-row-keys="table.thisExpandRowKeys"
        @expand-change="RowExpand"
        :lazy="true"
        :load="tableLoad"
        :tree-props="table.tree_props"
    >
      <el-table-column
          v-for="co in table.structure"
          :key="co.id"
          :prop="co.prop"
          :label="co.label">
      </el-table-column>
      <el-table-column>
        <template #header>
          <el-button size="mini" type="primary" plain icon="el-icon-plus" title="添加子菜单"
                     @click="addSysMenu()"
          >添加顶级菜单
          </el-button>
          <el-button size="mini" type="primary" plain icon="el-icon-refresh" title="添加子菜单"
                     @click="init(true)"
          >快速重载表格
          </el-button>
        </template>
        <template #default="scope">
          <el-button size="mini" type="" icon="el-icon-edit" title="修改"
                     @click="editSysMenu(scope.$index, scope.row)"
          >修改
          </el-button>
          <el-popconfirm title="确定要删除该菜单项吗?" @confirm="delSysMenu(scope, scope.row)">
            <template #reference>
              <el-button size="mini" type="danger" plain icon="el-icon-delete" title="删除">
                删除
              </el-button>
            </template>
          </el-popconfirm>
          <el-button size="mini" type="primary" plain icon="el-icon-plus" title="添加子菜单"
                     @click="addSysMenu(scope.$index, scope.row)"
          >添加子项
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="dialogs">
      <el-dialog v-model="dialogs.editDialog.show" :title="dialogs.editDialog.title"
                 :center="true"
                 custom-class="editDialog"
                 v-if="dialogs.editDialog.show">
        <el-form ref="form" :model="dialogs.editDialog.form.name">
          <el-form-item label="父菜单">
            <el-input v-model="dialogs.editDialog.form.parentMenu.name" size="small" disabled></el-input>
          </el-form-item>
          <el-form-item label="菜单名称">
            <el-input v-model="dialogs.editDialog.form.name" size="small"></el-input>
          </el-form-item>
          <el-form-item label="跳转路由">
            <el-input v-model="dialogs.editDialog.form.router" size="small"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <el-button type="primary" @click="editDialogOnSubmit">确认</el-button>
          <el-button @click="editDialogOnCancel">取消</el-button>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {API} from "@/api";

export default {
  name: "sysmenu",
  data() {
    return {
      table: {
        structure: [
          {prop: "name", label: "菜单名称"},
          {prop: "router", label: "跳转路由"}
        ],
        data: [],
        tree_props: {children: 'sysMenuList', hasChildren: 'hasChildren', parent: 'parentMenu'},
        thisExpandRowKeys: [],
      },
      dialogs: {
        editDialog: {
          show: false,
          title: "",
          form: {
            parentMenu: {name: "", id: ""},
            name: "",
            router: ""
          }
        }
      }
    }
  },
  methods: {
    tableLoad(row, treeNode, resolve) {
      window.resolve = resolve;
      API.menu.menuTree({id: row.id}, (data) => {
        resolve(data);
      });
    },
    //监测当前展开的行
    RowExpand(row, expanded) {
      let keys = this.table.thisExpandRowKeys;
      if (expanded) {
        keys.length < 2 ? keys.push(row.id) : ""
      } else {
        let index = -1;
        for (let i = 0; i < keys.length; i++) {
          if (keys[i] === row.id) {
            index = i;
          }
          this.table.data.thisExpandRowKeys.splice(index, 1);
        }
      }
    },
    editSysMenu(index, row) {
      alert(index);
      console.log(row)
    },
    //删除系统菜单
    delSysMenu(slot, row) {
      let params = new URLSearchParams();
      params.append("id", row.id)
      API.menu.del(params, () => {
        this.init(true);
      }, () => {
        this.table.thisExpandRowKeys.splice(0);
        this.init(true)
      })
    },
    //打开添加/修改系统菜单的dialog
    addSysMenu(index, row) {
      this.dialogs.editDialog.show = true;
      if (row) {
        this.dialogs.editDialog.form.parentMenu = row;
        this.dialogs.editDialog.title = "添加 " + row.name + " 的子菜单";
      } else {
        this.dialogs.editDialog.title = "添加顶级菜单";
      }
    },
    //添加或修改系统菜单
    editDialogOnSubmit() {
      let form = this.dialogs.editDialog.form;
      let id = form.parentMenu.id;
      let name = form.name;
      let router = form.router;
      let params = new URLSearchParams();
      params.append("pid", id);
      params.append("name", name);
      params.append("router", router);
      API.menu.add(params, () => {
        this.init(true);
      })
      this.dialogs.editDialog.show = false;
    },
    editDialogOnCancel() {
      this.dialogs.editDialog.show = false;
    },
    init(flag) {
      API.menu.menuTree({}, (data) => {
        if (flag) {
          this.table.data = [];
          setTimeout(() => {
            this.table.data = data;
          }, 100);
        } else {
          this.table.data = data;
        }
      })
    }
  },
  created() {
    this.init();
  }

}
</script>

<style scoped>
/deep/ .el-dialog__body {
  padding: 0 20px;
  margin: 0;
}
</style>