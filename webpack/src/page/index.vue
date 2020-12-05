<template>
  <div id="app">
    <h4>{{message}}</h4>
  </div>
</template>

<script>

export default {
  name: "App",
  components: {},
  data() {
    return {
      message: 'Hello world'
    }
  }
};
</script>

<style lang="scss">
#app {
  font-family: Roboto, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
