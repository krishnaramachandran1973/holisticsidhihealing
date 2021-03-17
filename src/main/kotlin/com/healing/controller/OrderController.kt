package com.healing.controller

//import org.hibernate.reactive.mutiny.Mutiny.*
import com.healing.entity.Customer
import com.razorpay.RazorpayClient
import io.quarkus.mailer.MailTemplate
import io.quarkus.vertx.web.Body
import io.quarkus.vertx.web.Route
import io.smallrye.mutiny.Uni
import io.vertx.core.http.HttpMethod
import io.vertx.reactivex.ext.web.RoutingContext
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

/*import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root*/


@ApplicationScoped
class OrderController
{
  val log: Logger = LoggerFactory.getLogger(OrderController::class.java)

  @ConfigProperty(name = "apiKey")
  lateinit var apiKey: String

  @ConfigProperty(name = "secretKey")
  lateinit var secretKey: String

  /*@Inject
  lateinit var sessionFactory: SessionFactory*/

  @Inject
  lateinit var order: MailTemplate


  @Route(path = "api/payment", consumes = ["application/json"], methods = [HttpMethod.POST])
  fun order(@Body customer: Customer): Uni<Customer>
  {
    log.info("Order received from {}", customer)
    // Creating the RazorPay client
    val razorpayClient = RazorpayClient(apiKey, secretKey)
    customer.product.price = customer.product.price?.times(100)
    // Creating the options for the RazorPay client to send the request
    val options = JSONObject()
    options.put("amount", customer.product.price)
    options.put("currency", "INR")
    val txnId = "txn_" + Random().nextInt(1000000)
    options.put("receipt", txnId)

    /*return Uni.createFrom()
      .completionStage { CompletableFuture.supplyAsync { razorpayClient.Orders.create(options) } }
      .onItem()
      .transform { order: Order ->
        val razorOrder = RazorOrder(txnId, order.get("id"))
        customer.paymentStatus = PaymentStatus.INITIATED
        customer.razorOrder = razorOrder
        this.save(customer)
      }
      .flatMap { findCustomerByTxnId(txnId) }
*/
    return Uni.createFrom()
      .item(Customer())
  }

  @Route(path = "api/payment/order-complete", methods = [HttpMethod.POST], consumes = ["application/json"])
  fun orderComplete(@Body customer: Customer): Uni<Customer>
  {
    log.info("Completing Order for {}", customer)
    return Uni.createFrom()
      .item(Customer())
    /*return this.sessionFactory.withTransaction { session: Session, _: Transaction ->
      session.find(Customer::class.java, customer.id)
        .onItem()
        .transform { persistedCustomer: Customer ->
          persistedCustomer.razorOrder.razorPayPaymentId = customer.razorOrder.razorPayPaymentId
          persistedCustomer.paymentSuccess = true
          persistedCustomer.paymentStatus = PaymentStatus.COMPLETE
          session.flush()
          persistedCustomer
        }
        .chain { t: Customer ->
          CompletableFuture.supplyAsync {
            this.order.to(t.email)
              .subject("Order Confirmation: HolisticSidhiHealing.com")
              .data("title", "Order Confirmation")
              .data("header", "Order Confirmation")
              .data("domain", "HolisticSidhiHealing.com")
              .data("name", t.firstName + " " + t.lastName)
              .data("order-summary", "Your order is successfully completed. Details are mentioned as follows.")
              .data("selected-consultant", "Consultancy: " + t.product.selected)
              .data("selected-type", "Type: " + t.product.type)
              .data("price", "Price paid: Rs " + t.product.price?.div(100))
              .data("transaction-id", "Transaction Id: " + t.razorOrder.txnId)
              .data("razor-id", "RazorPay Id: " + t.razorOrder.razorPayPaymentId)
              .data("description", "The session will initiate on-time based on our mutually decided platform and time.")
              .send()
              .thenAccept { log.info("Order confirmation send to {}", t.firstName) }
          }
          Uni.createFrom()
            .item(t)
        }*/
  }



@Route(path = "api/payment/order-cancelled/:id", methods = [HttpMethod.GET])
fun orderCancelled(routingContext: RoutingContext): Uni<Boolean>
{
  val id = routingContext.request()
    .getParam("id")
    .toLong()
  //log.info("Order cancelled for Customer {}", id)
  return Uni.createFrom()
    .item(true)

  /*return this.sessionFactory.withTransaction { session: Session, _: Transaction ->
    session.find(Customer::class.java, id)
      .onItem()
      .call { customer: Customer ->
        customer.paymentStatus = PaymentStatus.FAILED
        session.flush()
      }
  }
    .map { true }*/
}

private fun findCustomerByTxnId(txnId: String): Uni<Customer>
{
  return Uni.createFrom()
    .item(Customer())
  /*val criteriaBuilder = sessionFactory.criteriaBuilder
  val criteriaQueryCustomer: CriteriaQuery<Customer> = criteriaBuilder.createQuery(Customer::class.java)
  val rootCustomer: Root<Customer> = criteriaQueryCustomer.from(Customer::class.java)

  criteriaQueryCustomer.select(rootCustomer)
    .where(criteriaBuilder.equal(rootCustomer.get<RazorOrder>("razorOrder")
      .get<String>("txnId"), txnId))


  return this.sessionFactory.withSession { session: Session ->
    session.createQuery(criteriaQueryCustomer).singleResult
  }*/
}

private fun save(customer: Customer)
{

  /*return this.sessionFactory.withTransaction { session: Session, _: Transaction ->
    session.persist(customer)
  }
    .await()
    .indefinitely()*/
}

}
