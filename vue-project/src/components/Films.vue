<script setup>
import '@/assets/filmsStyle.css'
import {computed, ref, onMounted} from 'vue'
import {useCounterStore} from "@/stores/counter";
import {movieImageUrls} from "@/constants"

const commentField = ref()

const store = useCounterStore()

const selectedMovie = computed(() => store.selectedMovie)

const comments = ref()

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

async function showComment(){
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
    <div class="movie-text">
      <p>{{ selectedMovie.description }}</p>
    <div class="Director">
      <p>{{ selectedMovie.director }}</p>

      <div class="year">
        <p>{{ selectedMovie.year }}</p>

        <div class="actors">
          <p>{{ selectedMovie.actors }}</p>

    <div class="card">
      <h4 class="card-title">Recent reviews</h4>
      <div class="comments">
        <div class="d-flex flex-row comment-row m-t-0">
          <div class="p-2"><img src="https://i.imgur.com/Ur43esv.jpg" alt="user" width="50" class="rounded-circle"></div>
          <div class="comment-text w-100">
            <h6 class="font-medium">James Thomas</h6> <span class="m-b-15 d-block">This is awesome website. I would love to comeback again. </span>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
  </div>
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

  <div>
    <h1>Comments</h1>
    <ul>
      <!--
        comments = [
          {
            comment: "mingisugune kommentaar"
          },
          {
            comment: "teine kommentaar"
          }
        ]
      -->
      <li v-for ="(commentObjectMassiivist, index) in comments" :key="index">
        {{commentObjectMassiivist.comment}}
      </li>
    </ul>
  </div>


</template>