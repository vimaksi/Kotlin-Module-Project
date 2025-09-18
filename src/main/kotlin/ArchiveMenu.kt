class ArchiveMenu(private val archives: MutableList<Archive>) {

    fun show() {
        val menu = buildList<Pair<String, () -> Unit>>() {

            add("Создать архив." to {
                create()
                show()
            })

            archives.forEachIndexed { index, archive ->
                add(archive.name to {
                    NoteMenu(archive).show()
                    show()
                })
            }

            add("Выход" to {
            })
        }
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