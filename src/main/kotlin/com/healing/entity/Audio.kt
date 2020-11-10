package com.healing.entity

import io.quarkus.hibernate.reactive.panache.PanacheEntity
import javax.persistence.Entity

@Entity
class Audio(): PanacheEntity()
{
  lateinit var name: String

  constructor(name: String): this()
  {
    this.name = name;
  }
}
