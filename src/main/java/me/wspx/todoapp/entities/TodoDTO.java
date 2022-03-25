package me.wspx.todoapp.entities;

import lombok.Data;

@Data
public class TodoDTO {
	private String titulo;
	private String conteudo;
	private Boolean completado;
}
