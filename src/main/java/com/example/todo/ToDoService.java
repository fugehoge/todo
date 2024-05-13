package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private final ToDoRepository repository;
	
	@Autowired
	public ToDoService(ToDoRepository repository) {
		this.repository = repository;
	}
	
	public Iterable<ToDo> getAllToDos(){
		return repository.findAll();
	}
	
    public ToDo saveToDo(ToDo title) {
        return repository.save(title);
    }
    
    public void displayToDos() {
    	Iterable<ToDo> todos =getAllToDos();
    	
    	for(ToDo todo:todos) {
    		System.out.println(todo.getTitle());
    	}
    }

}
