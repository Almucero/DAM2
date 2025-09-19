// Variables
let nombre: string = "Juan"; 
const edad: number = 30; 
var esActivo: boolean = true;

// Arrays
let numeros: number[] = [1, 2, 3];
let tupla: [string, number] = ["hola", 10];

// Enums
enum Color { Rojo, Verde, Azul }

// Matrices
let matriz: number[][] = [[1, 2], [3, 4]];

// Operadores
let esMayor: boolean = 5 > 3; // true
let suma: number = 5 + 3; // 8

// Funciones
function saludar(nombre:string): string {
    return `Hola, ${nombre}`;
}

saludar("Juan");



let randomValue: any = 10;
randomValue = "A string";
randomValue = true;


let uncertainValue: unknown = 10;
if (typeof uncertainValue === "string") {
  let stringValue: string = uncertainValue; // Seguro porque hemos verificado el tipo
}


function logMessage(message: string): void {
    console.log(message);
}

logMessage("Hola");

function error(message: string): never {
    throw new Error(message);
}

try {
    error("Error");
} catch (error) {
    console.log(error);
}

// Desestructuración de tuplas
let person: [string, number] = ["Juan", 25];
let [name, age] = person;

console.log(name);
console.log(age);

// Desestructuración de objetos
let person2: { name: string; age: number } = { name: "Juan", age: 25 };

console.log(person2);


// Enums
enum Color {
    Red = 1,
    Green = 2,
    Blue = 3
  }
  let color: Color = Color.Green;

console.log(color);

// Interfaces
interface Person {
    name: string;
    age: number;
}
let employee: Person = { name: "Bob", age: 30 };
console.log(employee);

// Type Aliases
type StringOrNumber = string | number;
let value: StringOrNumber = "Hello";
value = 123;

// Intersection and Union types
type A = { a: number };
type B = { b: number };
type C = A & B; // Intersection type: { a: number; b: number; }
type D = A | B; // Union type: { a: number } | { b: number }

let a: A = { a: 1 };
let b: B = { b: 2 };
let c: C = { a: 1, b: 2 };
let d: D = { a: 1 };
let e: D = { b: 2 };

console.log(c);
console.log(d);
console.log(e);




let age2: number = 17;

//Conditional statements
if (age2 >= 18) {
  console.log("You are an adult.");
} else {
  console.log("You are not an adult.");
}


let score: number = 85;

//Conditional statements with else if
if (score >= 90) {
  console.log("Grade: A");
} else if (score >= 80) {
  console.log("Grade: B");
} else if (score >= 70) {
  console.log("Grade: C");
} else {
  console.log("Grade: F");
}

//switch statement
let fruit: string = "apple";
switch (fruit) {
  case "apple":
    console.log("You chose an apple.");
    break;
  case "banana":
    console.log("You chose a banana.");
    break;
  case "cherry":
    console.log("You chose a cherry.");
    break;
  default:
    console.log("Unknown fruit.");
}


//for loop
for (let i = 0; i < 5; i++) {
    console.log(`Iteration ${i}`);
}

//while loop
let count: number = 0;
while (count < 5) {
  console.log(`Count: ${count}`);
  count++;
}

//do while loop
let count2: number = 0;
do {
  console.log(`Count: ${count2}`);
  count2++;
} while (count2 < 5);

//for of loop
let fruits: string[] = ["apple", "banana", "cherry"];
for (let fruit of fruits) {
  console.log(`Fruit: ${fruit}`);
}

//for in loop
let person3: { name: string; age: number } = { name: "Juan", age: 25 };
for (let key in person3) {
  console.log(`${key}: ${person3[key as keyof typeof person3]}`);
}

function riskyOperation() {
    // Simulate an error
    throw new Error("Something went wrong!");
  }

//try catch finally
try {
    let result = riskyOperation();
    console.log(result);
} catch (error) {
    console.error("An error occurred:", error);
} finally {
    console.log("This will always execute.");
}



// Clases
class Persona {
    private nombre: string;
    private edad: number;

    constructor(nombre: string, edad: number) {
        this.nombre = nombre;
        this.edad = edad;
    }

    saludar() {
        console.log(`Hola, soy ${this.nombre}`);
    }
}

// Instanciación de clases
let persona = new Persona("Juan", 30);
persona.saludar();

let persona2: Persona = new Persona("Antonio", 30);
persona2.saludar();

let persona3: Persona = new Persona("Ana", 30);
persona3.saludar();

// Herencia
class Empleado extends Persona {
    salario: number;

    constructor(nombre: string, edad: number, salario: number) {
        super(nombre, edad);
        this.salario = salario;
    }

    mostrarSalario() {
        console.log(`Salario: ${this.salario}`);
    }
}

let empleado = new Empleado("Juan", 30, 1000);
empleado.mostrarSalario();

// Herencia
let empleado2: Empleado = new Empleado("Antonio", 30, 1000);
empleado2.mostrarSalario();


// Interfaces
interface Animal {
    nombre: string;
    mover(): void;
}

// Implementación de interfaces
class Perro implements Animal {
    nombre: string;

    constructor(nombre: string) {
        this.nombre = nombre;
    }

    mover() {
        console.log(`${this.nombre} se está moviendo`);
    }
}

let perro: Perro = new Perro("Firulais");
perro.mover();

//Polymorphism
class Animal {
    nombre: string;

    constructor(nombre: string) {
        this.nombre = nombre;
    }
}

class Gato extends Animal {
    mover() {
        console.log(`${this.nombre} se está moviendo`);
    }
}

let gato: Gato = new Gato("Michi");
gato.mover();



//Visibility
class Animal2 {
    public nombre: string;
    protected edad: number;
    private color: string;

    constructor(nombre: string, edad: number, color: string) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
    }
}

let animal2: Animal2 = new Animal2("Animal", 10, "Rojo");
console.log(animal2.nombre);
//console.log(animal2.edad); // Error: Property 'edad' is protected and only accessible within class 'Animal2' and its subclasses.
//console.log(animal2.color); // Error: Property 'color' is private and only accessible within class 'Animal2'.

//Getters and setters
class Animal3 {
    //getters and setters inline
    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }

    public get edad(): number {
        return this._edad;
    }
    public set edad(value: number) {
        this._edad = value;
    }

    public get color(): string {
        return this._color;
    }
    public set color(value: string) {
        this._color = value;
    }


    //getters and setters with private properties
    private _nombre: string = "";
    private _edad: number = 0;
    private _color: string = "";

    constructor(nombre: string, edad: number, color: string) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
    }    
    
}

let animal3: Animal3 = new Animal3("Animal", 10, "Rojo");
console.log(animal3.nombre);
console.log(animal3.edad);
console.log(animal3.color);

animal3.nombre = "Animal2";
animal3.edad = 20;
animal3.color = "Azul";
console.log(animal3.nombre);
console.log(animal3.edad);
console.log(animal3.color);

//Static properties
class Animal4 {
    static nombre: string = "Animal";
    static edad: number = 10;
    static color: string = "Rojo";
}  


console.log(Animal4.nombre);
console.log(Animal4.edad);
console.log(Animal4.color);

//Static methods

class Counter {
    static count: number = 0;
  
    static increment() {
      Counter.count++;
    }
  }
  
Counter.increment();
console.log(Counter.count); // Output: 1


//overloading
class Calculator {
    add(a: number, b: number): number;
    add(a: string, b: string): string;
    add(a: any, b: any): any {
        return a + b;
    }
}

let calculator: Calculator = new Calculator();

console.log(calculator.add(1, 2));
console.log(calculator.add("1", "2"));

//overloading with different parameters
class Calculator2 {
    add(a: number, b: number): number;
    add(a: number, b: number, c: number): number;
    add(a: any, b: any, c?: any): any {
        if (c) {
            return a + b + c;
        } else {
            return a + b;
        }
    }
}

let calculator2: Calculator2 = new Calculator2();
console.log(calculator2.add(1, 2));
console.log(calculator2.add(1, 2, 3));

//Generics
class Box<T> {
    private _content: T;
  
    constructor(content: T) {
      this._content = content;
    }
  
    getContent(): T {
      return this._content;
    }
  }
  
  let numberBox = new Box<number>(123);
  console.log(numberBox.getContent()); // Output: 123
  
  let stringBox = new Box<string>("Hello");
  console.log(stringBox.getContent()); // Output: Hello


  //Namespaces
  namespace Geometry {
    export interface Shape {
      area(): number;
    }
  
    export class Square implements Shape {
      sideLength: number;
  
      constructor(sideLength: number) {
        this.sideLength = sideLength;
      }
  
      area(): number {
        return this.sideLength * this.sideLength;
      }
    }
  }
  
  let square = new Geometry.Square(10);
  console.log(square.area()); 

  //another namespace
  namespace Geometry2 {
    export interface Shape {
      area(): number;
    }

    export class Square implements Shape {
      sideLength: number;

      constructor(sideLength: number) {
        this.sideLength = sideLength;
      }

      area(): number {  
        return this.sideLength * this.sideLength;
      }
    }
  }

  let square2 = new Geometry2.Square(10);
  console.log(square2.area()); 
  
//Promises

//Async/await
async function fetchData() {
    const response = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await response.json();
    return data;
}

fetchData().then(data => {
    console.log(data);
}).catch(error => {
    console.error("Error:", error);
});

//otra forma de hacer lo mismo
async function fetchData2() {
    try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts");
        const data = await response.json();
        return data;
    } catch (error) {
        console.error("Error:", error);
    }
}
    
fetchData2().then(data => {
    console.log(data);
});

//without async/await

function fetchData3() {
    fetch("https://jsonplaceholder.typicode.com/posts")
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error("Error:", error));
}

fetchData3();


//Observables rxjs
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
    
const observable = new Observable(observer => {
    observer.next('Hello');
    observer.next('World');
    observer.complete();
});

observable.subscribe(value => console.log(value));

//interval
import { interval } from 'rxjs';
import { take } from 'rxjs/operators';
    

const intervalObservable = interval(1000);
intervalObservable.pipe(take(5)).subscribe(value => console.log(value));

//timeo
import { timer } from 'rxjs';
    
const timerObservable = timer(1000);
timerObservable.pipe(take(5)).subscribe(value => console.log(value));

//merge
import { merge } from 'rxjs';
    
const mergeObservable = merge(intervalObservable, timerObservable);
mergeObservable.pipe(take(10)).subscribe(value => console.log(value));

