package com.healing

import io.quarkus.runtime.Quarkus

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
class HolisticMain: QuarkusApplication {

    override fun run(vararg args: String?): Int {
        Quarkus.waitForExit();
        return 0
    }

}

fun main(args: Array<String>)
{
  Quarkus.run(HolisticMain::class.java, *args);
}
