<script setup>
import '@/assets/filmsStyle.css'
import {computed, ref} from 'vue'
import {useCounterStore} from "@/stores/counter";
import {movieImageUrls} from "@/constants"

const commentField = ref()

const store = useCounterStore()

const selectedMovie = computed(() => store.selectedMovie)

async function send(){
  const data = {
    comment: commentField.value
  }
  console.log(selectedMovie.value)
  const response = await fetch(`/api/movies/${selectedMovie.value.id}/comments`, {
    method: "POST",
    headers: {"Content-Type": "application/json",},
    body: JSON.stringify(data),
  });
  console.log(commentField.value)
}

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


  <div>
    <label for="comment" class="block text-sm font-medium leading-6 text-gray-900">Comment</label>
    <div class="mt-2">
      <input v-model="commentField" type="text" name="comment" id="comment" class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" placeholder="Leave a comment" />
      <button @click="send()">Submit</button>
    </div>
  </div>
</template>