package com.example.sofien.Crud.repositories

import com.example.sofien.Crud.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User,String> {
}