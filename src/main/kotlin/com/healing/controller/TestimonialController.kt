package com.healing.controller

import com.healing.entity.Audio
import com.healing.entity.blog.Blog
import io.quarkus.vertx.web.ReactiveRoutes
import io.quarkus.vertx.web.Route
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import io.vertx.core.http.HttpMethod
import org.hibernate.reactive.mutiny.Mutiny
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class TestimonialController
{
  val log: Logger = LoggerFactory.getLogger(TestimonialController::class.java)

  @Inject
  lateinit var sessionFactory: Mutiny.SessionFactory

  @Route(path = "api/audios", methods = [HttpMethod.GET], produces = ["application/json"])
  fun getAudios(): Uni<List<Audio>>
  {
    log.info("Fetching audios")
    return this.sessionFactory.withSession {
      it.createQuery<Audio>("from Audio", Audio::class.java).resultList
    }
  }
}
