package me.wspx.todoapp.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.wspx.todoapp.entities.Todo;
import me.wspx.todoapp.entities.TodoDTO;

import me.wspx.todoapp.repositories.TodoRepository;

@RestController
@RequestMapping(path = "v1")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Value("${spring.datasource.url}")
	String db_url;
	
	@Value("${spring.datasource.username}")
	String db_user;
	
	@Value("${spring.datasource.password}")
	String db_password;
	
	@GetMapping(path = "todos", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Todo>> getTodos() {
		return ResponseEntity.ok(this.todoRepository.findAll());
	}
	
	
	@GetMapping(path = "todos/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Todo> getTodoById(@PathVariable(name = "id") UUID id) {
		
		Optional<Todo> todo = this.todoRepository.findById(id.toString());
		
		return todo.isPresent() ? 
					ResponseEntity.ok(todo.get()) 
					:
					ResponseEntity.notFound().build();
	}
	
	
	@PostMapping(path = "todos", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Todo postTodo(@RequestBody TodoDTO novoTodoDTO) {
		
		Todo novoTodo = new Todo();
		novoTodo.setTitulo(novoTodoDTO.getTitulo());
		novoTodo.setConteudo(novoTodoDTO.getConteudo());
		novoTodo.setCompletado(novoTodoDTO.getCompletado());
		novoTodo.setDataCriacao(LocalDateTime.now());
		novoTodo.setDataAtualizao(LocalDateTime.now());
	
		return this.todoRepository.save(novoTodo);
	}
	
	
	@PutMapping(path = "todos/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Todo> putTodo(@PathVariable(name = "id") UUID id, @RequestBody TodoDTO atualizadoTodo) {
		
		Optional<Todo> todoById = this.todoRepository.findById(id.toString());
		
		if (todoById.isPresent()) {
			
			Todo todo = todoById.get();
			
			todo.setTitulo(atualizadoTodo.getTitulo());
			todo.setConteudo(atualizadoTodo.getConteudo());
			todo.setCompletado(atualizadoTodo.getCompletado());
			todo.setDataAtualizao(LocalDateTime.now());
			
			return ResponseEntity
					.ok(this.todoRepository.save(todo));
		}
		
		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping(path = "todos/{id}")
	public ResponseEntity<Object> deleteTodo(@PathVariable(name = "id") UUID id) {
		this.todoRepository.deleteById(id.toString());
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	public Map<String, String> index() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Feito Por", "WSPX");
		map.put("Data:", LocalDateTime.now().toString());
		
		map.put("DATABASE_URL", this.db_url);
		map.put("DATABASE_USER", this.db_user);
		map.put("DATABASE_PASSWORD", this.db_password);
		
		return map;
	}
}
