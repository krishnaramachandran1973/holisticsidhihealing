package com.healing.entity

/*import io.quarkus.hibernate.reactive.panache.PanacheEntity
import javax.persistence.**/

//@Entity
class Customer()
{
  lateinit var firstName: String
  lateinit var lastName: String
  lateinit var dob: String
  lateinit var email: String
  lateinit var subject: String
  lateinit var countryCode: String
  lateinit var phone: String

//  @OneToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER, targetEntity = Product::class)
  lateinit var product: Product
  var paymentSuccess: Boolean = false

//  @Enumerated(EnumType.STRING)
  lateinit var paymentStatus: PaymentStatus

//  @OneToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER, targetEntity = RazorOrder::class)
  lateinit var razorOrder: RazorOrder

  override fun toString(): String
  {
    return "Customer(firstName='$firstName', lastName='$lastName', dob='$dob', email='$email', subject='$subject', countryCode='$countryCode', phone='$phone', product=$product, paymentSuccess=$paymentSuccess)"
  }


}
