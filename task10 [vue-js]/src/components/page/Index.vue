<template>
  <div class="posts">
    <Post v-for="post in Object.values(posts).sort((l, r) => r.id - l.id)"
          :post="post" :users="users" :key="post.id"/>
  </div>
</template>

<script>
import Post from "./Posts/Post";

export default {
    name: "Index",
    props: ["posts", "users"],
    components: {
      Post
    }
}
</script>

<style scoped>

</style>
