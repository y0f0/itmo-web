<template>
  <div>
    <Comment v-for="comment in comments" :name="users[comment.userId].name" :text="comment.text" :key="comment.id"/>
  </div>
</template>


<script>
import Comment from "./Comment/Comment.vue";
export default {
  name: "Comments",
  props: ["comments", "users"],
  components: { Comment },
}
</script>

<style scoped>

</style>