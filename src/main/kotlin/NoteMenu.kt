class NoteMenu(private var archive: Archive) {
    fun show() {
        val menu = buildList<Pair<String, () -> Unit>>() {
            add("Создать заметку." to {
                create()
                show()
            })

            archive.noteList.forEachIndexed { index, note ->
                add(note.name to {
                    NoteView(note).show()
                    show()
                })
            }
            add("Выход" to {})
        }
        Menu(menu).print()
    }

    fun create(){
        var name = ""
        var text = ""
        while (true) {
            println("Введите название:")
            name = readln().trim()
            if (name.isNotEmpty()) {
                break
            }
            println("Некорректный ввод.")
        }

        while (true) {
            println("Введите текст:")
            text = readln().trim()
            if (text.isNotEmpty()) {
                archive.noteList.add(Note(name, text))
                break
            }
            println("Некорректный ввод.")
        }
    }
}