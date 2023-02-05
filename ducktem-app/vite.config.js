import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },  server: {
    proxy: {
      "/members": {
        target: "http://192.168.0.15:8080",
      },
      "/categorys": {
        target: "http://192.168.0.15:8080",
      },
      "/products": {
        target: "http://192.168.0.15:8080",
      },
      "/login": {
        target: "http://192.168.0.15:8080",
      },
      "/token": {
        target: "http://192.168.0.15:8080",
      },"/wish": {
        target: "http://192.168.0.15:8080",
      },
    },
  },
})
