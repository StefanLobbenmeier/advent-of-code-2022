fun <E, F> Iterable<E>.split(delimiter: E, subelementMapper: (E) -> F): List<List<F>> {
    var currentSubList = mutableListOf<F>()
    val splitList = mutableListOf<List<F>>()
    forEach {
        if (it == delimiter) {
            splitList.add(currentSubList)
            currentSubList = mutableListOf()
        } else {
            currentSubList.add(subelementMapper(it))
        }
    }
    return splitList
}