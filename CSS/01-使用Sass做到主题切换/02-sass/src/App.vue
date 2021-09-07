<template>
  <div id="app">
    <button @click="changeTheme('dark')">Dark</button>
    <button @click="changeTheme('light')">Light</button>
    <button @click="changeTheme('color')">Color</button>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {},
  methods: {
    changeTheme(theme) {
      this.$store.commit('changeTheme', theme)
    },
  }
}
</script>

<style lang="scss">
@import "./src/assets/func";

* {
  margin: 0;
  padding: 0;
}

body {
  height: 100%;
}

body {
  @include background_color('bg1')
}

</style>
