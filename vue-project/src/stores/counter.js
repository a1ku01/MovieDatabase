import {defineStore} from 'pinia'

export const useCounterStore = defineStore('movieStore', {
    state: () => ({
        movies: [],
        selectedMovie: null,
    }),
    getters: {
        filteredMovies: (state) => {
            return (nameFilter, genreFilter, yearFilter) => state.movies
                .filter(movie => !nameFilter || movie.name.toLowerCase().includes(nameFilter?.toLowerCase()))
                .filter(movie => !genreFilter || movie.genre.toLowerCase().includes(genreFilter?.toLowerCase()))
                .filter(movie => !yearFilter || movie.year === Number(yearFilter)) // 2001 != '2001'
        }
    },
    actions: {
        async fetchData() {
            const response = await fetch('/api/catalogue')
            this.movies = await response.json()
        },

        async setSelectedMovie(movie){
             this.selectedMovie = movie
        },
    },
    persist: true
})

