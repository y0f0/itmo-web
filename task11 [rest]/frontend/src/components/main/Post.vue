<template>
  <article>
    <div class="title"><a @click.prevent="showPost()" href="#">{{ post.title }}</a></div>
    <div class="information">By {{ post.user.name}} </div>
    <div class="body">{{ post.text }}</div>
    <div class="footer">
      <div class="left">
        <img src="../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
        <span class="positive-score"></span>
        <img src="../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
      </div>
      <div class="right">
        <img src="../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>
      </div>
    </div>
  </article>
</template>

<script>

export default {
  name: "Post",
  props: ["post"],
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