package exam.kotlin_spring.todo.repository

interface TodoRepository {
    fun post(todo:String):Unit
    fun getAll():MutableMap<Int,String>
    fun put(key:Int,todo:String):Unit
    fun delete(key:Int):Unit 
}