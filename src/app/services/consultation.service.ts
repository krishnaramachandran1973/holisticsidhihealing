/* tslint:disable:one-line */
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Customer} from "../entity/Customer.model";

@Injectable({
  providedIn: 'root'
})
export class ConsultationService
{
  customer: Customer;

  constructor(private http: HttpClient)
  {
  }

  consult(customer: Customer)
  {
    return this.http.post('api/payment', customer)
      .pipe(map(value => this.customer = new Customer().deserialize(value)));
  }

  payWithRazorComplete()
  {
    return this.http.post('api/payment/order-complete', this.customer);
  }

  payWithRazorCancelled()
  {
    return this.http.get('api/payment/order-cancelled/' + this.customer.id);
  }
}
