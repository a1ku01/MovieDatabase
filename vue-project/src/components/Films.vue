<script setup>
import '@/assets/filmsStyle.css'
import {computed} from 'vue'
import {useCounterStore} from "@/stores/counter";
import {movieImageUrls} from "@/constants"

const store = useCounterStore()

const selectedMovie = computed(() => store.selectedMovie)


</script>

<template>
  <div class="movie-banner">
    <img :src="movieImageUrls[selectedMovie.uuid]" :id="selectedMovie.uuid" :alt="selectedMovie.name"
         class="movie-poster"/>
  <div>
    <img :src="movieImageUrls[selectedMovie.uuid]" :id="selectedMovie.uuid" :alt="selectedMovie.name"
         class="movie-backdrop"/>
  </div>
  <div class="movie-detail">
    <div class="movie-heading">
      <h1>{{ selectedMovie.name }}</h1>
    </div>
    <div class="movie-text">
      <p>{{ selectedMovie.description }}</p>
    </div>
  </div>
  </div>
</template>