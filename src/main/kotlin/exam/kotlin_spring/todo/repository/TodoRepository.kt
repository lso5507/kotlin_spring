package exam.kotlin_spring.todo.repository

interface TodoRepository {
    fun post():Unit
    fun getAll():Unit
    fun put():Unit
    fun delete():Unit
}