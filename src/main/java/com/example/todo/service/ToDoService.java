package com.example.todo.service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo createToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public ToDo toggleCompleted(Long id) {
        ToDo todo = toDoRepository.findById(id).orElseThrow();
        todo.setCompleted(!todo.isCompleted());
        return toDoRepository.save(todo);
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }
}
