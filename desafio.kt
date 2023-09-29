enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val professor: String, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional> ) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado em ${nome} com sucesso.")
    }

    fun status(){
        println("Curso: ${nome}")
        println("Nivel: ${nivel}")
        for (c in conteudos){
            println("Conteudo:")
            println("   Materia: ${c.nome}")
            println("   Professor: ${c.professor}")
            println("   Duracao: ${c.duracao}h")
        }
    }
}

fun main() {
    val user1 = Usuario("Matheus", 19)
    val user2 = Usuario("Andre", 19)

    val conteudo1 = ConteudoEducacional("Kotlin Orientado a Objetos", "Professor X", 3)
    val conteudo2 = ConteudoEducacional("Introducao a Python", "Professor N", 1)

    val formacao1 = Formacao("Curso de Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1))
    val formacao2 = Formacao("Curso de Python", Nivel.BASICO, listOf(conteudo2))

    formacao1.matricular(user1)
    formacao1.status()

    println()

    formacao2.matricular(user2)
    formacao2.status()
}
