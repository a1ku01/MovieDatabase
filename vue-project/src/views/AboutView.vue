<script setup>

import {ref} from "vue";
import {useCounterStore} from "@/stores/counter"

const store = useCounterStore()


async function fetchData() {
 await store.fetchData()
}
fetchData()




</script>

<template>
  <div class="about">
    <h1>Films</h1>
    <ul>
      <li v-for ="(film, index) in store.movies" :key="index">
        {{film}}
      </li>
    </ul>

  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
