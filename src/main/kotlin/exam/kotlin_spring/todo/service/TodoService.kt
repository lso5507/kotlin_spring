package exam.kotlin_spring.todo.service

import exam.kotlin_spring.todo.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoService
     {
     @Autowired
     lateinit var  todoRepository: TodoRepository
    /**
     * 등록
     */
    fun post(todo:String):Unit{
        todoRepository.post(todo)
    }

    /**
     * 목록가져오기
     */
    fun getAll(): Map<Int, String> {
        return todoRepository.getAll()
    }

    /**
     * 수정
     */
    fun put(key:Int,todo:String):Unit{
        todoRepository.put(key,todo)
    }

    /**
     * 삭제
     */
    fun delete(key:Int):Unit{
        todoRepository.delete(key)
    }
}