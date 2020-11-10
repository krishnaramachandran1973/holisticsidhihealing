import {Deserializable} from "../common/Deserializable.model";

export class BlogMeta implements Deserializable
{
  id:number;
  title:string;
  date:string;

  deserialize(input: any): this
  {
    Object.assign(this, input);
    return this;
  }

}
