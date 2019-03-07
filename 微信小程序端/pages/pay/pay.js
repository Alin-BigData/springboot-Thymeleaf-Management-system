// // pages/pay/pay.js
// Page({

//   /**
//    * 页面的初始数据
//    */
//   data: {

//   },

//   /**
//    * 生命周期函数--监听页面加载
//    */
//   onLoad: function(options) {

//   },

//   /**
//    * 生命周期函数--监听页面初次渲染完成
//    */
//   onReady: function() {

//   },

//   /**
//    * 生命周期函数--监听页面显示
//    */
//   onShow: function() {

//   },

//   /**
//    * 生命周期函数--监听页面隐藏
//    */
//   onHide: function() {

//   },

//   /**
//    * 生命周期函数--监听页面卸载
//    */
//   onUnload: function() {

//   },

//   /**
//    * 页面相关事件处理函数--监听用户下拉动作
//    */
//   onPullDownRefresh: function() {

//   },

//   /**
//    * 页面上拉触底事件的处理函数
//    */
//   onReachBottom: function() {

//   },

//   /**
//    * 用户点击右上角分享
//    */
//   onShareAppMessage: function() {

//   },
//   // wx.login({
//   //   success: function(res) {
//   //     if (res.code) {
//   //       //发起网络请求 
//   //       wx.request({
//   //         url: '你的服务器地址',
//   //         data: {
//   //           code: res.code,
//   //           money: that.data.money,
//   //           //此次付款金额
//   //           dataType: 'json'
//   //         },
//   //         success: function(res) {
//   //           console.log("获取prepareId成功")
//   //           var out_trade_no = res.data.out_trade_no;
//   //           var prepay_id = res.data.prepay_id; //服务器返回的id
//   //         }
//   //       })
//   //     }
//   //   }
//   // }),
//   // /* 
//   //              appId
//   //              timeStamp 
//   //              nonceStr
//   //              package
//   //              signType
//   //              paySign
//   //               */
//   // var timeStamp = util.getTimeStamp();
//   // var nonceStr = util.creatNonceStr();prepay_id = 'prepay_id=' + prepay_id;
//   // /*
//   //                nonceStr,timeStamp,prepare_id
//   //                 */
//   // var sign = util.creatPaySign(nonceStr, timeStamp, prepay_id);
//   // /* 
//   //                调起支付
//   //                 */
//   // wx.requestPayment({
//   //   'timeStamp': timeStamp,
//   //   'nonceStr': nonceStr,
//   //   'package': prepay_id,
//   //   'signType': 'MD5',
//   //   'paySign': sign,
//   //   success: function(res) {
//   //     /* 
//   //                          查询账单并跳转
//   //                           */
//   //     wx.request({
//   //       url: '我的服务器上的查询账单的地址',
//   //       data: {
//   //         out_trade_no: that.data.out_trade_no,
//   //         money: that.data.money
//   //       },
//   //       success: function(res) {
//   //         console.log("查询到账单");
//   //       },
//   //       fail: function() {}
//   //     })
//   //   },
//   //   fail: function(res) {
//   //     console.log('调起支付返回结果失败>>>' + res);
//   //   },
//   //   complete: function(res) {
//   //     console.log('调起支付返回结果complete>>>' + res);
//   //   }
//   // }),




//   wxpay: function() {
//     var that = this;
//     wx.request({
//       url: 'https://888.com/api/order.ashx?action=get_pay_params',
//       method: 'post',
//       data: {
//         openid: that.data.openId,
//         user_id: that.data.userId
//       },
//       header: {
//         'Content-Type': 'application/x-www-form-urlencoded'
//       },
//       success: function(res) {
//         //if(res.data.status==1){
//         var order = res.data;
//         wx.requestPayment({
//           timeStamp: order.timeStamp,
//           nonceStr: order.nonceStr,
//           package: order.package,
//           signType: 'MD5',
//           paySign: order.paySign,
//           success: function(res) {
//             //支付成功，处理相应的订单
//             wx.request({
//               url: 'https://8888.com/api/order.ashx?action=order_edit_pay',
//               method: 'post',
//               data: {
//                 order_id: that.data.returnOrderId
//               },
//               header: {
//                 'Content-Type': 'application/x-www-form-urlencoded'

//               },
//               success: function(res) {
//                 var data = res.data;
//                 if (data.status == 1) {
//                   console.log("支付成功，处理订单：" + that.data.returnOrderId);
//                   wx.showToast({
//                     title: "订单支付并处理成功!",
//                     duration: 1000,
//                   });
//                   setTimeout(function() {
//                     wx.navigateTo({
//                       url: '../user/dingdan?currentTab=2&otype=deliver',
//                     });

//                   }, 1500);

//                 } else {
//                   wx.showToast({
//                     title: "订单处理失败!",
//                     duration: 2500

//                   });

//                 }

//               },
//               fail: function(e) {
//                 wx.showToast({
//                   title: '处理订单网络异常！',
//                   duration: 2000

//                 });

//               }
//             });

//           },
//           fail: function(res) {
//             wx.showToast({
//               title: '支付失败',
//               duration: 1000

//             });
//             wx.navigateTo({
//               url: '../user/dingdan?currentTab=0&otype=all',
//             });

//           }
//         })
//       },
//       fail: function() {
//         // fail
//         wx.showToast({
//           title: '支付时网络异常！',
//           duration: 2000

//         });

//       }
//     })
//   }
// })
// Component({
//   data: {
//     args: {
//       fee: 4000, // 支付金额，单位为分
//       paymentArgs: 'A' // 将传递到功能页函数的自定义参数
//     }
//   },
//   methods: {
//     // 支付成功的回调接口
//     paymentSuccess(e) {
//       console.log(e)
//     },
//     // 支付失败的回调接口
//     paymentFailed(e) {
//       console.log(e)
//     }
//   }
// })
// wx.requestPayment(
//   {
//     'timeStamp': '',
//     'nonceStr': '',
//     'package': '',
//     'signType': 'MD5',
//     'paySign': '',
//     'success': function (res) { },
//     'fail': function (res) { },
//     'complete': function (res) { }
//   }) 

var util = require('../../utils/util.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  },
  /**
   * 点击测试 支付效果
   */
  btnClickToPay: function () {
    var payInfo = {
      body: 'zhangTestWxPAy!',
      total_fee: 100,
      order_sn: sn ? sn : 0,
    }
    this.wxPay(payInfo);
  },

  /**
   * TODO 支付函数 【需要支付时调用此函数即可】
   * @param  {[type]} _payInfo [description]
   *  此处需要传入一个 json数组，是实际业务的数据，例如我传的类似：
   * var _payInfo = {
      body: 'zhangTestWxPAy!',
      total_fee: 100,
      order_sn: '10224302324',
    }
   * @return {[type]}          [description]
   */
  wxPay: function (_payInfo) {
    this.setData({
      loading: true
    });
    var payInfo = {
      body: 'zhangTestWxPAy!',
      total_fee: 10,
      order_sn: '10224302324'
    }
    //将所有可枚举属性的值从一个或多个源对象复制到目标对象,然后返回目标对象
    Object.assign(payInfo, _payInfo);
    if (payInfo.body.length == 0) {
      wx.showToast({
        icon: 'none',
        title: '支付信息描述错误'
      })
      return false;
    }
    if (payInfo.total_fee == 0) {
      wx.showToast({
        icon: 'none',
        title: '支付金额不能0'
      })
      return false;
    }
    if (payInfo.order_sn.length == 0) {
      wx.showToast({
        icon: 'none',
        title: '订单号不能为空'
      })
      return false;
    }
    var This = this;
    This.getOpenid(payInfo)
  },
  /**
   * 获取openID
   * 不管是微信网页支付还是小程序支付，都是需要获取当前用户的openID的
   */
  getOpenid: function (payInfo) {
    var self = this;
    wx.login({
      success: function (res) {
        var postData = {
          code: res.code
        };
        util.http_post('pay/getOpenID', postData, function(data){
          if(data.statu){
            payInfo.openid = data.data.openid;
            util.http_post('pay/prepay', payInfo, self.prepayCallBack);
          }else{
            util.showToast(0, '网络繁忙，请稍后再试...')
          }
        })
      },
      fail: function (res) {
        util.showToast(0, '登录凭证获取失败，可稍后再试...')
      }
    });
  },
  /**
   * 微信预支付回调函数处理
   */
  prepayCallBack: function (data) {
    var that = this;
    console.log('prepayCallBack:');
    console.log(data);
    if (!data.status) {
      util.showToast(0, data['errmsg']);
      return false;
    } else {
      var postData = {
        prepay_id: data.data.data.prepay_id
      };
      util.http_post('pay/pay', postData, that.payCallBack);
    }
  },
  /**
   * 微信唤醒支付的回调操作
   */
  payCallBack: function (payResult) {
    var self = this;
    console.log(payResult);
    if (payResult.status != 0) {
      wx.requestPayment({
        'timeStamp': payResult.timeStamp.toString(),
        'nonceStr': payResult.nonceStr,
        'package': payResult.package,
        'signType': payResult.signType,
        'paySign': payResult.paySign,
        'success': function (succ) {
          //此处做支付成功后的页面展示
          console.log('Pay-Success');
          // success && success(succ);
          wx.redirectTo({
            url: '/pages/cart/results/index?status=1',
          });
        },
        'fail': function (err) {
          //此处做支付失败后的页面展示
          console.log('Pay-Fail');
          console.log(err);
          // fail && fail(err);
          wx.redirectTo({
            url: '/pages/cart/results/index?status=0',
          });
        },
        'complete': function (comp) {
          self.setData({
            loading: false
          })
        }
      })
    } else {
      console.log('Fail-Pay');
    }
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  },
})