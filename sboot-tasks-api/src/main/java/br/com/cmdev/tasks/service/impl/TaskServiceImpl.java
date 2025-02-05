package br.com.cmdev.tasks.service.impl;

import br.com.cmdev.tasks.dto.TaskRequest;
import br.com.cmdev.tasks.dto.TaskResponse;
import br.com.cmdev.tasks.dto.TaskUpdateRequest;
import br.com.cmdev.tasks.entity.Task;
import br.com.cmdev.tasks.mapper.TaskMapper;
import br.com.cmdev.tasks.repository.TaskRepository;
import br.com.cmdev.tasks.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;
    private TaskMapper mapper;

    public TaskServiceImpl(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TaskResponse create(TaskRequest request) {
        var task = this.mapper.taskRequestToTask(request);
        var save = this.repository.save(task);
        return this.mapper.taskToTaskResponse(task);
    }

    @Override
    public Page<TaskResponse> listAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public TaskResponse findById(Long id) {
        var task = this.repository.findById(id).orElse(null);
        return this.mapper.taskToTaskResponse(task);
    }

    @Override
    public TaskResponse update(TaskUpdateRequest request) {
        Task task = this.mapper.taskUpdateRequestToTask(request);
        Task saved = this.repository.save(task);
        return this.mapper.taskToTaskResponse(saved);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
