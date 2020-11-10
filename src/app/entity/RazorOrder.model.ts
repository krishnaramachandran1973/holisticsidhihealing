/* tslint:disable:one-line */


import {Deserializable} from "./common/Deserializable.model";

export class RazorOrder implements Deserializable
{
  id: string;
  key: string;
  txnId: string;
  orderId: string;
  razorPayPaymentId: string;

  deserialize(input: any): this
  {
    Object.assign(this, input);
    return this;
  }
}
