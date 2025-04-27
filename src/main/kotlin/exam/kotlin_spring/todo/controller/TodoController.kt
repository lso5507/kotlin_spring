package exam.kotlin_spring.todo.controller

import exam.kotlin_spring.todo.service.TodoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(
    private val todoService: TodoService
) {
    @GetMapping("")
    fun main(): Map<Int, String> {
        return todoService.getAll()
    }

    @PostMapping("")
    fun post(@RequestBody payload: Map<String, Any>) {
        val todo = extractString(payload, "todo")
        todoService.post(todo)
    }

    @PutMapping("")
    fun put(@RequestBody payload: Map<String, Any>) {
        val key = extractInt(payload, "key")
        val todo = extractString(payload, "todo")
        todoService.put(key, todo)
    }

    @DeleteMapping("")
    fun delete(@RequestBody payload: Map<String, Any>) {
        val key = extractInt(payload, "key")
        todoService.delete(key)
    }

    // 공통 데이터 추출 기능: 캐스팅 로직을 한곳에 집중
    private fun extractString(payload: Map<String, Any>, key: String): String {
        return payload[key] as? String ?: throw IllegalArgumentException("$key must be provided as a String")
    }

    private fun extractInt(payload: Map<String, Any>, key: String): Int {
        return payload[key] as? Int ?: throw IllegalArgumentException("$key must be provided as an Int")
    }
}