import {Deserializable} from "./common/Deserializable.model";

export class Product implements Deserializable
{

  id: number;
  selected: string;
  type: string;
  price: number;

  constructor(id: number, selected: string, type: string, price: number)
  {
    this.id = id
    this.selected = selected;
    this.type = type;
    this.price = price;
  }

  deserialize(input: any): this
  {
    Object.assign(this, input);
    return this;
  }
}
