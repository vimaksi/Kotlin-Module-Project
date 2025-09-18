class Menu(private var menuList: List<Pair<String, () -> Unit>>) {
    fun print() {
        var shouldContinue = true

        while (shouldContinue) {
            menuList.forEachIndexed { index, pair -> println("$index. ${pair.first}") }
            println("Введите номер пункта меню:")
            val userInput = readlnOrNull()
            val choice = userInput?.toIntOrNull()

            when {
                choice in menuList.indices -> {
                    menuList[choice!!].second()
                    shouldContinue = false // Выходим из цикла после выполнения
                }
                else -> println("Некорректный ввод.")
            }
        }
    }
}