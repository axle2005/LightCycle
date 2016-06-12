package io.github.axle2005.lightcycle;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class LightCycle extends JavaPlugin {

	PluginDescriptionFile pdfFile = this.getDescription();
	Logger log = Logger.getLogger("Minecraft");
	EventListener listener = new EventListener(this);
	
	@Override
    public void onEnable() {
		log.info("[" + pdfFile.getName() + "] Version: " + pdfFile.getVersion() + " is now enabled!");
		getServer().getPluginManager().registerEvents(listener, this);
	
	}
    
    @Override
    public void onDisable() {
    	log.info("[" + pdfFile.getName() + "] Version: " + pdfFile.getVersion() + " is now enabled!");
    }
    
}
