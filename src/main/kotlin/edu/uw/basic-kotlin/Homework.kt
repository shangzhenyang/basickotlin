package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    when (arg) {
        "Hello" -> {
            return "world"
        }
        is String -> {
            return "Say what?"
        }
        0 -> {
            return "zero"
        }
        1 -> {
            return "one"
        }
        in 2..10 -> {
            return "low number"
        }
        is Int -> {
            return "a number"
        }
    }
    return "I don't understand"
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(num1: Int, num2: Int): Int {
    return num1 - num2
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(num1: Int, num2: Int, func: (Int, Int) -> Int): Int {
    return func(num1, num2)
}

// write a class "Person" with first name, last name and age
class Person(firstName: String, lastName: String, age: Int) {
    val firstName = firstName
    val lastName = lastName
    val age = age
    val debugString: String = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(amount: Int, currency: String) {
    val amount: Int = amount
    val currency: String = currency
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Negative amount not allowed")
        }
        when (currency) {
            "USD", "EUR", "CAN", "GBP" -> {}
            else -> {
                throw IllegalArgumentException("Unsupported currency")
            }
        }
    }
    fun convert(targetCurrency: String): Money {
        var usd: Int = amount
        when (currency) {
            "GBP" -> usd = amount * 2
            "EUR" -> usd = amount / 3 * 2
            "CAN" -> usd = amount / 5 * 4
        }
        var newAmount: Int = usd
        when (targetCurrency) {
            "GBP" -> newAmount = usd / 2
            "EUR" -> newAmount = usd / 2 * 3
            "CAN" -> newAmount = usd / 4 * 5
        }
        return Money(newAmount, targetCurrency)
    }
    operator fun plus(other: Money): Money {
        val otherAmount: Int = other.convert(currency).amount
        val newAmount: Int = amount + otherAmount
        return Money(newAmount, currency)
    }
}
