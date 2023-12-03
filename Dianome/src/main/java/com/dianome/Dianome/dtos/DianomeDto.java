package com.dianome.Dianome.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DianomeDto( @NotBlank String cpf,
		@NotBlank String nome,
		@NotNull Integer pacotes ) {
	
}