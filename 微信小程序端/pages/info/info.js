// pages/info/info.js
//获取应用实例
const app = getApp()

Page({
  /**
   *页面的初始数据
   */
  data: {
    userName: "",
    sex: ['男', '女'],
    birthday: "",
    phoneNum: "",
    smsNum: "",
    smsText: "获取验证码",
    showSms: false,
    region: [],
    location: "",
    email: "",
    projectType: ['检测项目1', '检测项目2', '检测项目3', '检测项目4'],
    paperStatus: "",
    // demand: ['是', '否'],
  },

  onLoad: function() {

  },
  bindNameChange: function(e) {
    this.setData({
      userName: e.detail.value
    })
  },
  bindDateChange: function(e) {
    this.setData({
      birthday: e.detail.value
    })
  },
  bindGenderChange: function(e) {
    this.setData({
      sexIndex: e.detail.value
    })
  },
  bindRegionChange: function(e) {
    this.setData({
      region: e.detail.value
    })
  },
  bindLocationChange: function(e) {
    this.setData({
      location: e.detail.value
    })
  },
  bindEmailChange: function(e) {
    this.setData({
      email: e.detail.value
    })
  },
  bindProjectChange: function(e) {
    this.setData({
      pjIndex: e.detail.value
    })
  },
  bindDemandChange: function(e) {
    this.setData({
      paperStatus: e.detail.value
    })
  },
  bindPhoneChange(e) {
    if (e.detail.value.length == 11) {
      this.setData({
        showSms: true
      })
    } else {
      this.setData({
        showSms: false
      })
    }
    this.setData({
      phoneNum: e.detail.value
    })
  },
  bindSmsChange(e) {
    this.setData({
      smsNum: e.detail.value
    })
  },
  /**
   * 获取验证码
   */
  getSms() {
    var that = this
    if (!that.data.showSms) {
      return
    }
    if (!getApp().checkPhone(that.data.phone)) {
      wx.showModal({
        title: '提示',
        content: '请输入正确的手机号',
        showCancel: false
      })
      return
    }
    wx.showLoading({
      title: '获取中……',
      mask: true
    })
    wx.request({
      url: getApp().appData.host + "GetMsg", //仅为示例，并非真实的接口地址
      data: {
        "mobile": that.data.phone,
        "op": "1",
        "token": getApp().md5(that.data.phone + "|1"),
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded",
        // 'content-type': 'application/json', // 默认值
      },
      method: 'POST',
      success: function(res) {
        console.log("获取验证码", res.data)
        //请求成功
        if (res.data.state == 1) {
          that.setData({
            isfail: false,
          })
          wx.hideLoading()

          var countdown = 60;

          function settime() {
            if (countdown == 0) {
              that.setData({
                smsText: "重新获取验证码",
                showSms: true
              })
              countdown = 60;
            } else {
              that.setData({
                smsText: "重新发送(" + countdown + ")",
                showSms: false
              })
              console.log(that.data.smsText)
              countdown--;
              setTimeout(function() {
                settime()
              }, 1000)
            }
          }
          settime();
          setTimeout(function() {
            wx.showToast({
              title: '验证码已发送',
            })
          }, 300)
        } else { //请求失败
          that.setData({
            isfail: true,
          })
          wx.hideLoading()
          wx.showModal({
            title: '提示',
            content: res.data.msg,
            showCancel: false
          })
        }
      },
      fail: function(res) {
        that.setData({
          isfail: true,
        })
        wx.hideLoading()
      },
      complete: function() {
        wx.stopPullDownRefresh();
      }
    })
  },
  upConfirm: function() {
    wx.navigateTo({
      url: '/pages/confirm/confirm',
    })
  },
  formSubmit: function(e) {
    var that = this;
    var formData = e.detail.value;
    if (formData.userName.length == 0) {
      wx.showToast({
        title: '姓名不能为空!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (formData.sex.length == 0) {
      wx.showToast({
        title: '性别不能为空!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (formData.birthday.length == 0) {
      wx.showToast({
        title: '出生日期为空!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (formData.phoneNum.length <= 10) {
      wx.showToast({
        title: '手机号码错误!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (formData.smsNum.length <= 3) {
      wx.showToast({
        title: '验证码错误!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (formData.region.length == 0) {
      wx.showToast({
        title: '请选择所在地区!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (formData.location.length == 0) {
      wx.showToast({
        title: '请输入详细地址!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (formData.email.length == 0) {
      wx.showToast({
        title: '请输入邮箱地址!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (!formData.projectType.length) {
      wx.showToast({
        title: '请选择检测项目!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else {
      var app = getApp();
      app.globalData.fdata = e.detail.value;
      console.log('form发生了submit事件，提交数据：', e.detail.value)
      wx.request({
        url: "http://222.222.222.107:8080/addorder",
        header: {
          "Content-Type": "application/json"
        },
        method: "POST",
        data: JSON.stringify(formData),
        success: function(res) {
          var result = res.data.success
          console.log(res.data);
          if (res.data.status == 0) {
            wx.showToast({
              title: '提交失败！！！',
              icon: 'loading',
              duration: 1500
            })
          } else {
            wx.showToast({
              title: '提交成功！！！',
              icon: 'success',
              duration: 1000
            })
            if (formData.paperStatus == 0) {
              wx.navigateTo({
                // url: '../confirm/confirm?fdata=' + JSON.stringify(formData),
                url: '../confirm/confirm',
              })
              // }
            } else(
              wx.navigateTo({
                url: '../pay/pay',
              })
            )
          }
        }
      })
    }
  },

  formReset: function() {
    console.log('form发生了reset事件')
  }
})