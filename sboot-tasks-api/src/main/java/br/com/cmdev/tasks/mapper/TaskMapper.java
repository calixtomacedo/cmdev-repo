package br.com.cmdev.tasks.mapper;

import br.com.cmdev.tasks.dto.TaskRequest;
import br.com.cmdev.tasks.dto.TaskResponse;
import br.com.cmdev.tasks.dto.TaskUpdateRequest;
import br.com.cmdev.tasks.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TaskMapper {

    @Mapping(target = "idTask", ignore = true)
    Task taskRequestToTask(TaskRequest request);

    //Page<TaskResponse> tasksToPageTaskRespose(Page<Task> tasks);

    TaskResponse taskToTaskResponse(Task task);

    Task taskUpdateRequestToTask(TaskUpdateRequest request);
}
