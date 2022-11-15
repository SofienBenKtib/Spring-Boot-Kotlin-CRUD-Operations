package com.example.sofien.Crud.controllers

import com.example.sofien.Crud.models.User
import com.example.sofien.Crud.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userRepository:UserRepository) {

    //return all the users.
    @GetMapping("/")
    fun getUsers():ResponseEntity<List<User>>{
        return ResponseEntity.ok(this.userRepository.findAll())
    }

    //return user by id
    @GetMapping("/{id}")
    fun getUser(@PathVariable id:String):ResponseEntity<User>{
        return ResponseEntity.ok(this.userRepository.findById(id).orElse(null))
    }

    //create a user
    @PostMapping("/")
    fun createUsers(@RequestBody user: User):ResponseEntity<User>{
        return ResponseEntity.ok(this.userRepository.save(user))
    }

    //update a user
    @PutMapping("/{id}")
    fun updateUsers(@PathVariable id:String,@RequestBody user:User):ResponseEntity<User>{
        var oldUser=this.userRepository.findById(id).orElse(null)
        oldUser.name=user.name
        oldUser.email=user.email
        oldUser.password=user.password
        return ResponseEntity.ok(this.userRepository.save(user))
    }

    //delete a user by id
    @DeleteMapping("/{id}")
    fun deleteUsers(@PathVariable id:String):ResponseEntity<String>{
        this.userRepository.deleteById(id)
        return ResponseEntity.ok(id)
    }
}