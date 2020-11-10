package com.healing.entity.blog

import io.quarkus.hibernate.reactive.panache.PanacheEntity
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToOne

@Entity
class Blog() : PanacheEntity()
{
  @OneToOne(targetEntity = BlogMeta::class, cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
  lateinit var blogMeta: BlogMeta
  lateinit var section1: String
  lateinit var section2: String
  lateinit var section3: String

  constructor(blogMeta: BlogMeta, section1: String, section2: String, section3: String) : this()
  {
    this.blogMeta = blogMeta
    this.section1 = section1
    this.section2 = section2
    this.section3 = section3
  }
}
