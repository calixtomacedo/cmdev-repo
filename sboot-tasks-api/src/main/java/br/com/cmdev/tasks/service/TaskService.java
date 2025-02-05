package br.com.cmdev.tasks.service;

import br.com.cmdev.tasks.dto.TaskRequest;
import br.com.cmdev.tasks.dto.TaskResponse;
import br.com.cmdev.tasks.dto.TaskUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    public TaskResponse create(TaskRequest request);
    public Page<TaskResponse> listAll(Pageable pageable);
    public TaskResponse findById(Long id);
    public TaskResponse update(TaskUpdateRequest request);
    public void delete(Long id);

}
