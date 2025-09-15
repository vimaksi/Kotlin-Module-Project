class NoteMenu(private var archive: Archive) {
    fun show() {
        var menu = mutableListOf<Pair<String, () -> Unit>>()
        menu.add("Создать заметку." to {
            create()
            show()
        })

        archive.noteList.forEachIndexed { index, note ->
            menu.add(note.name to {
                NoteView(note).show()
                show()
            })
        }
        menu.add("Выход" to {} )
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