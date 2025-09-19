package model

open class Vehicle(val plate: String)

class Car(plate: String): Vehicle(plate)

class Bike(plate: String): Vehicle(plate)

class Van(plate: String): Vehicle(plate)