// pages/confirm/confirm.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    userName: "",
    sex: "",
    birthday: "",
    phoneNum: "",
    region: "",
    location: "",
    email: "",
    pjIndex: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var fdata = getApp().globalData.fdata
    // var fdata = JSON.parse(options.fdata);
    console.log(fdata);
    this.setData({
      userName: fdata.userName,
      sex: fdata.sex,
      birthday: fdata.birthday,
      phoneNum: fdata.phoneNum,
      region: fdata.region,
      location: fdata.location,
      email: fdata.email,
      pjIndex: fdata.projectType,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  backIndex: function() {
    wx.reLaunch({
      url: '/pages/index/index',
    })
  }
})