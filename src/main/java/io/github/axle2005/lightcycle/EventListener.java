package io.github.axle2005.lightcycle;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {
	LightCycle plugin;
	
	public EventListener(LightCycle plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
    public void movement(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Location loc = p.getLocation().getBlock().getLocation();
        World world = p.getWorld();
        
        //Block blueglass = Material.STAINED_GLASS_PANE;
        
        if(p.isInsideVehicle() == false)
        {
            Horse horse = (Horse) loc.getWorld().spawnEntity(loc, EntityType.HORSE);
            horse.setVariant(Variant.SKELETON_HORSE);
            horse.setTamed(true);
            
            horse.setPassenger(p);
        }
        else if(p.isInsideVehicle() && p.getVehicle() instanceof Horse)
        {
        	Horse horse = (Horse) p.getVehicle();
        	if(horse.isInsideVehicle() && horse.getVehicle() instanceof Minecart)
        	{
        		int cartpitch = (int)horse.getLocation().getPitch();
                int cartyaw = (int)horse.getLocation().getYaw();
                plugin.log.info(cartyaw+"");
        	}
        	else
        	{
        		Minecart cart = (Minecart) loc.getWorld().spawnEntity(horse.getLocation(), EntityType.MINECART);
            	cart.setPassenger(horse);
        	}
        	
        	
            
        }
        
        
        //world.getBlockAt(new Location(world, 0, 100, 0)).setType(Material.STAINED_GLASS_PANE);
        
 
                 	
       
        
    }
}
