<template>
    <div class="middle">
        <Sidebar :posts="viewPosts"/>
        <main>
            <Index v-if="page === 'Index'" :posts="posts"/>
            <Enter v-if="page === 'Enter'"/>
            <Register v-if="page === 'Register'"/>
            <Users v-if="page === 'Users'" :users="viewUsers"/>
            <Post v-if="page === 'Post'" :post="post" :users="users" :show_comments="true"/>
        </main>
    </div>
</template>

<script>
import Sidebar from "./sidebar/Sidebar";
import Index from "./main/Index";
import Enter from "./main/Enter";
import Register from "./main/Register";
import Users from "./main/UsersTable/Users";
import Post from "./main/Post";

export default {
    name: "Middle",
    data: function () {
        return {
            page: "Index"
        }
    },
    components: {
        Register,
        Enter,
        Index,
        Sidebar,
        Users,
        Post
    },
    props: ["posts", "users"],
    computed: {
        viewPosts: function () {
          return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
        },
        viewUsers: function () {
          return Object.values(this.users).sort((a, b) => a.id - b.id);
        }
    },
    beforeCreate() {
        this.$root.$on("onChangePage", (page) => this.page = page)
        this.$root.$on("onShowPost", (post) => {
          this.post = post;
          this.page = "Post";
        })
    }
}
</script>

<style scoped>

</style>
