<template>
  <div class="App">
    <h4>小文件上传</h4>
    <input type='file' @change="getFile"/>
    <button @click="toUploader">上传</button>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'Home',
  data: function () {
    return {
      file: null,
    }
  },
  methods: {
    toUploader() {
      const {file} = this
      let url = '/api/hello'
      // const config = {
      //   headers: {'Content-Type': 'multipart/form-data;boundary=' + new Date().getTime()}
      // }
      const config = {}
      const formData = new FormData()
      formData.append('fileUpload', file, file.name)
      axios.post(url, formData, config).then(() => {
        console.log('上传文件成功')
      })
    },
    getFile(e) {
      this.file = e.target.files[0]
      console.log(this.file)
    }
  }
}
</script>

<style lang="scss">
</style>
