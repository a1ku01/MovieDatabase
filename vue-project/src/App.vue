<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Films from './components/Films.vue'
</script>

<template>
  <div class="header">
    <a href="#default" class="logo">Logo</a>
    <div class="header-center">

  <nav>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/film/:name">Films</RouterLink>
    <RouterLink to="/about">About</RouterLink>

  </nav>
    </div>
  </div>

  <RouterView />
</template>
<style scoped>
.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}
/* Style the header links */
.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px;
  line-height: 25px;
  border-radius: 4px;
}
/* Style the logo link (notice that we set the same value of line-height and font-size to prevent the header to increase when the font gets bigger */
.header a.logo {
  font-size: 25px;
  font-weight: bold;
}
/* Change the background color on mouse-over */
.header a:hover {
  background-color: #ddd;
  color: black;
}
/* Float the link section to the center */
.header-center {
  margin-left: 40%;
}
/* Add media queries for responsiveness - when the screen is 500px wide or less, stack the links on top of each other */
@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }

  .header-center {
    float: none;
  }
}
/*
HEADER END
*/
</style>
