package com.healing.controller

import com.healing.entity.Subscriber
import io.quarkus.vertx.web.Body
import io.quarkus.vertx.web.Route
import io.smallrye.mutiny.Uni
import io.vertx.core.http.HttpMethod
import org.hibernate.reactive.mutiny.Mutiny.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class SubscriberController
{
  @Inject
  lateinit var sessionFactory: SessionFactory

  @Route(path = "api/subscribe", methods = [HttpMethod.POST], consumes = ["application/json"])
  fun saveSubscriber(@Body subscriber: Subscriber): Uni<Boolean>
  {
    return this.sessionFactory.withTransaction { session: Session, _: Transaction ->
      session.persist(subscriber)
    }
      .onItem()
      .transform { true }
  }
}
