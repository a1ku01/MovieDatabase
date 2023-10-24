<script setup>

import {ref, computed} from "vue";
import {useCounterStore} from "@/stores/counter"

const store = useCounterStore()

const search = ref()
const filteredByName = computed(() => store.filmByName(search.value))
//const filteredByGenre = computed() => store.filmByGenre(categoryGenre.value)


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

  <div>
  Search: <input type="text" v-model="search" id="search-input">
    <ul>
      <li v-for ="(film, index) in filteredByName" :key="index">
        {{film}}
      </li>
    </ul>
  </div>



</template>

<style>

</style>
