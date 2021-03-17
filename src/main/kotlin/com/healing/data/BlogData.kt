package com.healing.data

import com.healing.entity.blog.Blog
import com.healing.entity.blog.BlogMeta
import java.time.LocalDate

class BlogData
{
  companion object
  {
    fun blog1(): Blog
    {
      val blogMeta1 = BlogMeta("A Case study", LocalDate.now())
      return Blog(1,blogMeta1, "Patient’s family has been experiencing continuous problems – " +
        "unemployment, loss of income, trust deficits, frequent quarrels, suicide attempts by family members, etc. ",
        "Patient along with close family members met Linesh to obtain some succour. On meditation, Linesh " +
          "could clearly see the root of all problems. Patient was given Vibhuti and Haldi powder empowered with JAPA. ",
        "The patient and family members were asked to intake the Vibhuti and Haldi powder for a month. " +
          "During the month itself, their problems began to recede. Peace reigned at home, unemployed got jobs. " +
          "The family atmosphere changed from gloomy to happy!!")
    }

    fun blog2(): Blog
    {
      val blogMeta2 = BlogMeta("A Case Study", LocalDate.of(2019, 8, 3))
      return Blog(2, blogMeta2, "Daughter’s marriage kept getting fixed but also " +
        "kept getting cancelled.", "Linesh gave Vibhuti and also instructed the patient to perform " +
        "specific poojas at specific temples.", "Within 3 months, the daughter got engaged and marriage " +
        "happened within 6 months.")
    }

    fun blog3(): Blog
    {
      val blogMeta3 = BlogMeta("A Case Study", LocalDate.of(2019, 1, 18))
      return Blog(3, blogMeta3, "Patient had been suffering with neck pain for over " +
        "8 years. He was not able to raise his hands. ", "Had visited many doctors but to no avail. " +
        "He approached Linesh as a last measure. On meditation, Linesh could visualize the cause of the pain within " +
        "the body. He instilled positive energy into the affected areas. ", "Patient was also given Vibhuti " +
        "and Haldi powder to be consumer over a specific time period. Within a week, patient was able to raise hands, " +
        "turn heads without any feel of pain!!")
    }

    fun blog4(): Blog
    {
      val blogMeta4 = BlogMeta("A Case Study", LocalDate.of(2020, 1, 26))
      return Blog(4, blogMeta4, "Patient’s family having problems for more than " +
        "10 years – business losses, family problems, loss of peace, frequent quarrels. ", "Linesh on " +
        "meditation realized that the problem roots were in the forefather’s times. The poojas done during that time " +
        "were discontinued by this generation. ", "Patient was asked to resume the poojas. When the " +
        "instructions were executed, the family’s fortunes changed. Everything became positive, problems reduced " +
        "and peace was back.")
    }
  }

}
