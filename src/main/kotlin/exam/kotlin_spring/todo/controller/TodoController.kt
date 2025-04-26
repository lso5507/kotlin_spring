package exam.kotlin_spring.todo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/todo")
class TodoController {
    @GetMapping("")
    fun main():String{
        return "/todo/main"
    }
}