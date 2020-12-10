package com.healing

import com.healing.data.BlogData
import com.healing.entity.Audio
import io.quarkus.runtime.ShutdownEvent
import io.quarkus.runtime.StartupEvent
import org.hibernate.reactive.mutiny.Mutiny
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.inject.Inject


@ApplicationScoped
class AppLifeCycleBean
{
  val log = LoggerFactory.getLogger(AppLifeCycleBean::class.java)

  @Inject
  lateinit var sessionFactory: Mutiny.SessionFactory

  fun onStart(@Observes startupEvent: StartupEvent)
  {
    this.sessionFactory.withTransaction { session: Mutiny.Session, _: Mutiny.Transaction ->
      session.persistAll(/*Audio("audio-1.mp3"),
        Audio("audio-2.mp3"),
        Audio("audio-3.mp3"),
        Audio("audio-4.mp3"),*/
        BlogData.blog1(),
        BlogData.blog2(),
        BlogData.blog3(),
        BlogData.blog4())
    }
      .await()
      .indefinitely()
  }

  fun onStop(@Observes shutdownEvent: ShutdownEvent)
  {
    this.sessionFactory.withTransaction { session: Mutiny.Session, _: Mutiny.Transaction ->
      session.removeAll(Audio::class.java)
    }
      .await()
      .indefinitely()
  }

}
