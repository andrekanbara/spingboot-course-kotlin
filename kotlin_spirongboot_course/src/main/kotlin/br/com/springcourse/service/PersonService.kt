package br.com.springcourse.service

import br.com.springcourse.exceptions.ResourceNotFoundException
import br.com.springcourse.model.Person
import br.com.springcourse.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    private val counter : AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    @Autowired
    private lateinit var repository : PersonRepository


    fun findByID(id : Long): Person{
        logger.info("finding one person")

        return repository.findById(id)
                .orElseThrow({ResourceNotFoundException("no records found for this ID")})
    }

    fun findAll(): List<Person>{
        logger.info("finding all")

        return repository.findAll();
    }

    fun create(person: Person) : Person{

        return repository.save(person);
    }

    fun update(person :Person) : Person{

        val entity = repository.findById(person.id)
                .orElseThrow({ResourceNotFoundException("no records found for this ID")})

        entity.name = person.name
        entity.lastName = person.lastName
        entity.adress = person.adress
        return repository.save(entity)
    }

    fun delete(id : Long){
        val person = repository.findById(id)
                .orElseThrow({ResourceNotFoundException("no records found for this ID")})
        return repository.delete(person)
    }



}