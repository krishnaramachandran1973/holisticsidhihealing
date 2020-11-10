import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Customer} from "../entity/Customer.model";
import {WindowRefService} from "../services/window-ref.service";
import {ConsultationService} from "../services/consultation.service";

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit
{

  done: string;
  customer: Customer = new Customer();

  constructor(private consultService: ConsultationService, private windowRefService: WindowRefService,
              private changeDetectorRef: ChangeDetectorRef)
  {

  }

  ngOnInit(): void
  {
    this.payWithRazor();
  }

  payWithRazor()
  {
    const options: any = {
      key: this.consultService.customer.razorOrder.key,
      amount: this.consultService.customer.product.price,
      name: 'HolisticSidhiHealing',
      description: 'Healing from body illness and psychological disorders, healing for negative karmic influences',
      image: './assets/images/logo.png',
      modal: {
        escape: false
      },
      prefill: {
        name: this.consultService.customer.firstName + ' ' + this.consultService.customer.lastName,
        contact: this.consultService.customer.phone,
        email: this.consultService.customer.email
      },
      notes: {
        address: ''
      },
      theme: {
        color: '#6fbc29'
      }
    };
    options.handler = ((response) =>
    {
      this.consultService.customer.razorOrder.razorPayPaymentId = response.razorpay_payment_id;
      this.consultService.payWithRazorComplete()
        .subscribe(value =>
        {
          this.done = 'complete';
          this.customer = new Customer().deserialize(value);
          this.customer.product.price = this.customer.product.price / 100;
          this.changeDetectorRef.detectChanges();
        });
    });
    options.modal.ondismiss = (() =>
    {
      console.log("Modal dismissed");
      this.consultService.payWithRazorCancelled()
        .subscribe(value =>
        {
          this.done = 'failed';
          this.changeDetectorRef.detectChanges();
        });
    });
    const rzp = new this.windowRefService.nativeWindow.Razorpay(options);
    rzp.open();
  }

}
