import java.math.RoundingMode
import kotlin.random.Random

fun main() {
//    geradorSequencial(30)
    geradorGeral(100)
}

fun geradorGeral(qtd: Int) {
    for (i in 0 .. qtd) {
        val tempoDeTrabalho = Random.nextDouble(0.0, 10.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeProjetos = Random.nextDouble(0.0, 20.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCursos = Random.nextDouble(0.0, 10.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCertificados = Random.nextDouble(0.0, 10.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val senioridade= getSenioridade(tempoDeTrabalho, quantidadeDeProjetos, quantidadeDeCursos, quantidadeDeCertificados)
        println("$tempoDeTrabalho,$quantidadeDeProjetos,$quantidadeDeCursos,$quantidadeDeCertificados,$senioridade")
    }
}

fun geradorSequencial(qtd: Int) {

    val array = arrayListOf<Individuo>()

    // Senior
    for (i in 0 .. qtd/3) {
        val tempoDeTrabalho = Random.nextDouble(4.0,10.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeProjetos = Random.nextDouble(10.0,20.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCursos = Random.nextDouble(5.0,10.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCertificados = Random.nextDouble(5.0,10.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val senioridade= getSenioridade(tempoDeTrabalho, quantidadeDeProjetos, quantidadeDeCursos, quantidadeDeCertificados)
        array.add(Individuo(tempoDeTrabalho, quantidadeDeProjetos, quantidadeDeCursos, quantidadeDeCertificados, senioridade))
    }

    // pleno
    for (i in 0 .. qtd/3) {
        // Senior
        val tempoDeTrabalho = Random.nextDouble(2.0,3.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeProjetos = Random.nextDouble(6.0,9.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCursos = Random.nextDouble(3.0,4.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCertificados = Random.nextDouble(3.0,4.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val senioridade = getSenioridade(tempoDeTrabalho, quantidadeDeProjetos, quantidadeDeCursos, quantidadeDeCertificados)
        array.add(Individuo(tempoDeTrabalho, quantidadeDeProjetos, quantidadeDeCursos, quantidadeDeCertificados, senioridade))
    }

    // junior
    for (i in 0 .. qtd/3) {
        // Senior
        val tempoDeTrabalho = Random.nextDouble(0.0,1.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeProjetos = Random.nextDouble(0.0,5.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCursos = Random.nextDouble(0.0,2.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val quantidadeDeCertificados = Random.nextDouble(0.0,2.0).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        val senioridade = getSenioridade(tempoDeTrabalho, quantidadeDeProjetos, quantidadeDeCursos, quantidadeDeCertificados)
        array.add(Individuo(tempoDeTrabalho, quantidadeDeProjetos, quantidadeDeCursos, quantidadeDeCertificados, senioridade))
    }

    array.shuffle()

    for (i in array) {
        print("\n$i")
    }

}

private fun getSenioridade(
    tempoDeTrabalho: Double,
    quantidadeDeProjetos: Double,
    quantidadeDeCursos: Double,
    quantidadeDeCertificados: Double
): String {
    return if (tempoDeTrabalho >= 4 && quantidadeDeProjetos >= 10 && quantidadeDeCursos >= 5 && quantidadeDeCertificados >= 5) {
        "Senior"
    } else if (tempoDeTrabalho in 2.0..3.0 &&
        quantidadeDeProjetos in 6.0..9.0 &&
        quantidadeDeCursos in 3.0..4.0 &&
        quantidadeDeCertificados in 3.0..4.0
    ) {
        "Pleno"
    } else {
        "Junior"
    }
}