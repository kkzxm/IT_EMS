<template>
  <div>
    <el-table
        :data="table.data"
        style="width: 100%">
      <el-table-column v-for="(da,index) in table.structure" :key="index"
                       :prop="da.prop"
                       :label="da.label">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "catalog",
  data() {
    return {
      table: {
        data: [],
        structure: [
          {label: "库名", prop: "name"},
        ]
      }
    }
  }
}
</script>

<style scoped>

</style>