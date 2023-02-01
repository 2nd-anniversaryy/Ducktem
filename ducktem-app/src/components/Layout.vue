<template>
  <Header ref="header" />
  <router-view class="fade" @click="this.$refs.header.onClickOutside()"></router-view>
  <Footer @click="this.$refs.header.onClickOutside()" />
</template>

<script setup>
import Header from './Header.vue';
import Footer from './Footer.vue';
</script>

<style></style>
