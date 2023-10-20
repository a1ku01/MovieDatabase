import {ref} from 'vue'
import {defineStore} from 'pinia'

export const useCounterStore = defineStore('movieStore', {
    state: () => ({
        movies: [],
    }),
    getters: {},
    actions: {
        async fetchData() {
            const response = await fetch('/api/catalogue')
            this.movies = await response.json()

        },
    },
})

