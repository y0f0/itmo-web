<template>
  <div class="posts">
    <Post v-for="post in Object.values(posts).sort((l, r) => r.id - l.id)"
          :post="post" :key="post.id"/>
  </div>
</template>

<script>
import Post from "./Post";

export default {
  name: "Index",
  props: ["posts"],
  components: {
    Post
  }
}
</script>

<style scoped>

</style>
