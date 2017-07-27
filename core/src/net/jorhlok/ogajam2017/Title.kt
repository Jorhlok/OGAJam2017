package net.jorhlok.ogajam2017

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import net.jorhlok.multiav.MultiAudioRegister
import net.jorhlok.multiav.MultiGfxRegister

class Title(mapname: String, MGR: MultiGfxRegister, MAR: MultiAudioRegister) : MyDM(mapname, MGR, MAR) {

    var statetime = 0f
    val animtime = 1f
    val offtime = 0.5f
    var pausetime = -1f
    val pauseperiod = 2f
    val muz = "4"

    override fun begin() {
        MGR.camera.setToOrtho(false,640f,360f)
        MGR.updateCam()
        MGR.getBufCam("main")?.setToOrtho(false,640f,360f)
        MGR.setBufScalar("main")
//        val m = MAR.getMus(muz)
//        m?.Generate()
//        m?.play(true)
    }

    override fun poststep(deltaTime: Float) {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if (pausetime < 0) {
                pausetime = 0f
                MAR.playSFX("start2")
            }
        }
        if (pausetime >= 0) {
            pausetime += deltaTime
            if (pausetime >= pauseperiod) {
//                ScriptSwap = "weh"
            }
        }
    }

    override fun end() {
//        val m = MAR.getMus(muz)
//        m?.stop()
    }

    override fun dispose() {
//        val m = MAR.getMus(muz)
//        m?.dispose()
    }

    override fun draw(deltatime: Float) {
        statetime += deltatime
        if (statetime >= animtime) statetime -= animtime
        MGR.startBuffer("main")
        MGR.clear(0.1f,0.1f,0.1f,1f)
//        MGR.drawString("libmono","Furnish Your House",320f,220.5f,2f,2f)
//        MGR.drawString("libmono","Collect 3 of each Monster Samples",320f,180.5f)
        if (statetime <= offtime) MGR.drawString("dl8","Press Start",320f,100.5f)
//        MGR.drawString("libmono","                Credits\nDesign/Programming: Jorhlok.itch.io\nGfx: sharm.itch.io/tiny16\nSfx: NESFX by hoffymusic.itch.io\nMusic: Chip Mus V1 wavestopmusic.itch.io",320f,32.5f)
        MGR.stopBuffer()
        MGR.drawBuffer("main")
        MGR.flush()
    }

    override fun clone() = Title(mapname,MGR,MAR)
}