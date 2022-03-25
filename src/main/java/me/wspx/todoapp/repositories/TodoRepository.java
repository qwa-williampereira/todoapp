package me.wspx.todoapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.wspx.todoapp.entities.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, String>{}
