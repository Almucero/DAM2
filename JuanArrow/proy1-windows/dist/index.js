"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// Variables
let nombre = "Juan";
const edad = 30;
var esActivo = true;
// Arrays
let numeros = [1, 2, 3];
let tupla = ["hola", 10];
// Enums
var Color;
(function (Color) {
    Color[Color["Rojo"] = 0] = "Rojo";
    Color[Color["Verde"] = 1] = "Verde";
    Color[Color["Azul"] = 2] = "Azul";
})(Color || (Color = {}));
// Matrices
let matriz = [[1, 2], [3, 4]];
// Operadores
let esMayor = 5 > 3; // true
let suma = 5 + 3; // 8
// Funciones
function saludar(nombre) {
    return `Hola, ${nombre}`;
}
saludar("Juan");
let randomValue = 10;
randomValue = "A string";
randomValue = true;
let uncertainValue = 10;
if (typeof uncertainValue === "string") {
    let stringValue = uncertainValue; // Seguro porque hemos verificado el tipo
}
function logMessage(message) {
    console.log(message);
}
logMessage("Hola");
function error(message) {
    throw new Error(message);
}
try {
    error("Error");
}
catch (error) {
    console.log(error);
}
// Desestructuración de tuplas
let person = ["Juan", 25];
let [name, age] = person;
console.log(name);
console.log(age);
// Desestructuración de objetos
let person2 = { name: "Juan", age: 25 };
console.log(person2);
// Enums
(function (Color) {
    Color[Color["Red"] = 1] = "Red";
    Color[Color["Green"] = 2] = "Green";
    Color[Color["Blue"] = 3] = "Blue";
})(Color || (Color = {}));
let color = Color.Green;
console.log(color);
let employee = { name: "Bob", age: 30 };
console.log(employee);
let value = "Hello";
value = 123;
let a = { a: 1 };
let b = { b: 2 };
let c = { a: 1, b: 2 };
let d = { a: 1 };
let e = { b: 2 };
console.log(c);
console.log(d);
console.log(e);
let age2 = 17;
//Conditional statements
if (age2 >= 18) {
    console.log("You are an adult.");
}
else {
    console.log("You are not an adult.");
}
let score = 85;
//Conditional statements with else if
if (score >= 90) {
    console.log("Grade: A");
}
else if (score >= 80) {
    console.log("Grade: B");
}
else if (score >= 70) {
    console.log("Grade: C");
}
else {
    console.log("Grade: F");
}
//switch statement
let fruit = "apple";
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
let count = 0;
while (count < 5) {
    console.log(`Count: ${count}`);
    count++;
}
//do while loop
let count2 = 0;
do {
    console.log(`Count: ${count2}`);
    count2++;
} while (count2 < 5);
//for of loop
let fruits = ["apple", "banana", "cherry"];
for (let fruit of fruits) {
    console.log(`Fruit: ${fruit}`);
}
//for in loop
let person3 = { name: "Juan", age: 25 };
for (let key in person3) {
    console.log(`${key}: ${person3[key]}`);
}
function riskyOperation() {
    // Simulate an error
    throw new Error("Something went wrong!");
}
//try catch finally
try {
    let result = riskyOperation();
    console.log(result);
}
catch (error) {
    console.error("An error occurred:", error);
}
finally {
    console.log("This will always execute.");
}
// Clases
class Persona {
    nombre;
    edad;
    constructor(nombre, edad) {
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
let persona2 = new Persona("Antonio", 30);
persona2.saludar();
let persona3 = new Persona("Ana", 30);
persona3.saludar();
// Herencia
class Empleado extends Persona {
    salario;
    constructor(nombre, edad, salario) {
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
let empleado2 = new Empleado("Antonio", 30, 1000);
empleado2.mostrarSalario();
// Implementación de interfaces
class Perro {
    nombre;
    constructor(nombre) {
        this.nombre = nombre;
    }
    mover() {
        console.log(`${this.nombre} se está moviendo`);
    }
}
let perro = new Perro("Firulais");
perro.mover();
//Polymorphism
class Animal {
    nombre;
    constructor(nombre) {
        this.nombre = nombre;
    }
}
class Gato extends Animal {
    mover() {
        console.log(`${this.nombre} se está moviendo`);
    }
}
let gato = new Gato("Michi");
gato.mover();
//Visibility
class Animal2 {
    nombre;
    edad;
    color;
    constructor(nombre, edad, color) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
    }
}
let animal2 = new Animal2("Animal", 10, "Rojo");
console.log(animal2.nombre);
//console.log(animal2.edad); // Error: Property 'edad' is protected and only accessible within class 'Animal2' and its subclasses.
//console.log(animal2.color); // Error: Property 'color' is private and only accessible within class 'Animal2'.
//Getters and setters
class Animal3 {
    //getters and setters inline
    get nombre() {
        return this._nombre;
    }
    set nombre(value) {
        this._nombre = value;
    }
    get edad() {
        return this._edad;
    }
    set edad(value) {
        this._edad = value;
    }
    get color() {
        return this._color;
    }
    set color(value) {
        this._color = value;
    }
    //getters and setters with private properties
    _nombre = "";
    _edad = 0;
    _color = "";
    constructor(nombre, edad, color) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
    }
}
let animal3 = new Animal3("Animal", 10, "Rojo");
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
    static nombre = "Animal";
    static edad = 10;
    static color = "Rojo";
}
console.log(Animal4.nombre);
console.log(Animal4.edad);
console.log(Animal4.color);
//Static methods
class Counter {
    static count = 0;
    static increment() {
        Counter.count++;
    }
}
Counter.increment();
console.log(Counter.count); // Output: 1
//overloading
class Calculator {
    add(a, b) {
        return a + b;
    }
}
let calculator = new Calculator();
console.log(calculator.add(1, 2));
console.log(calculator.add("1", "2"));
//overloading with different parameters
class Calculator2 {
    add(a, b, c) {
        if (c) {
            return a + b + c;
        }
        else {
            return a + b;
        }
    }
}
let calculator2 = new Calculator2();
console.log(calculator2.add(1, 2));
console.log(calculator2.add(1, 2, 3));
//Generics
class Box {
    _content;
    constructor(content) {
        this._content = content;
    }
    getContent() {
        return this._content;
    }
}
let numberBox = new Box(123);
console.log(numberBox.getContent()); // Output: 123
let stringBox = new Box("Hello");
console.log(stringBox.getContent()); // Output: Hello
//Namespaces
var Geometry;
(function (Geometry) {
    class Square {
        sideLength;
        constructor(sideLength) {
            this.sideLength = sideLength;
        }
        area() {
            return this.sideLength * this.sideLength;
        }
    }
    Geometry.Square = Square;
})(Geometry || (Geometry = {}));
let square = new Geometry.Square(10);
console.log(square.area());
//another namespace
var Geometry2;
(function (Geometry2) {
    class Square {
        sideLength;
        constructor(sideLength) {
            this.sideLength = sideLength;
        }
        area() {
            return this.sideLength * this.sideLength;
        }
    }
    Geometry2.Square = Square;
})(Geometry2 || (Geometry2 = {}));
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
    }
    catch (error) {
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
const rxjs_1 = require("rxjs");
const observable = new rxjs_1.Observable(observer => {
    observer.next('Hello');
    observer.next('World');
    observer.complete();
});
observable.subscribe(value => console.log(value));
//interval
const rxjs_2 = require("rxjs");
const operators_1 = require("rxjs/operators");
const intervalObservable = (0, rxjs_2.interval)(1000);
intervalObservable.pipe((0, operators_1.take)(5)).subscribe(value => console.log(value));
//timeo
const rxjs_3 = require("rxjs");
const timerObservable = (0, rxjs_3.timer)(1000);
timerObservable.pipe((0, operators_1.take)(5)).subscribe(value => console.log(value));
//merge
const rxjs_4 = require("rxjs");
const mergeObservable = (0, rxjs_4.merge)(intervalObservable, timerObservable);
mergeObservable.pipe((0, operators_1.take)(10)).subscribe(value => console.log(value));
//# sourceMappingURL=index.js.map