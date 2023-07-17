const toggleButton = document.getElementById('toggleButton');
const table = document.getElementById('table');

toggleButton.addEventListener('click', () => {
  if (table.style.display === '' || table.style.display === 'table') {
    table.style.display = 'none';
  } else {
    table.style.display = 'table';
  }
});