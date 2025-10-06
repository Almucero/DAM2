import { fromFetch } from "rxjs/fetch"
import { switchMap, of } from "rxjs";

const contenedor = document.querySelector(".contenedor");

const data = fromFetch("https://dragonball-api.com/api/characters").pipe(
  switchMap(response => {
    if (response.ok) {
      return response.json();
    }
    else {
      return of({message: `Error ${response.status}`})
    }
  })
);

data.subscribe(response => {
  const personajes = response.items;
  mostrarPersonajes(personajes);
});

function mostrarPersonajes(personajes: any[]) {
  contenedor!.innerHTML = personajes.map((personaje: any) =>
    `
    <div class="contenedorPersonajes">
      <img src="${personaje.image}" alt="${personaje.name} foto"/>
      <h1>${personaje.name}</h1>
    </div>
    `
  ).join("");
}

/*Forma previa:

const html = document.querySelector("html");
const boton = document.querySelector(".boton");
const contenedor = document.querySelector(".contenedor");

async function obtenerPersonajes() {
  await fetch("https://dragonball-api.com/api/characters")
    .then((response) => response.json())
    .then((data) => {
      data.items.forEach((personaje: any) => {
        let texto = document.createElement("div");
        texto.classList.add("contenedorPersonaje");
        texto.innerHTML = `
          <h1>${personaje.name}</h1>
          <p>ki: ${personaje.ki}</p> 
          <P>maxKi: ${personaje.maxKi}</p>
          <p>race: ${personaje.race}</p>
          <p>gender: ${personaje.gender}</p>
          <p>description: ${personaje.description}</p>
          <p><img src="${personaje.image}"></p>
          <p>affilitation: ${personaje.affiliation}</p>
          <br>
        `;
        contenedor?.appendChild(texto);
      });
    })
    .catch((error) => console.error(error));
}

boton?.addEventListener("click", obtenerPersonajes);*/
