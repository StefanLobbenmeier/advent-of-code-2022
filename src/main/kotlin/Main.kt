fun main() {
    "/inputs/01.txt".asFile { file ->
        val elves = file.readLines()
            .split("") { Food(calories = it.toInt()) }
            .map { Elf(foodItems = it) }

        val sortedElves = elves.sortedByDescending { it.totalWeight }

        println(sortedElves.first().totalWeight)
        println(sortedElves.subList(0, 3).sumOf { it.totalWeight })
    }
}

data class Food(val calories: Int)
data class Elf(val foodItems: List<Food>) {
    val totalWeight : Int by lazy { foodItems.sumOf { it.calories } }
}