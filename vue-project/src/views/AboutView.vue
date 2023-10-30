<script setup>

import {ref, computed} from "vue";
import {useCounterStore} from "@/stores/counter"

const store = useCounterStore()


async function fetchData() {
 await store.fetchData()
}
fetchData()

</script>

<template>
  <div class="about">
    <h1></h1>
    <ul>
      <li v-for ="(film, index) in store.movies" :key="index">
        {{film}}
      </li>
    </ul>
  </div>

</template>

<style>

</style>
