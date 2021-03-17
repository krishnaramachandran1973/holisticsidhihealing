package com.healing.entity.blog

/*import io.quarkus.hibernate.reactive.panache.PanacheEntity
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToOne*/

//@Entity
class Blog()
{
  //  @OneToOne(targetEntity = BlogMeta::class, cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
  var id: Int = 0
  lateinit var blogMeta: BlogMeta
  lateinit var section1: String
  lateinit var section2: String
  lateinit var section3: String

  constructor(id: Int, blogMeta: BlogMeta, section1: String, section2: String, section3: String) : this()
  {
    this.id = id
    this.blogMeta = blogMeta
    this.section1 = section1
    this.section2 = section2
    this.section3 = section3
  }
}
