package exam.kotlin_spring.todo.service

import exam.kotlin_spring.todo.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoService @Autowired constructor(
    val todoRepository: TodoRepository) {
    /**
     * 등록
     */
    fun post():Unit{

    }

    /**
     * 목록가져오기
     */
    fun getAll():Unit{}

    /**
     * 수정
     */
    fun put():Unit{}

    /**
     * 삭제
     */
    fun delete():Unit{}
}