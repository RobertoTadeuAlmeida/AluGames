data class Game (val title:String,
            val thumb:String){
    val descripton = ""


    override fun toString(): String {
        return "Game \n" +
                "Titulo: $title \n" +
                "Capa: $thumb \n" +
                "Descrição: $descripton \n"
    }


}