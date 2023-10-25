import {defineStore} from 'pinia'

export const useCounterStore = defineStore('movieStore', {
    state: () => ({
        movies: [],
        selectedMovie: null,
    }),
    getters: {
        filteredMovies: (state) => {
            return (nameQuery) => state.movies
                .filter(movie => !nameQuery || movie.name.toLowerCase().includes(nameQuery?.toLowerCase()))
        }
    },
    actions: {
        async fetchData() {
            const response = await fetch('/api/catalogue')
            this.movies = await response.json()
        },

        async setSelectedMovie(movie){
             this.selectedMovie = movie
        }

    }
})

