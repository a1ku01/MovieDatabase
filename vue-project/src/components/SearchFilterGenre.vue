<script setup>

</script>

<template>

  <div>

    Select genre: <select
      @change="$emit('changeGenre', $event.target.value)"> <!-- emit "changeGenre" = @change-genre -->
    <option/>
    <option value="Sci-Fi">Sci-Fi</option>
    <option value="Comedy">Comedy</option>
    <option value="History">History</option>
    <option value="Drama">Drama</option>
    <option value="Biography">Biography</option>
    <option value="Action">Action</option>
  </select>
  </div>


</template>
<style scoped>


</style>



