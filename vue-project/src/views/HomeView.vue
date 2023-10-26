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
  <div>
    Search: <input type="text" v-model="nameFilter" id="search-input">

    <SearchFilterGenre @change-genre="(eventValue) => setGenreFilter(eventValue)"/>

    <SearchFilterYear @change-year="(eventValue) => setYearFilter(eventValue)"/>

  </div>

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
