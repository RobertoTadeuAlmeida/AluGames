package br.com.alura.alugames.models

data class Game (val title:String?,
                 val thumb:String?){
    var descripton:String? = null


    override fun toString(): String {
        return "Game \n" +
                "Titulo: $title \n" +
                "Capa: $thumb \n" +
                "Descrição: $descripton \n"
    }


}