<script setup>

import {useCounterStore} from "@/stores/counter"
import {movieImageUrls} from "@/constants"

const movieStore = useCounterStore()


</script>

<template>
  <div class="mt-6 grid grid-cols-1 gap-x-6 gap-y-20 sm:grid-cols-2 lg:grid-cols-3 xl:gap-x-8">


  <div v-for="movie in movieStore.movies" :key="movie.film_unique_id">
    <div
        class="aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-md bg-gray-200 lg:aspect-none group-hover:opacity-75 lg:h-80">

      <p>{{ movie.name }}</p>
      <img :src="movieImageUrls[movie.film_unique_id]" :alt="movie.name"
           class="h-full w-full object-cover object-center lg:h-full lg:w-full"/>


    </div>
  </div>
  </div>



</template>
