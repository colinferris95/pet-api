package com.colin.petapi.pet.model

import javax.persistence.*

@Entity
@Table(name = "pets")

class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false)
    var description: String? = null

}