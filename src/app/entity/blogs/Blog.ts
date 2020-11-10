import {Deserializable} from "../common/Deserializable.model";
import {BlogMeta} from "./BlogMeta";

export class Blog implements Deserializable
{
  id: number;
  blogMeta: BlogMeta;
  section1: string;
  section2: string;
  section3: string

  deserialize(input: any): this
  {
    this.blogMeta = new BlogMeta().deserialize(input.blogMeta);
    Object.assign(this, input);
    return this;
  }
}
