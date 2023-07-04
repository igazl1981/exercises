class Matrix(matrixAsString: String) {

    private val rows: List<List<Int>> = matrixAsString.lines()
        .map { line ->
            line
                .trim()
                .split(Regex("\\s+"))
                .map { it.toInt() }
        }

    fun column(colNr: Int) = rows.map { it[colNr - 1] }

    fun row(rowNr: Int) = rows[rowNr - 1]
}
