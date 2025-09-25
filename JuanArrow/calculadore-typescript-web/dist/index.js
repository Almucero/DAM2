"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// src/index.ts
function greet(name) {
    const greeting = `Hello, ${name}!`;
    const element = document.getElementById("greeting");
    if (element) {
        element.innerText = greeting;
    }
}
greet("World");
//# sourceMappingURL=index.js.map