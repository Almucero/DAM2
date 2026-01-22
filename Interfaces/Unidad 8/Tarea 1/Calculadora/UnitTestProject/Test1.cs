using Microsoft.VisualStudio.TestTools.UnitTesting;
using Calculadora;

namespace UnitTestProyect_AJM
{
    [TestClass]
    public class UnitTest_AJM
    {
        [TestMethod]
        public void TestSumaCorrecto()
        {
            // Arrange
            int a = 2;
            int b = 5;
            int esperado = 7;
            // Act
            int resultado = CalculadoraEjemplo.Suma(a, b);
            // Assert
            Assert.AreEqual(esperado, resultado);
        }
        [TestMethod]
        public void TestSumaIncorrecto()
        {
            // Arrange
            int a = 2;
            int b = 5;
            int esperado = 9;
            // Act
            int resultado = CalculadoraEjemplo.Suma(a, b);
            // Assert
            Assert.AreEqual(esperado, resultado);
        }
        [TestMethod]
        public void TestRestaCorrecto()
        {
            int resultado = CalculadoraEjemplo.Resta(10, 5);
            Assert.AreEqual(5, resultado);
        }
        [TestMethod]
        public void TestRestaIncorrecto()
        {
            int resultado = CalculadoraEjemplo.Resta(10, 5);
            Assert.AreEqual(0, resultado);
        }
        [TestMethod]
        public void TestMultiplicacionCorrecto()
        {
            int resultado = CalculadoraEjemplo.Multiplicacion(3, 3);
            Assert.AreEqual(9, resultado);
        }
        [TestMethod]
        public void TestMultiplicacionIncorrecto()
        {
            int resultado = CalculadoraEjemplo.Multiplicacion(3, 3);
            Assert.AreEqual(100, resultado);
        }
        [TestMethod]
        public void TestDivisionCorrecto()
        {
            double resultado = CalculadoraEjemplo.Division(10, 2);
            Assert.AreEqual(5, resultado);
        }
        [TestMethod]
        public void TestDivisionIncorrecto()
        {
            double resultado = CalculadoraEjemplo.Division(10, 2);
            Assert.AreEqual(1, resultado);
        }
    }
}