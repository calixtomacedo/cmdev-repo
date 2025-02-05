package br.com.cmdev.tasks.dto;

public record TaskUpdateRequest(Long idTask, String name, String description, String status) {
}
