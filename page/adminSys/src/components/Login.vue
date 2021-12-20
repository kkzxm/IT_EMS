<template>
  <div class="login_container">
    <div class="login_box">
      <!--头像区域-->
      <div class="avatar_box">
        <img src="../assets/img/kkzxm.jpg" alt/>
      </div>
      <!--表单区域-->
      <el-form label-width="0px" class="login_form">
        <el-form-item>
          <el-input prefix-icon="el-icon-user-solid" v-model="loginForm.nickName"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input prefix-icon="el-icon-lock" v-model="loginForm.password" show-password></el-input>
        </el-form-item>
        <el-form-item class="submit-buttons">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-dialog
        v-model="dialogVisible"
        width="30%"
        center
        :show-close="dialogVisible">
      <p style="text-align: center">{{ result.message }}</p>
      <template #footer>
    <span class="dialog-footer">
      <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
    </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import API from '../api/api_user'
import {setToken} from "@/api";

export default {
  name: "Login",
  data() {
    return {
      // 登录表单的数据绑定对象
      loginForm: {
        nickName: '',
        password: ''
      },
      dialogVisible: false,
      result: {
        message: ''
      }
    }
  },
  methods: {
    login() {
      API.login(this.loginForm).then((res) => {
        if (res.success) {
          setToken(res.data);

          this.$router.replace({path: '/'})
        } else {
          console.log(res);
          this.result.message = res.message
          this.dialogVisible = true
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.login_container {
  height: 100%;
  background: #2b4b6b;
}

.login_box {
  width: 450px;
  height: 300px;
  background: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);

  .avatar_box {
    padding: 10px;
    width: 130px;
    height: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background: #fff;

    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background: #eee;
    }
  }
}

.login_form {
  position: absolute;
  bottom: 0;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
}

.submit-buttons {
  padding: 0 10%;

  .el-button:first-child {
    width: 50%;
  }

  .el-button:last-child {
    width: 40%;
  }
}
</style>
