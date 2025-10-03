const html = document.querySelector("html");
const boton = document.querySelector(".boton");

function obtenerPersonajes() {
  fetch("https://dragonball-api.com/api/characters")
    .then((response) => response.json())
    .then((data) => {
      const personaje = data.items[0];
      let texto = document.createElement("p");
      texto.textContent = personaje.name; 
      html?.appendChild(texto);
    })
    .catch((error) => console.error(error));
}

boton?.addEventListener("click", obtenerPersonajes);