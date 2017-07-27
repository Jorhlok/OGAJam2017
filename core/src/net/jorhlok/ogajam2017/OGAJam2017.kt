package net.jorhlok.ogajam2017

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.utils.Array
import net.jorhlok.multiav.MultiAudioRegister
import net.jorhlok.multiav.MultiGfxRegister
import net.jorhlok.oops.ObjectOrientedPlaySet

class OGAJam2017 : ApplicationAdapter() {
    private var mgr: MultiGfxRegister? = null
    private var mar: MultiAudioRegister? = null
    private var oops: ObjectOrientedPlaySet? = null

    override fun create() {
        mgr = MultiGfxRegister()
        mar = MultiAudioRegister()
        mkav()
        mgr!!.Generate()
        mar!!.Generate()
        mar!!.setMusVolume(0.5f)
        mar!!.setSFXVolume(0.5f)

        oops = ObjectOrientedPlaySet()
        oops!!.FrameThreshold = 0.2f //low power game can probably handle 5 fps without physics breaking down

        oops!!.addTileMap("Village", TmxMapLoader(InternalFileHandleResolver()).load("map/village.tmx"))

//        oops!!.GlobalData["Bat"] = LabelledObject("int",0)

        oops!!.addMasterScript("title",Title("",mgr!!,mar!!))
        oops!!.launchScript("title")
    }

    override fun render() {
        val deltatime = Gdx.graphics.deltaTime
        oops!!.step(deltatime)
        try {
            oops!!.draw(deltatime)
        } catch (e: Exception) {
            System.err.println("Error drawing!")
            e.printStackTrace()
        }
        if (oops!!.Quit) Gdx.app.exit()
    }

    override fun dispose() {
        oops?.dispose()
        mgr?.dispose()
        mar?.dispose()
    }

    fun mkav() {
        mgr?.newBuffer("main",640,360,640f,360f)

        mgr!!.newFont("dl6", BitmapFont(Gdx.files.internal("gfx/fnt/DawnLike6.fnt")))
        mgr!!.newFont("dl8", BitmapFont(Gdx.files.internal("gfx/fnt/DawnLike8.fnt")))

        mgr!!.newImageRgb("chars","gfx/CGabrielChars24x24.png",24,24)
        mgr!!.newImageRgb("faces","gfx/CGabrielFaces48x48.png",48,48)

        mkchar("AdultTemplate",0,   0,0)
        mkchar("ChildTemplate",1,   2,0)
        mkchar("WarriorM",2,        0,1)
        mkchar("MageM",3,           1,1)
        mkchar("HealerM",4,         2,1)
        mkchar("NinjaM",5,          3,1)
        mkchar("RangerM",6,         4,1)
        mkchar("ManA",7,            5,1)
        mkchar("WarriorF",8,        6,1)
        mkchar("MageF",9,           7,1)
        mkchar("HealerF",10,        0,2)
        mkchar("NinjaF",11,         1,2)
        mkchar("RangerF",12,        2,2)
        mkchar("WomanA",13,         3,2)
        mkchar("MonkM",14,          4,2)
        mkchar("BerserkerM",15,     5,2)
        mkchar("DKnightM",16,       6,2)
        mkchar("SoldierM",17,       7,2)
        mkchar("ManB",18,           0,3)
        mkchar("ManC",19,           1,3)
        mkchar("MonkF",20,          2,3)
        mkchar("BerserkerF",21,     3,3)
        mkchar("DKnightF",22,       4,3)
        mkchar("SoldierF",23,       5,3)
        mkchar("WomanB",24,         6,3)
        mkchar("WomanC",25,         7,3)
        mkchar("ElementalFire",26,  0,4)
        mkchar("ElementalWater",27, 1,4)
        mkchar("ElementalWind",28,  2,4)
        mkchar("ElementalEarth",29, 3,4)
        mkchar("ElementalLight",30, 4,4)
        mkchar("ElementalDark",31,  5,4)
        mkchar("Priest",32,         6,4)
        mkchar("Nun",33,            7,4)
        mkchar("Merchant",34,       0,5)
        mkchar("Cultist",35,        1,5)
        mkchar("Pirate",36,         2,5)
        mkchar("Captain",37,        3,5)
        mkchar("SamuraiM",38,       4,5)
        mkchar("SamuraiF",39,       5,5)
        mkchar("Boy",40,            6,5)
        mkchar("Girl",41,           7,5)
        mkchar("Dancer",42,         0,6)
        mkchar("King",43,           1,6)
        mkchar("Queen",44,          2,6)
        mkchar("ManD",45,           3,6)
        mkchar("WomanD",46,         4,6)
        mkchar("Vampire",47,        5,6)
        mkchar("Bard",48,           7,6)
        mkchar("Paladin",49,        0,7)
        mkchar("Playmate",50,       1,7)
        mkchar("AngelM",51,         2,7)
        mkchar("AngelF",52,         5,7)
    }

    fun mkchar(name: String, yoff: Int, px: Int, py: Int) {
        mgr!!.newSpriteRgb("${name}WalkUp0","chars",0,yoff*3)
        mgr!!.newSpriteRgb("${name}StandUp","chars",1,yoff*3)
        mgr!!.newSpriteRgb("${name}WalkUp1","chars",2,yoff*3)
        mgr!!.newSpriteRgb("${name}PunchUp0","chars",3,yoff*3)
        mgr!!.newSpriteRgb("${name}PunchUp1","chars",4,yoff*3)
        mgr!!.newSpriteRgb("${name}PunchUp2","chars",5,yoff*3)
        mgr!!.newSpriteRgb("${name}CastUp0","chars",6,yoff*3)
        mgr!!.newSpriteRgb("${name}CastUp1","chars",7,yoff*3)
        mgr!!.newSpriteRgb("${name}CastUp2","chars",8,yoff*3)
        mgr!!.newSpriteRgb("${name}CastUp3","chars",9,yoff*3)

        mgr!!.newSpriteRgb("${name}WalkRt0","chars",0,yoff*3+1)
        mgr!!.newSpriteRgb("${name}StandRt","chars",1,yoff*3+1)
        mgr!!.newSpriteRgb("${name}WalkRt1","chars",2,yoff*3+1)
        mgr!!.newSpriteRgb("${name}PunchRt0","chars",3,yoff*3+1)
        mgr!!.newSpriteRgb("${name}PunchRt1","chars",4,yoff*3+1)
        mgr!!.newSpriteRgb("${name}PunchRt2","chars",5,yoff*3+1)
        mgr!!.newSpriteRgb("${name}CastRt0","chars",6,yoff*3+1)
        mgr!!.newSpriteRgb("${name}CastRt1","chars",7,yoff*3+1)
        mgr!!.newSpriteRgb("${name}CastRt2","chars",8,yoff*3+1)
        mgr!!.newSpriteRgb("${name}CastRt3","chars",9,yoff*3+1)

        mgr!!.newSpriteRgb("${name}WalkDn0","chars",0,yoff*3+2)
        mgr!!.newSpriteRgb("${name}StandDn","chars",1,yoff*3+2)
        mgr!!.newSpriteRgb("${name}WalkDn1","chars",2,yoff*3+2)
        mgr!!.newSpriteRgb("${name}PunchDn0","chars",3,yoff*3+2)
        mgr!!.newSpriteRgb("${name}PunchDn1","chars",4,yoff*3+2)
        mgr!!.newSpriteRgb("${name}PunchDn2","chars",5,yoff*3+2)
        mgr!!.newSpriteRgb("${name}CastDn0","chars",6,yoff*3+2)
        mgr!!.newSpriteRgb("${name}CastDn1","chars",7,yoff*3+2)
        mgr!!.newSpriteRgb("${name}CastDn2","chars",8,yoff*3+2)
        mgr!!.newSpriteRgb("${name}CastDn3","chars",9,yoff*3+2)

        mgr!!.newSpriteRgb("${name}WalkLf0","chars",0,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}StandLf","chars",1,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}WalkLf1","chars",2,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}PunchLf0","chars",3,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}PunchLf1","chars",4,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}PunchLf2","chars",5,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}CastLf0","chars",6,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}CastLf1","chars",7,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}CastLf2","chars",8,yoff*3+1,1,1,true)
        mgr!!.newSpriteRgb("${name}CastLf3","chars",9,yoff*3+1,1,1,true)

        mgr!!.newSpriteRgb("${name}Portrait","faces",px,py)

        val walkspeed = 0.125f
        val punchspeed = 0.125f
        val castspeed = 0.125f
        mgr!!.newAnimRgb("${name}WalkUp",Array(arrayOf("${name}WalkUp0","${name}StandUp","${name}WalkUp1","${name}StandUp")),walkspeed)
        mgr!!.newAnimRgb("${name}PunchUp",Array(arrayOf("${name}StandUp","${name}PunchUp0","${name}PunchUp1","${name}PunchUp2")),punchspeed, Animation.PlayMode.NORMAL)
        mgr!!.newAnimRgb("${name}CastUp",Array(arrayOf("${name}StandUp","${name}CastUp0","${name}CastUp1","${name}CastUp2","${name}CastUp3")),castspeed, Animation.PlayMode.NORMAL)

        mgr!!.newAnimRgb("${name}WalkDn",Array(arrayOf("${name}WalkDn0","${name}StandDn","${name}WalkDn1","${name}StandDn")),walkspeed)
        mgr!!.newAnimRgb("${name}PunchDn",Array(arrayOf("${name}StandDn","${name}PunchDn0","${name}PunchDn1","${name}PunchDn2")),punchspeed, Animation.PlayMode.NORMAL)
        mgr!!.newAnimRgb("${name}CastDn",Array(arrayOf("${name}StandDn","${name}CastDn0","${name}CastDn1","${name}CastDn2","${name}CastDn3")),castspeed, Animation.PlayMode.NORMAL)

        mgr!!.newAnimRgb("${name}WalkLf",Array(arrayOf("${name}WalkLf0","${name}StandLf","${name}WalkLf1","${name}StandLf")),walkspeed)
        mgr!!.newAnimRgb("${name}PunchLf",Array(arrayOf("${name}StandLf","${name}PunchLf0","${name}PunchLf1","${name}PunchLf2")),punchspeed, Animation.PlayMode.NORMAL)
        mgr!!.newAnimRgb("${name}CastLf",Array(arrayOf("${name}StandLf","${name}CastLf0","${name}CastLf1","${name}CastLf2","${name}CastLf3")),castspeed, Animation.PlayMode.NORMAL)

        mgr!!.newAnimRgb("${name}WalkRt",Array(arrayOf("${name}WalkRt0","${name}StandRt","${name}WalkRt1","${name}StandRt")),walkspeed)
        mgr!!.newAnimRgb("${name}PunchRt",Array(arrayOf("${name}StandRt","${name}PunchRt0","${name}PunchRt1","${name}PunchRt2")),punchspeed, Animation.PlayMode.NORMAL)
        mgr!!.newAnimRgb("${name}CastRt",Array(arrayOf("${name}StandRt","${name}CastRt0","${name}CastRt1","${name}CastRt2","${name}CastRt3")),castspeed, Animation.PlayMode.NORMAL)
    }
}
