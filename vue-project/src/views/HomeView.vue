<script setup>
import '@/assets/homeStyle.css'
import {useCounterStore} from "@/stores/counter"
import {movieImageUrls} from "@/constants"
import {ref, computed} from "vue";
import router from "@/router";
import SearchFilterGenre from '../components/SearchFilterGenre.vue'
import SearchFilterYear from '../components/SearchFilterYear.vue'

const movieStore = useCounterStore()
const nameFilter = ref()
const genreFilter = ref()
const yearFilter = ref()

function setGenreFilter(genre) {
  genreFilter.value = genre
}
function setYearFilter(year) {
  yearFilter.value = year
}

const filteredMovies = computed(() => movieStore.filteredMovies(nameFilter.value, genreFilter.value, yearFilter.value))

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
  <div class="page">
    <div class="mainsearch">
      <label
          class="mx-auto relative bg-white min-w-sm max-w-2xl flex flex-col md:flex-row items-center justify-center border py-2 px-2 rounded-2xl gap-2 shadow-2xl focus-within:border-gray-300"
          for="search-bar">
        <input type="text" placeholder="Search movies" v-model="nameFilter" id="search-input"
               class="px-6 py-2 w-full rounded-md flex-1 outline-none bg-white" required="">
        <!--
        <button type="submit"
                class="w-full md:w-auto px-6 py-3 bg-black text-white fill-white active:scale-95 duration-100 border will-change-transform overflow-hidden relative rounded-xl transition-all">

          <div class="flex items-center transition-all opacity-1">
            <span class="text-sm font-semibold whitespace-nowrap truncate mx-auto">Search</span>
          </div>
        </button>
        -->
      </label>
    </div>
    <div class="search1">
      <div class="mx-auto relative min-w-sm max-w-2xl flex flex-col md:flex-row items-center justify-center gap-2">
        <SearchFilterGenre @change-genre="(eventValue) => setGenreFilter(eventValue)"/>

        <SearchFilterYear @change-year="(eventValue) => setYearFilter(eventValue)"/>
      </div>
    </div>
  </div>

<!--
  <div>
    Search: <input type="text" v-model="nameFilter" id="search-input">

    <SearchFilterGenre @change-genre="(eventValue) => setGenreFilter(eventValue)"/>

    <SearchFilterYear @change-year="(eventValue) => setYearFilter(eventValue)"/>

  </div>
-->
  <div class="home-list">


    <div v-for="movie in filteredMovies" :key="movie.uuid">
      <div
          class="movie">


        <img @click="selectMovie(movie)" :src="movieImageUrls[movie.uuid]" :id="movie.uuid" :alt="movie.name"
             class="image"/>
        <div class="heading">
          <p>{{ movie.name }}</p>

          <div class="description">
            <p>{{ movie.description }}</p>
          </div>
          <div class="year">
            <p>{{ movie.year }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>




</template>
