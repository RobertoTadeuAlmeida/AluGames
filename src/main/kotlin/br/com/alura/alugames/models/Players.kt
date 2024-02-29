package br.com.alura.alugames.models

import kotlin.random.Random

data class Players(val name: String, val email: String ){
    var dataNascimento: String? = null
    var usuario: String? = null
    var idInterno: String? = null

    constructor(name: String, email: String, dataNascimento: String, usuario: String):
            this(name, email){
                this.dataNascimento = dataNascimento
                this.usuario = usuario
            }

    override fun toString(): String {
        return "Players(name='$name', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun creatIdInterno (){
        val number = Random.nextInt(1000)
        val tag = String.format("%04d", number)

        idInterno = "$usuario$tag"
    }

}
