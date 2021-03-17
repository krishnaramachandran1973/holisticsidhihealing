package com.healing.entity



/*
import io.quarkus.hibernate.reactive.panache.PanacheEntity
import javax.persistence.Entity
*/

//@Entity
class RazorOrder()
{
  val key: String = "rzp_test_i7JJhn455fsryw"
  lateinit var txnId: String
  var orderId: String? = null
  var razorPayPaymentId: String? = null;

  constructor(txnId: String, orderId: String?) : this()
  {
    this.txnId = txnId
    this.orderId = orderId
  }
}
