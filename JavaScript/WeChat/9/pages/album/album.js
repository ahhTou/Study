// pages/album/album.js
let utils = require("../../assets/request.js")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    baseUrl: null,
    data: {},
    total: 0,
    list: [],
    args: {
      id: null,
      skip: 0,
      limit: 6,
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.showLoading()

    let data = getApp().albumData

    this.setData({
      data,
      baseUrl: utils.getBaseUrl()
    })
    this.data.args.id = data.id

    this.getData()
  },

  getData() {

    if (this.data.args.skip > this.data.total) return

    let data = {
      ...this.data.args
    }

    this.data.args.skip += this.data.args.limit

    utils.getAlbumByID(data).then(res => {
      this.setData({
        list: [...this.data.list, ...res.data.data.list],
        total: res.data.data.list
      })

      wx.hideLoading()
    })

    let tian = new Tiantian()
    
    tian.reserve({
      'song': {
        totoal: 1,
        list: [{
            name: '甜蜜蜜',
            singer: '邓丽君'
          }
        ]}
    })

    tian.commit()

    tian.destory()


  },

})