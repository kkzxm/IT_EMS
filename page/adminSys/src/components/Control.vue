<template>
  <div class="hello">
    <el-container style="height: 100vh">
      <el-header style="height: 10%">
        <sell-header></sell-header>
      </el-header>

      <el-container>
        <el-aside>
          <sell-left></sell-left>
        </el-aside>
        <el-container>
          <el-main>
            <router-view></router-view>
          </el-main>
          <el-footer style="height: 10%">
            <sell-footer></sell-footer>
          </el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import sellHeader from "@/components/contrl/sell-header";
import sellFooter from "@/components/contrl/sell-footer";
import SellLeft from "@/components/contrl/sell-left";

export default {
  name: "Control",
  components: {SellLeft, sellHeader, sellFooter},
  data() {
    return {
    }
  },
  methods: {},
}
</script>

<style scoped lang="scss">
.hello {
  height: 100vh;

  .el-container {
    .el-header {
      padding: 0;
    }

    .el-aside {
      height: 100%;
      border-top: 3px solid #eeeeee;
      width: auto !important;
      background-color: #ffffff;
      padding: 5px 30px 0 0;
    }

    .el-main {
      overflow: hidden;
      padding: 10px 10px 0;
    }

    .el-footer {
    }
  }
}
</style>
