class NoteView(private val note : Note){
    fun show(){
        println("${note.name}\n${note.text}")
    }
}