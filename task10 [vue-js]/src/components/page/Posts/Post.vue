<template>
  <article>
    <div class="title"><a @click.prevent="showPost()" href="#">{{ post.title }}</a></div>
    <div class="information">By {{ users[post.userId].name }} </div>
    <div class="body">{{ post.text }}</div>
    <div class="footer">
      <div class="left">
        <img src="../../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
        <span class="positive-score"></span>
        <img src="../../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
      </div>
      <div class="right">
        <img src="../../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>
        <a href="#">{{ getCommentsInPost(post).length }} </a>
      </div>
    </div>
    <Comments v-if="show_comments" :comments="getCommentsInPost(post)" :users="users"/>
  </article>
</template>

<script>
import Comments from "./Comments/Comments";

export default {
  name: "Post",
  props: ["post", "users", "show_comments"],
  components: { Comments },
  methods : {
    getCommentsInPost: function(post) {
      return Object.values(this.$root.$data.comments).filter((c) => c.postId === post.id);
    },
    showPost: function () {
      this.$root.$emit("onShowPost", this.post);
    }
  }
}
</script>

<style scoped>

</style>