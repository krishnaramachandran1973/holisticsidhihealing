package com.healing.entity


import io.quarkus.hibernate.reactive.panache.PanacheEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Product : PanacheEntity()
{
  lateinit var selected: String
  lateinit var type: String
  var price: Int? = null

  override fun toString(): String
  {
    return "Product(id=$id, selected='$selected', type='$type', price=$price)"
  }


}
