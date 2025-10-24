import { Component, Signal } from '@angular/core';
import { Producto } from '../types/productos';
import { ProductosService } from '../productos.service';

@Component({
  selector: 'app-lista-componentes',
  imports: [],
  templateUrl: './lista-componentes.component.html',
  styleUrl: './lista-componentes.component.scss'
})
export class ListaComponentesComponent {
  prodcutos: any;
  constructor(private productosSvc: ProductosService){
    this.prodcutos = this.productosSvc.productos;
  }
  ngOnInit(): void {
    this.productosSvc.obtenerProductos();
  }
}
