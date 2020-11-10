import {Deserializable} from "./common/Deserializable.model";

export class Audio implements Deserializable
{
  name: string;

  deserialize(input: any): this
  {
    Object.assign(this, input);
    return this;
  }

}
