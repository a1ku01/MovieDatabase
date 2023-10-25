<script setup>

import {useCounterStore} from "@/stores/counter"
import {movieImageUrls} from "@/constants"

const movieStore = useCounterStore()

function openImg(uuid) {
  //alert(uuid)
  let image = document.getElementById(uuid);
  let source = image.src;
  window.open(source);
}

</script>

<template>
  <div class="mt-6 grid grid-cols-1 gap-x-6 gap-y-20 sm:grid-cols-2 lg:grid-cols-3 xl:gap-x-8">


  <div v-for="movie in movieStore.movies" :key="movie.uuid">
    <div
        class="aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-md bg-gray-200 lg:aspect-none group-hover:opacity-75 lg:h-80">
      <!--
            <p>{{ movie.name }}</p>
            <img @click="openImg(movie.uuid)" :src="movieImageUrls[movie.uuid]" :id="movie.uuid" :alt="movie.name"
                 class="h-full w-full object-cover object-center lg:h-full lg:w-full"/>
                 -->
            <router-link :to="'/films/' + movie.name" class="movie-link">
          <img @click="openImg(movie.uuid)" :src="movieImageUrls[movie.uuid]" :id="movie.uuid" :alt="movie.name"
                 class="h-full w-full object-cover object-center lg:h-full lg:w-full"/>
              <div class="movie-detail">
                <h3>{{ movie.name }}</h3>
                <p v-if="movie.description !== ''">{{ movie.description }}</p>
                <p v-else>Click to see more details</p>
              </div>
            </router-link>

    </div>
  </div>
  </div>




</template>
