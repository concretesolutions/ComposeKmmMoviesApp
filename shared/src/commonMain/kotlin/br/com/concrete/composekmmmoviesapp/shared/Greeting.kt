package br.com.concrete.composekmmmoviesapp.shared

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
