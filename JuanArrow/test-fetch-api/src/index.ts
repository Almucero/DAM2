import { fromFetch } from "rxjs/fetch"
import { switchMap, of } from "rxjs";

const contenedor = document.querySelector(".contenedor");
const botonPersonajes = document.querySelector(".botonPersonajes");
const botonPlanetas = document.querySelector(".botonPlanetas");

const characterData = fromFetch("http://localhost:3000/characters").pipe(
  switchMap(response => response.ok ? response.json() : of({ message: `Error ${response.status}` }))
);

const planetData = fromFetch("http://localhost:3000/planets").pipe(
  switchMap(response => response.ok ? response.json() : of({ message: `Error ${response.status}` }))
);

function mostrarPersonajes(personajes: any[]) {
  contenedor!.innerHTML = personajes.map((personaje: any) =>
    `
    <div class="contenedorPersonajes">
      <h1>${personaje.name}</h1>
    </div>
    `
  ).join("");
}

function mostrarPlanetas(planetas: any[]) {
  contenedor!.innerHTML = planetas.map((planeta: any) =>
    `
    <div class="contenedorPlanetas">
      <h1>${planeta.name}</h1>
    </div>
    `
  ).join("");
}

botonPersonajes?.addEventListener("click", () => {
  characterData.subscribe(response => {
    const personajes = Array.isArray(response) ? response : (response?.characters ?? []);
    mostrarPersonajes(personajes);
  });
});

botonPlanetas?.addEventListener("click", () => {
  planetData.subscribe(response => {
    const planets = Array.isArray(response) ? response : (response?.planets ?? []);
    mostrarPlanetas(planets);
  });
});

//<img src="${personaje.image}" alt="${personaje.name} foto"/>

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
