import { defineConfig } from 'vite';
import htmlMinifier from 'vite-plugin-html-minifier';
import { resolve } from 'path';

export default defineConfig({
  // Using explicit relative path as base allows this to be deployed both to the root
  // of a domain (like user.github.io) or to a subpath (like user.github.io/repo-name)
  // without breaking.
  base: './',
  plugins: [
    htmlMinifier({
      minify: true,
    }),
  ],
  build: {
    rollupOptions: {
      input: {
        main: resolve(__dirname, 'index.html'),
        cv: resolve(__dirname, 'cv.html'),
      },
    },
    // Generate source maps for debugging (optional)
    sourcemap: true,
    // Ensure output is minified using best-in-class esbuild
    minify: 'esbuild',
    // Produce clean and separate assets directory
    outDir: 'dist',
    assetsDir: 'assets',
  }
})
