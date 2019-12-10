package fr.eole_.virtualborder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.wasteofplastic.askyblock.events.IslandExitEvent;


public class ASkyBlock implements Listener {

	private static Main main;
	
	public ASkyBlock(Main main) {
		ASkyBlock.main = main;
		
	}
	
	@EventHandler
	
	private void IslandExitEvent(IslandExitEvent event) {
		
		Player player =  Bukkit.getPlayer(event.getPlayer());
		
		if(!player.hasPermission("virtualborder.bypass")) {
			
			Location player_location = player.getLocation();
			Location island_centre_location = event.getIsland().getCenter();
			double island_radius = event.getIsland().getProtectionSize()/2;
			double push_distance = 0.35;
			
			if(player_location.getZ() < -(island_radius-3)+island_centre_location.getZ() && player_location.getZ() > -(island_radius+1)+island_centre_location.getZ()) { //North border detection
						
				player_location.setZ(player_location.getZ()+push_distance);
 				player.teleport(player_location);
 				
 				if(main.message_status == true) {
 					
 					player.sendMessage(main.message_text);
 					
 				}
 				
			}
					
			if(player_location.getX() > (island_radius-3)+island_centre_location.getX() && player_location.getX() < (island_radius+1)+island_centre_location.getX()) { //East border detection
						
				player_location.setX(player_location.getX()-push_distance);
 				player.teleport(player_location);
 				
 				if(main.message_status == true) {
 					
 					player.sendMessage(main.message_text);
 					
 				}
 				
			}
			
			if(player_location.getZ() > (island_radius-3)+island_centre_location.getZ() && player_location.getZ() < (island_radius+1)+island_centre_location.getZ()) { //South border detection
						
				player_location.setZ(player_location.getZ()-push_distance);
 				player.teleport(player_location);
 				
 				if(main.message_status == true) {
 					
 					player.sendMessage(main.message_text);
 					
 				}
 				
			}
		
			if(player_location.getX() < -(island_radius-3)+island_centre_location.getX() && player_location.getX() > -(island_radius+1)+island_centre_location.getX()) { //West border detection
 				
				player_location.setX(player_location.getX()+push_distance);
 				player.teleport(player_location);
 				
 				if(main.message_status == true) {
 					
 					player.sendMessage(main.message_text);
 					
 				}
 				
			}
				
		}
			
	}
		
}