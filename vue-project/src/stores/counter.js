import {defineStore} from 'pinia'

export const useCounterStore = defineStore('movieStore', {
    state: () => ({
        movies: [],
    }),
    getters: {
        filmByName: (state) => {
            //let nameQuery = ""
            return (nameQuery) => state.movies.filter(movie => movie.name.toLowerCase().includes(nameQuery?.toLowerCase()))
        },

        filmByGenre: (state) => {
           return (genreQuery) => state.movies.filter(movie => movie.genre === genreQuery)
       }

    },


    actions: {
        async fetchData() {
            const response = await fetch('/api/catalogue')
            this.movies = await response.json()
        },

    }
})

