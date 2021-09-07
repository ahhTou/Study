// components/simple-view-img/SimpleViewImg.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    url: {
      type: JSON,
      value: "https://s3.ax1x.com/2020/11/20/DQrl9J.jpg"
    },
    down: {
      type: Boolean,
      value: false,
    }

  },

  /**
   * 组件的初始数据
   */
  data: {

  },

  /**
   * 组件的方法列表
   */
  methods: {
    toDownload(e) {
      let url = e.currentTarget.dataset.url
      if (!this.data.down) return
      wx.navigateTo({
        url: "/pages/img/img?url=" + url
      })
    }
  }
})