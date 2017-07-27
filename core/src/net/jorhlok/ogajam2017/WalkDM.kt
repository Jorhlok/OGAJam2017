package net.jorhlok.ogajam2017

import net.jorhlok.multiav.MultiAudioRegister
import net.jorhlok.multiav.MultiGfxRegister

class WalkDM(mapname: String, MGR: MultiGfxRegister, MAR: MultiAudioRegister) : MyDM(mapname, MGR, MAR) {

    override fun begin() {

    }

    override fun end() {

    }

    override fun dispose() {

    }

    override fun prestep(deltatime: Float) {

    }

    override fun poststep(deltatime: Float) {

    }

    override fun draw(deltatime: Float) {

    }

    override fun flip() {

    }

    override fun pause() {

    }

    override fun unpause() {

    }

    override fun clone() = WalkDM(mapname,MGR,MAR)
}