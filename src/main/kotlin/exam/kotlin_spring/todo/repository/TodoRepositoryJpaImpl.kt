package exam.kotlin_spring.todo.repository

import exam.kotlin_spring.todo.entity.Todo
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository


@Repository
@Transactional
class TodoRepositoryJpaImpl(

) : TodoRepository {

    @PersistenceContext
    private lateinit var entityManager: EntityManager // EntityManager 주입

    override fun post(todo: String) {
        val newTodo = Todo(content = todo) // 새로운 Todo 객체 생성
        entityManager.persist(newTodo) // EntityManager를 통해 엔티티 저장
    }

    override fun getAll(): Map<Int, String> {
        // JPQL을 이용해 모든 Todo 엔티티를 조회
        val todos = entityManager.createQuery("SELECT t FROM Todo t", Todo::class.java)
            .resultList

        // id와 content를 Map으로 변환
        return todos.associate { it.id.toInt() to it.content }
    }

    override fun put(key: Int, todo: String) {
        val id = key.toLong()

        // 엔티티 조회
        val existingTodo = entityManager.find(Todo::class.java, id)
            ?: throw IllegalArgumentException("Todo with id $id not found.")

        // 내용 업데이트
        existingTodo.updateContent(todo)
        entityManager.merge(existingTodo) // merge를 통해 변경사항 반영
    }

    override fun delete(key: Int) {
        val id = key.toLong()

        // 엔티티 조회 후 삭제
        val existingTodo = entityManager.find(Todo::class.java, id)
            ?: throw IllegalArgumentException("Todo with id $id not found.")

        entityManager.remove(existingTodo) // 엔티티 삭제
    }

}