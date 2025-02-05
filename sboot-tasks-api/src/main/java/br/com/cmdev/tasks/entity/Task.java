package br.com.cmdev.tasks.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "tb_tasks")
public class Task {

    @Id
    private Long idTask;
    private String name;
    private String description;
    private String status;

}
