package exam.kotlin_spring.todo.controller

import exam.kotlin_spring.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    @ExceptionHandler(value = [Exception::class]) //예외 클래스 지정
    fun handleException(e: RuntimeException): ResponseEntity<HashMap<String, Any>> {
        //해시맵에 false와 에러메시지를 넣고 ResponseEntity객체에 담아 반환
        val result: HashMap<String, Any> = HashMap<String, Any>()
        result.put("status", false)
        result.put("message", e.message as String)
        return ResponseEntity<HashMap<String, Any>>(result, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    // 공통 데이터 추출 기능: 캐스팅 로직을 한곳에 집중
    private fun extractString(payload: Map<String, Any>, key: String): String {
        return payload[key] as? String ?: throw IllegalArgumentException("$key must be provided as a String")
    }

    private fun extractInt(payload: Map<String, Any>, key: String): Int {
        return payload[key] as? Int ?: throw IllegalArgumentException("$key must be provided as an Int")
    }
}