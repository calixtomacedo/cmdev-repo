package br.com.cmdev.tasks.dto;

public record TokenResponse(String tokenJwt, String email, String issuedAt, String expiresAt) {
}
