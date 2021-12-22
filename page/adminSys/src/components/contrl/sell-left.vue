<template>
  <div class="sell-left">
    <el-tree
        :props="leftTree.props"
        :data="leftTree.data"
        @node-click="loadClick">
    </el-tree>
  </div>
</template>

<script>

export default {
  name: 'sell-left',
  props: ['setThisTagGroup', 'setThisTagId'],
  data() {
    return {
      leftTree: {
        props: {
          label: 'name',
          children: 'children',
          isLeaf: 'leaf'
        },
        data: [
          {
            name: "员工管理",
            router: "employees"
          },
          {
            name: "部门管理",
            router: "department"
          },
          {
            name: "项目管理",
            router: "project"
          }
        ]
      }
    };
  },
  methods: {
    loadClick(data) {
      if (data.router) {
        this.$router.push({name: data.router});
      }
    }
  }
}
</script>

<style scoped lang="scss">
.sell-left {
  height: 100%;

  .el-tree {
    border-right: 0;
    height: 100%;
    background-color: rgba(255, 255, 255, 0);
  }
}
</style>
