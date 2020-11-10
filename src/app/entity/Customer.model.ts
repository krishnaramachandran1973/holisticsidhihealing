/* tslint:disable:one-line */
import {RazorOrder} from './RazorOrder.model';
import {Deserializable} from "./common/Deserializable.model";
import {Product} from "./Product.model";


export class Customer implements Deserializable
{
  id: string;
  firstName: string;
  lastName: string;
  dob: string;
  email: string;
  subject: string;
  countryCode: string;
  phone: string;
  product: Product;
  razorOrder: RazorOrder;

  deserialize(input: any): this
  {
    Object.assign(this, input);
    this.razorOrder = new RazorOrder().deserialize(input.razorOrder);
    return this;
  }
}
