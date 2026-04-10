// This is the main JavaScript entry point.
// Vite allows you to use modern ES modules and it will compile them down for broad browser support.

if ('addEventListener' in window) {
  window.addEventListener('load', function () { document.body.className = document.body.className.replace(/\bis-preload\b/, ''); });
  document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
}
