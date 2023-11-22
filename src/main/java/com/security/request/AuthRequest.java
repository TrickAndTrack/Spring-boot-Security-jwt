package com.security.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	@NotBlank
  	private String username;

	@NotBlank
	private String password;



}
