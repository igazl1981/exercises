val dict = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')

fun transcribeToRna(dna: String): String {

    return buildString {
        dna.forEach { append(dict[it]) }
    }

}
