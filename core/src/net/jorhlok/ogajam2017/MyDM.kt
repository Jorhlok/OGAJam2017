package net.jorhlok.ogajam2017

import net.jorhlok.multiav.MultiAudioRegister
import net.jorhlok.multiav.MultiGfxRegister
import net.jorhlok.oops.DungeonMaster

abstract class MyDM(val mapname: String,
                    var MGR: MultiGfxRegister,
                    var MAR: MultiAudioRegister) : DungeonMaster(mapname) {
}