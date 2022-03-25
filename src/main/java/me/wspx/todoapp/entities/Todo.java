package me.wspx.todoapp.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Todo {
	
	@Id
	@GeneratedValue(generator = "uuid4")
	@GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, unique = true, nullable = false, columnDefinition = "VARCHAR(255)")
	@Getter
	private String id;
	
	@Getter @Setter
	private String titulo;
	
	@Getter @Setter
	private String conteudo;
	
	@Getter @Setter
	private Boolean completado;
	
	@Getter @Setter
	private LocalDateTime dataCriacao;
	
	@Getter @Setter
	private LocalDateTime dataAtualizao;
}
