package br.com.springcourse.controllers

import br.com.springcourse.model.Person
import br.com.springcourse.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service : PersonService

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findPersonById(@PathVariable(value = "id") id : Long): Person{
        return service.findByID(id);
    }

    @RequestMapping( method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person>{
        return service.findAll();
    }

    @RequestMapping(method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createPerson(@RequestBody person: Person) :Person{
        return service.create(person)
    }

    @RequestMapping(method = [RequestMethod.PUT],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updatePerson(@RequestBody person: Person) :Person{
        return service.update(person)
    }

    @RequestMapping(value = ["/{id}"] , method = [RequestMethod.DELETE],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deletePerson(@PathVariable(value = "id") id: Long){
        service.delete(id)
    }
}