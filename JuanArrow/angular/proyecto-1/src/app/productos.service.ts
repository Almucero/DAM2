import { Injectable, signal } from '@angular/core';
import { Producto } from './types/productos';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
  productos = signal<Producto[]>([
    { id: "1", nombre: 'Producto 1', precio: 100 },
    { id: "2", nombre: 'Producto 2', precio: 200 },
    { id: "3", nombre: 'Producto 3', precio: 300 },
    { id: "4", nombre: 'Producto 4', precio: 400 },
  ]);

  productoSeleccionado = signal<Producto | null>(null);
  constructor() {}

  seleccionarProducto(id:string) {
    let prodcucto: Producto | null = this.productos().find(p=>p.id===id) || null
    this.productoSeleccionado.set(prodcucto);
  }

  obtenerProductos() {
    this.productos.set([
      { id: "1", nombre: 'Producto 1', precio: 100 },
      { id: "2", nombre: 'Producto 2', precio: 200 },
      { id: "3", nombre: 'Producto 3', precio: 300 },
      { id: "4", nombre: 'Producto 4', precio: 400 },
    ])
  }
}
