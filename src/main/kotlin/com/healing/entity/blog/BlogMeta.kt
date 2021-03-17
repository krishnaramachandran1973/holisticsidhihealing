package com.healing.entity.blog

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
//import io.quarkus.hibernate.reactive.panache.PanacheEntity
import java.time.LocalDate
//import javax.persistence.Entity

//@Entity
class BlogMeta()
{
  lateinit var title: String
  @JsonSerialize(using = LocalDateSerializer::class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  lateinit var date: LocalDate

  constructor(title: String, date: LocalDate) : this()
  {
    this.title = title
    this.date = date
  }
}
