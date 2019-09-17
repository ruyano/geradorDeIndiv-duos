class Individuo(
    val tempoDeTrabalho: Double,
    val quantidadeDeProjetos: Double,
    val quantidadeDeCursos: Double,
    val quantidadeDeCertificados: Double,
    val senioridade: String
) {
    override fun toString(): String {
        return "$tempoDeTrabalho,$quantidadeDeProjetos,$quantidadeDeCursos,$quantidadeDeCertificados,$senioridade"
    }
}