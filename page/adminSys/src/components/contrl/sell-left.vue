<template>
  <div class="sell-left">
    <el-tree
        :props="props"
        :load="loadNode"
        @node-click="loadClick"
        lazy>
    </el-tree>
  </div>
</template>

<script>
import {API} from '@/api'

export default {
  name: 'sell-left',
  props: ['setThisTagGroup', 'setThisTagId'],
  data() {
    return {
      props: {
        label: 'name',
        children: 'children',
        isLeaf: 'leaf'
      },
    };
  },
  methods: {
    loadNode(node, resolve) {
      let params = node.data ? {id: node.data.id} : {id: 0};
      API.menu.menuTree(params, (data) => {
        resolve(data)
      });
    },
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
