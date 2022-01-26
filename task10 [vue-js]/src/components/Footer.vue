<template>
    <footer>
        <a href="/">Codeforces</a> &copy; 2021 by Mike Mirzayanov
        users: {{ usersAmount }}
        |
        posts: {{ postsAmount}}
    </footer>
</template>

<script>
export default {
    name: "Footer",
    props: ["usersAmount", "postsAmount"]
}
</script>

<style scoped>

</style>