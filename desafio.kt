// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

data class Usuario(val id:Int, var nome: String)

data class ConteudoEducacional(var nome: String, var duracao: Int = 60)

data class Formacao(var nome: String, var conteudos: List<ConteudoEducacional>, var niveis: Int) {

    private val inscritos = mutableListOf<Usuario>()
    
    fun mostraInscritos() = inscritos.toString()
    
   	fun procuraInscrito(usuario: Usuario): Any{
        if(usuario in inscritos){
            return usuario
        } else {
            return "Usuario não encontrado"
        }
    }
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        
        println("Usuario ${usuario.nome} adicionado com sucesso")
    }
    
    fun removerInscrito(usuario: Usuario){
        if(usuario in inscritos){
        	inscritos.remove(usuario)   
            println("Usuario ${usuario.nome} foi removido com sucesso")
        } else{
            println("Este usuario não está inscrito na formação")
        }
       
        
    }

    fun nivel():String{
        when(niveis){
            1 -> return "Basico"
            2 -> return "Intermediario"
            3 -> return "Avancado"
            else-> return "Nivel não selecionado"
        }
    }
}

fun main() {

    val ronaldo = Usuario(0, "Ronaldo")
	val jaime = Usuario(1, "jaime")
    
    val java = ConteudoEducacional("Curso Java")
    val kotlin = ConteudoEducacional("Curso Kotlin", 68)

    var listaConteudo: List<ConteudoEducacional> = listOf(java, kotlin)

    var devKotlin = Formacao("Formação Kotlin",listaConteudo, 2)
    
    devKotlin.matricular(ronaldo)
    println(devKotlin.procuraInscrito(ronaldo))
    println(devKotlin.procuraInscrito(jaime))
    devKotlin.matricular(jaime)
    
    println(devKotlin.mostraInscritos())
    
    devKotlin.removerInscrito(jaime)
    devKotlin.removerInscrito(jaime)
    
    println(devKotlin.nivel())
    
}
