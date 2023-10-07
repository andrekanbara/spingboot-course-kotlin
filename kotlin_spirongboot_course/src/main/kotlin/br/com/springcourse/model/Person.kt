package br.com.springcourse.model

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,
    @Column(name = "name", nullable = false)
    var name : String = "",
    @Column(name = "last_name", nullable = false)
    var lastName: String = "",
    @Column(name = "adress", nullable = false)
    var adress : String = ""
)
