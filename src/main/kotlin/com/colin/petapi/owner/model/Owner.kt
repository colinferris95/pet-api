package com.colin.petapi.owner.model

import javax.persistence.*


@Entity
@Table(name = "owners")
class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null
}