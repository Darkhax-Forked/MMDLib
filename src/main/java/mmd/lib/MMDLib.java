package mmd.lib;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = MMDLib.MOD_ID,
        name = MMDLib.MOD_NAME,
        version = MMDLib.VERSION
)
public class MMDLib {

    public static final String MOD_ID = "mmdlib";
    public static final String MOD_NAME = "MMDLib";
    public static final String VERSION = "0.0.1";

    @EventHandler
    public void construction(FMLConstructionEvent event) {

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}