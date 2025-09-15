class ArchiveMenu(private val archives: MutableList<Archive>) {

    fun show() {
        var menu = mutableListOf<Pair<String, () -> Unit>>()

        menu.add("Создать архив." to {
            create()
            show()
        })

        archives.forEachIndexed { index, archive ->
            menu.add(archive.name to {
                NoteMenu(archive).show()
                show()
            })
        }

        menu.add("Выход" to {
            kotlin.system.exitProcess(0)
        })

        Menu(menu).print()
    }

    private fun create() {
        while (true) {
            println("Введите название:")
            val name: String? = readlnOrNull()
            if (!name.isNullOrBlank())  {
                archives.add(Archive(name))
                break
            }
            println("Некорректный ввод.")
        }
    }
}