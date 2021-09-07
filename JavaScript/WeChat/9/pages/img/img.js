// pages/img/img.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    url: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.setData({
      url: options.url
    })
  },

  
  download: function() {
    wx.downloadFile({
      url: this.data.url,
      success(res) {
        if (res.statusCode === 200) {
          wx.saveImageToPhotosAlbum({
            filePath: res.tempFilePath,
          })
        }
      }
    })
  }
})