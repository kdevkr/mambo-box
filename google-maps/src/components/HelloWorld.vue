<script setup>
import { ref } from 'vue'

defineProps({
  msg: String,
})

const count = ref(0)

const setPlace = (result) => {
  console.log(result)
}
</script>

<template>
  <h1>{{ msg }}</h1>

  <GMapAutocomplete
      placeholder="This is a placeholder"
      @place_changed="(result) => console.log(result)">
  </GMapAutocomplete>

</template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
