package exam.kotlin_spring.todo.repository

import org.springframework.stereotype.Repository

class TodoMemoryRepository : TodoRepository {

    companion object {
        private const val DEFAULT_TODO_ID = 1
    }

    private val todoStorage: MutableMap<Int, String> by lazy { mutableMapOf<Int, String>() }

    override fun post(todo: String) {
        val id = generateNextId()
        todoStorage[id] = todo
    }

    override fun getAll(): MutableMap<Int, String> {
        return todoStorage // Immutable Map으로 변환하여 반환
    }

    override fun put(id: Int, todo: String) {
        todoStorage[id] = todo
    }

    override fun delete(id: Int) {
        todoStorage.remove(id)
    }

    // ID 생성 로직을 별도 함수로 추출
    private fun generateNextId(): Int {
        return if (todoStorage.isEmpty()) DEFAULT_TODO_ID else todoStorage.keys.max() + 1
    }
}