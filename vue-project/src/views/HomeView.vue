<script setup>

import {useCounterStore} from "@/stores/counter"
import {movieImageUrls} from "@/constants"
import {ref, computed} from "vue";
import router from "@/router";

const movieStore = useCounterStore()
const nameQuery = ref()

const filteredMovies = computed(() => movieStore.filteredMovies(nameQuery.value))

async function fetchData() {
  await movieStore.fetchData()
}
fetchData()


function selectMovie(movie) {
  //alert(uuid)
 // let image = document.getElementById(uuid);
 // let source = image.src;
 // window.open(source);
  movieStore.setSelectedMovie(movie)
  router.push({ path: `/film/` + movie.name})
}


</script>

<template>
  <div class="mt-6 grid grid-cols-1 gap-x-6 gap-y-20 sm:grid-cols-2 lg:grid-cols-3 xl:gap-x-8">

    <div>
      Search: <input type="text" v-model="nameQuery" id="search-input" @input = "filter">
    </div>
  <div v-for="movie in filteredMovies" :key="movie.uuid">
    <div
        class="aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-md bg-gray-200 lg:aspect-none group-hover:opacity-75 lg:h-80">
      <p>{{ movie.name }}</p>

     <img @click="selectMovie(movie)" :src="movieImageUrls[movie.uuid]" :id="movie.uuid" :alt="movie.name"
            class="h-full w-full object-cover object-center lg:h-full lg:w-full"/>
</div>
</div>
</div>



</template>
