package exam.kotlin_spring.todo.repository

import org.springframework.stereotype.Repository

@Repository
class TodoMemoryRepository:TodoRepository {
    val memoryMap = mutableMapOf<Int,String>();
    override fun post(todo: String) {
        val key = if (memoryMap.isEmpty()) 1 else memoryMap.keys.max() + 1
        memoryMap[key] = todo
    }

    override fun getAll(): MutableMap<Int, String> {
        return memoryMap
    }


    override fun put(key:Int,todo: String) {
        memoryMap[key]=todo
    }

    override fun delete(key: Int) {
        memoryMap.remove(key)
    }


}