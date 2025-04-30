package exam.kotlin_spring.todo.entity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "TB_TODO")
class Todo(
    content: String,
) {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    val id: Long = 0L
    @Column
    var content: String = content
    fun updateContent(content: String) {
        this.content=content
    }
}
