package exam.kotlin_spring.todo.controller

import exam.kotlin_spring.todo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class TodoController @Autowired constructor(
    val todoService:TodoService
) {
    @GetMapping("")
    fun main():MutableMap<Int,String>{
        return todoService.getAll()
    }
    @PostMapping("")
    fun post(@RequestBody todoMap:MutableMap<String,Any>){
        todoService.post(todoMap.get("todo") as String)
    }
    @PutMapping("")
    fun put(@RequestBody todoMap:MutableMap<String,Any>){
        todoService.put(todoMap.get("key")as Int,todoMap.get("todo") as String)
    }
    @DeleteMapping("")
    fun delete(@RequestBody todoMap:MutableMap<String,Any>){
        todoService.delete(todoMap.get("key") as Int)
    }
}