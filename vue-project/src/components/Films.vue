<script setup>
import '@/assets/filmsStyle.css'
import {computed, ref} from 'vue'
import {useCounterStore} from "@/stores/counter";
import {movieImageUrls} from "@/constants"

const commentField = ref()

const store = useCounterStore()

const selectedMovie = computed(() => store.selectedMovie)

const comments = ref()

async function send() {
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

async function showComment() {
  const response = await fetch(`/api/movies/${selectedMovie.value.id}/comments`);
  comments.value = await response.json()
}
showComment()

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
      <br>
      <div class="movie-text">
        <p>{{ selectedMovie.description }}</p>
        <br>
        <div class="Director">
          <p>Director: {{ selectedMovie.director }}</p>

          <div class="year">
            <p>Year: {{ selectedMovie.year }}</p>

            <div class="actors">
              <p>Cast: {{ selectedMovie.actors }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  <div>
    <label for="comment" class="block text-xl font-normal leading-10 text-black">Leave a comment</label>
    <div class="mt-2">
      <input v-model="commentField" type="text" name="comment" id="comment"
             class="mb-2 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
             placeholder="Your comment"/>
      <button @click="send()" class="w-full md:w-auto px-5 py-2 bg-gray-300 text-black font-medium fill-white active:scale-95 duration-100 border will-change-transform overflow-hidden relative rounded-xl transition-all">Send</button>
    </div>
  </div>
  <br>

  <div>
    <label for="comments" class="block text-sm font-medium leading-6 text-gray-900">Recent reviews</label>
    <div class="mt-2">
        <div class="p-2"><img src="https://i.imgur.com/Ur43esv.jpg" alt="user" width="50" class="rounded-circle">
        </div>
          <h6 class="font-medium">Username</h6>
          <ul>
            <li v-for="(comment, index) in comments" :key="index">
              {{ comment.comment }}
            </li>
          </ul>
    </div>
  </div>

</template>