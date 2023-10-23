<script setup>

import {ref} from "vue";
import {useCounterStore} from "@/stores/counter"

const store = useCounterStore()

let search = ref()

async function fetchData() {
 await store.fetchData()
}
fetchData()


async function findFilmByName() {
  //console.log(search.value)
  let filtered = await store.findFilmByName(search.value)
  console.log(filtered)
}




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

  <div>
  <input type="text" v-model="search" id="search-input">
  <button @click="findFilmByName()">Search</button>
  </div>

  <div>
    <ul>
      <li v-for ="(film, index) in store.filteredNames" :key="index">
        {{film}}
      </li>
    </ul>
  </div>

</template>

<style>

</style>
