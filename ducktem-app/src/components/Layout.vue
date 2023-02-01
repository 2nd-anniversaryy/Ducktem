<template>
  <Header ref="header" />
  <router-view class="fade" @click.prevent="this.$refs.header.onClickOutside()"></router-view>
  <Footer @click.prevent="this.$refs.header.onClickOutside()" />
</template>

<script setup>
import Header from './Header.vue';
import Footer from './Footer.vue';
</script>

<style>

</style>
