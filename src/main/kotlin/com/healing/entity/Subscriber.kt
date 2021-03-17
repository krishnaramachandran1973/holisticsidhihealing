package com.healing.entity

import java.util.*


/*
import io.quarkus.hibernate.reactive.panache.PanacheEntity
import javax.persistence.Entity
*/

//@Entity
class Subscriber()
{
  lateinit var name: String
  lateinit var email: String
  var code: String = UUID.randomUUID()
    .toString()
  var verified: Boolean = false
}
