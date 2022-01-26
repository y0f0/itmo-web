<template>
  <div class="comment">
    <div class="author">{{ name }}</div>
    <div class="text"> {{ text }}</div>
  </div>
</template>

<script>
export default {
  name: "Comment",
  props: ["name", "text"],
}
</script>

<style scoped>

</style>