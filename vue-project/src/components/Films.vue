<script setup>
import '@/assets/filmsStyle.css'
import '@/assets/ratingsStyle.css'
import {computed, ref, onMounted} from 'vue'
import {useCounterStore} from "@/stores/counter";
import {movieImageUrls} from "@/constants"

const commentField = ref()
const averageRating = ref()
const store = useCounterStore()

const selectedMovie = computed(() => store.selectedMovie)

const comments = ref()

async function send() {
  const data = {
    comment: commentField.value
  }
  const response = await fetch(`/api/movies/${selectedMovie.value.id}/comments`, {
    method: "POST",
    headers: {"Content-Type": "application/json",},
    body: JSON.stringify(data),
  });
  console.log(commentField.value)
  showComment()
  commentField.value = ""
}

async function showComment() {
  const response = await fetch(`/api/movies/${selectedMovie.value.id}/comments`);
  comments.value = await response.json()
}
showComment()


async function sendRating(rating) {
  const data = {
    rating: rating
  }
  await fetch(`/api/movies/${selectedMovie.value.id}/rating`, {
    method: "POST",
    headers: {"Content-Type": "application/json",},
    body: JSON.stringify(data),
  });
  await fetchRatingSum()
}

onMounted(() => {
  fetchRatingSum()
  let stars = document.querySelectorAll(".ratings span");
  const ratingBox = document.getElementById("rating-box")
  let ratingsSelected = new Map()
  const {name, uuid} = selectedMovie.value
  for (let star of stars) {
    star.addEventListener("click", function () {
      let children = star.parentElement.children;
      for (let child of children) {
        if (child.getAttribute("data-clicked")) {
          child.removeAttribute("data-clicked")
          ratingsSelected.delete(selectedMovie.value.uuid)
          break
        }
      }

      this.setAttribute("data-clicked", "true");
      let rating = this.dataset.rating;
      sendRating(rating)

      let data = {
        "rating": rating,
        "movie": name,
      }
      ratingsSelected.set(uuid, data);
      localStorage.setItem("rating", JSON.stringify(Array.from(ratingsSelected.entries())));
    });
  }

  if (localStorage.getItem("rating")) {
    ratingsSelected = new Map(JSON.parse(localStorage.getItem("rating")));
    const movieRating = ratingsSelected.get(selectedMovie.value.uuid)
    if (movieRating) {
      let reverse = Array.from(ratingBox.children).reverse();
      let index = parseInt(movieRating.rating) - 1;
      reverse[index].setAttribute("data-clicked", "true");
    }
  }
})

async function fetchRatingSum() {
  const response = await fetch(`/api/movies/${selectedMovie.value.id}/rating`)
  const average = await response.text();
  console.log(average)
  averageRating.value = parseFloat(average)
  console.log(averageRating.value)
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
      <div class="ratings-wrapper">
        <div id="rating-box" class="ratings">
          <span data-rating="5">★</span>
          <span data-rating="4">★</span>
          <span data-rating="3">★</span>
          <span data-rating="2">★</span>
          <span data-rating="1">★</span>
        </div>
      </div>
      <div class="ratings-score">
        <p>{{ averageRating }}</p>
      </div>
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
        <div class="p-2"><img src="https://i.imgur.com/Ur43esv.jpg" alt="user" width="50" class="rounded-circle">
        </div>
          <h6 class="font-medium">Username</h6>
          <ul>
            <li v-for="(comment, index) in comments" :key="index">
              {{ comment.comment }}
            </li>
          </ul>
    </div>



</template>