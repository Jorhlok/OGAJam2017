package net.jorhlok.ogajam2017

import net.jorhlok.multiav.MultiAudioRegister
import net.jorhlok.multiav.MultiGfxRegister
import net.jorhlok.oops.Entity

abstract class MyEntity (
        var MGR: MultiGfxRegister,
        var MAR: MultiAudioRegister) : Entity()  {
    companion object {
        fun getId() = 0
    }
}