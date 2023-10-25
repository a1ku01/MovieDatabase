<script setup>
import {computed} from 'vue'
import {useCounterStore} from "@/stores/counter";
import {movieImageUrls} from "@/constants"

const store = useCounterStore()

const selectedMovie = computed(() => store.selectedMovie)


</script>

<template>

  <div>
    <h1>{{selectedMovie.name}}</h1>
  </div>

  <div>
      <img :src="movieImageUrls[selectedMovie.uuid]" :id="selectedMovie.uuid" :alt="selectedMovie.name"
           class="h-full w-full object-cover object-center lg:h-full lg:w-full"/>
    </div>

  <div>
  </div>
</template>