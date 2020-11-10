package com.healing.controller

import com.healing.entity.blog.Blog
import io.quarkus.vertx.web.Route
import io.smallrye.mutiny.Uni
import org.hibernate.reactive.mutiny.Mutiny
import org.hibernate.reactive.mutiny.Mutiny.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class BlogController
{
  @Inject
  lateinit var sessionFactory: SessionFactory

  @Route(path = "api/blogs", produces = ["application/json"])
  fun allblogs(): Uni<List<Blog>>
  {
    return this.sessionFactory.withSession {
      it.createQuery<Blog>("from Blog", Blog::class.java).resultList
    }
  }
}
