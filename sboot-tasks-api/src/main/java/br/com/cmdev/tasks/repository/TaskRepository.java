package br.com.cmdev.tasks.repository;

import br.com.cmdev.tasks.dto.TaskResponse;
import br.com.cmdev.tasks.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ListCrudRepository<Task, Long> {
    Page<TaskResponse> findAll(Pageable pageable);
}
