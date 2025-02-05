package br.com.cmdev.tasks.dto;

public record TaskResponse(Long idTask, String name, String description, String status) {
}
