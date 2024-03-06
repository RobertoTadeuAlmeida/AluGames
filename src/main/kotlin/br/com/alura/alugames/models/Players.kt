package br.com.alura.alugames.models

import kotlin.random.Random

data class Players(val name: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                creatIdInterno()
            }
        }

    var idInterno: String? = null
        private set

    constructor(name: String, email: String, dataNascimento: String, usuario: String) :
            this(name, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        creatIdInterno()
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Players(name='$name', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun creatIdInterno() {
        val number = Random.nextInt(1000)
        val tag = String.format("%04d", number)

        idInterno = "$usuario$tag"
    }

    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }

    }

}
