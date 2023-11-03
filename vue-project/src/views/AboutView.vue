<script setup>
import {useCounterStore} from "@/stores/counter"

const store = useCounterStore()



import LoginSignupView from "@/views/LoginSignupView.vue";
import {ref} from "vue";

const showLogin = ref(false)
function toggleLogin() {
  showLogin.value = !showLogin.value
}



</script>

<template>
  <button @click="toggleLogin">Login</button>
  <LoginSignupView v-if="showLogin"/>
</template>

<style>

</style>
