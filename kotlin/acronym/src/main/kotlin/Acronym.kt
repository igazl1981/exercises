object Acronym {
    fun generate(text: String) : String {
        return text.split(Regex("[^a-zA-Z0-9]")).asSequence().filter { it.isNotBlank() }.map { it[0].toUpperCase() }.joinToString("")
    }
}