<script setup>

import {ref, computed} from "vue";
import {useCounterStore} from "@/stores/counter"

const store = useCounterStore()

const search = ref()
const filteredByName = computed(() => store.filmByName(search.value))
//const filteredByGenre = computed() => store.filmByGenre(categoryGenre.value)


async function fetchData() {
 await store.fetchData()
}
fetchData()



</script>

<template>

</template>

<style>

</style>
