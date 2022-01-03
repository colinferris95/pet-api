package com.colin.petapi.ownersToPets.model

import javax.persistence.*

@Entity
@Table(name = "owners_pets")
class OwnersToPets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "owners_id")
    var ownersId: Long? = null

    @Column(name = "pets_id")
    var petsId: Long? = null
}