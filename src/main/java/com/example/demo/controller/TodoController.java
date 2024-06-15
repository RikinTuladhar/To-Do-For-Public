package com.example.demo.controller;


import com.example.demo.entity.Todo;
import com.example.demo.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class TodoController {
    @Autowired
    ToDoRepo toDoRepo;

    @GetMapping("/")
    ResponseEntity<?> getToDos(){
          List<Todo> todo = toDoRepo.findAll();
        if(todo.isEmpty()){
            HashMap<String,String> response =  new HashMap();
            response.put("Message","Not found");
            return  ResponseEntity.ok(response);
        }else {

            return ResponseEntity.ok(todo);
        }
    }

    @PostMapping("/")
    ResponseEntity<?> postToDos(@RequestBody Todo todo){
        if(todo != null){
            HashMap<String,String> response = new HashMap();
            response.put("Message","Added");
            toDoRepo.save(todo);
            return  ResponseEntity.ok(response);

        }else {
            HashMap<String,String> response = new HashMap();
            response.put("Error","Something went wrong");
            return  ResponseEntity.badRequest().body(response);
        }

    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteToDos(@PathVariable("id") int id){
        if(toDoRepo.existsById(id)){
            toDoRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> toggleToDo(
            @PathVariable("id") int id,
            @RequestBody boolean complete
    ){
        if (toDoRepo.existsById(id)){
            Todo todo = toDoRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));
            todo.setComplete(complete);
            toDoRepo.save(todo);
            return  ResponseEntity.ok(todo);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
