package mmd.lib;

import mmd.lib.config.ConfigurationHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = MMDLib.MOD_ID,
        name = MMDLib.MOD_NAME,
        version = MMDLib.VERSION
)
public class MMDLib {

    public static final String MOD_ID = "mmdlib";
    public static final String MOD_NAME = "MMDLib";
    public static final String VERSION = "0.0.1";
    public static final Logger LOG = LogManager.getLogger(MOD_NAME);

    @EventHandler
    public void construction(FMLConstructionEvent event) {

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.INSTANCE.load();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}