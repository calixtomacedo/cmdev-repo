package br.com.cmdev.user.exception;

import org.springframework.http.HttpStatus;

public record MessageErroResponse(HttpStatus status, String exception, String message, String cause) {
}
