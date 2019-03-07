//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null,
    fdata:null,
  },

  appData: {
    host: "https://appshi.api.stonebuy.com/mobile/",
    // host: "http://192.168.18.166:4369/mobile/",
    userInfo: "",
    userInfoX: "",
    notifyUserInfo: "notifyUserInfo",
    appid: "wxe9e7dbf1e54d9f26",
    secret: "bd32ec5c74f681a135e1e773f3be4873",
    tpuser: "",
    SECRET: "3trf6572dft565yt",
  },
  md5: function (str) {
    var my_provin = str + this.appData.SECRET;
    var md5_provin = md5utf.md5(my_provin);
    var md5_1_provin = md5_provin.substr(0, 3);
    var md5_2_provin = md5_provin.substr(8, 3);
    var md5_3_provin = md5_provin.substr(16, 3);
    var md5_4_provin = md5_provin.substr(24, 3);
    var token = md5_1_provin + md5_2_provin + md5_3_provin + md5_4_provin;
    return token
  },
  /**
 * 检查电话号码
 */
  checkPhone: function (phone) {
    if (!(/^1[1356789]\d{9}$/.test(phone))) {
      return false;
    } else {
      return true;
    }
  }
})