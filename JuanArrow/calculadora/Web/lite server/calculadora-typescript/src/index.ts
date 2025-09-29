let numeroActual: string = "0";
let numeroPrevio: string = "";
let operador: string = "";
let ultimaOperacion: string = "";

function appendToDisplay(value: string): void {
    let actualizar = false;
    if (["%", "1/x", "x²", "²√x", "÷", "x", "-", "+"].includes(value)) {
        if (numeroActual !== "0" && numeroActual !== "") {
            if (numeroPrevio !== "" && operador !== "") {
                calcular();
            }
            numeroPrevio = numeroActual;
            operador = value;
            numeroActual = "0";
            ultimaOperacion = "";
            actualizar = true;
        }
    } else {
        if (numeroActual === "0" && value !== ".") {
            numeroActual = value;
        } else {
            numeroActual += value;
        }
        ultimaOperacion = "";
        actualizar = true;
    }
    if (actualizar) {
        actualizarParteSuperior();
    }
}

function actualizarParteSuperior(): void {
    const resultado = document.getElementById("resultado") as HTMLInputElement;
    const calculo = document.getElementById("calculo") as HTMLInputElement;
    resultado.value = numeroActual;
    if (ultimaOperacion) {
        calculo.value = ultimaOperacion;
    } else if (numeroPrevio && operador) {
        calculo.value = `${numeroPrevio} ${operador} ${numeroActual !== "0" ? numeroActual : ""}`;
    } else {
        calculo.value = "";
    }
}

function cambiarSigno(): void {
    if (numeroActual !== "0" && numeroActual !== "") {
        numeroActual = (parseFloat(numeroActual) * -1).toString();
        actualizarParteSuperior();
    }
}

function limpiarTodo(): void {
    numeroActual = "0";
    operador = "";
    numeroPrevio = "";
    ultimaOperacion = "";
    actualizarParteSuperior();
}

function borrarUltimo(): void {
    if (numeroActual.length > 1) {
        numeroActual = numeroActual.slice(0, -1);
    } else {
        numeroActual = "0";
    }
    actualizarParteSuperior();
}

function calcular(): void {
    if (numeroPrevio !== "" && numeroActual !== "0" && numeroActual !== "" && operador !== "") {
        const previo = parseFloat(numeroPrevio);
        const actual = parseFloat(numeroActual);
        let resultado: number;
        switch (operador) {
            case "%":
                resultado = previo % actual;
                break;
            case "÷":
                if (actual === 0) {
                    alert("Error en el cálculo");
                    return;
                }
                resultado = previo / actual;
                break;
            case "x":
                resultado = previo * actual;
                break;
            case "-":
                resultado = previo - actual;
                break;
            case "+":
                resultado = previo + actual;
                break;
            case "1/x":
                resultado = 1 / actual;
                break;
            case "x²":
                resultado = actual * actual;
                break;
            case "²√x":
                resultado = Math.sqrt(actual);
                break;
            default:
                return;
        }
        ultimaOperacion = `${numeroPrevio} ${operador} ${numeroActual} =`;
        numeroActual = resultado.toString();
        operador = "";
        numeroPrevio = "";
        actualizarParteSuperior();
    }
}

document.addEventListener("DOMContentLoaded", () => {
    actualizarParteSuperior();
    setUpEventListeners();
});

function setUpEventListeners(): void {
    const botones = document.querySelector(".botones");
    if (botones) {
        botones.addEventListener("click", (evento) => {
            const target = evento.target as HTMLButtonElement;
            if (target.tagName === "BUTTON") {
                const accion = target.dataset.action;
                const valor = target.dataset.value;
                if (accion === "C") {
                    limpiarTodo();
                }
                else if (accion === "⌫" || accion === "CE") {
                    borrarUltimo();
                }
                else if (accion === "calcular") {
                    calcular();
                }
                else if (accion === "cambiarSigno") {
                    cambiarSigno();
                }
                else if (valor) {
                    appendToDisplay(valor);
                }
            }
        });
    }
}