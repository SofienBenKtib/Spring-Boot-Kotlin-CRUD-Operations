package com.example.sofien.Crud.models

import nonapi.io.github.classgraph.json.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User {
    @Id
    var id=""
    var name=""
    var email=""
    var password=""
}