package br.com.cmdev.tasks.controller;

import br.com.cmdev.tasks.dto.TaskRequest;
import br.com.cmdev.tasks.dto.TaskResponse;
import br.com.cmdev.tasks.dto.TaskUpdateRequest;
import br.com.cmdev.tasks.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TaskRequest request, UriComponentsBuilder uriBuilder) {
        TaskResponse response = this.service.create(request);
        var uri = uriBuilder.path("/task/{id}").buildAndExpand(response.idTask()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponse>> findAll(@PageableDefault(size = 10, sort = {"name"})Pageable pageable) {
        return ResponseEntity.ok(this.service.listAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        TaskResponse taskResponse = service.findById(id);
        if(Objects.nonNull(taskResponse)) {
            return ResponseEntity.ok(taskResponse);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public  ResponseEntity update(@RequestBody TaskUpdateRequest request) {
        return ResponseEntity.ok(this.service.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
