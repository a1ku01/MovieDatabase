<script setup>

</script>

<template>
  <div>

    Select year: <select
      @change="$emit('changeYear', $event.target.value)">
    <option/>
    <option value="1995">1995</option>
    <option value="1999">1999</option>
    <option value="2003">2003</option>
    <option value="2010">2010</option>
    <option value="2013">2013</option>
    <option value="2014">2014</option>
    <option value="2015">2015</option>
    <option value="2016">2016</option>
  </select>
  </div>
</template>

<style scoped>

</style>