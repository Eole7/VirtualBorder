package fr.eole_.virtualborder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.wasteofplastic.askyblock.events.IslandEnterEvent;
import com.wasteofplastic.askyblock.events.IslandExitEvent;


public class ASkyBlock implements Listener {

	private static Main main;
	
	public ASkyBlock(Main main) {
		ASkyBlock.main = main;
		
	}
	
	@EventHandler
	
	//Exit border
	private void IslandExitEvent(IslandExitEvent event) {
		
		if(main.exit_border_enabled ==  true) {
		
			Player player = Bukkit.getPlayer(event.getPlayer());
			
			if(!player.hasPermission("virtualborder.bypass")) {
				
				Location player_location = player.getLocation();
				Location island_centre_location = event.getIsland().getCenter();
				double island_radius = event.getIsland().getProtectionSize()/2;
				double push_distance = 0.35;
				
				if(player_location.getZ() < -(island_radius-3)+island_centre_location.getZ() && player_location.getZ() > -(island_radius+1)+island_centre_location.getZ()) { //Player moving northward
							
					player_location.setZ(player_location.getZ()+push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.exit_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.exit_border_message);
	 					
	 				}
	 				
				}
						
				if(player_location.getX() > (island_radius-3)+island_centre_location.getX() && player_location.getX() < (island_radius+1)+island_centre_location.getX()) { //Player moving eastward
							
					player_location.setX(player_location.getX()-push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.exit_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.exit_border_message);
	 					
	 				}
	 				
				}
				
				if(player_location.getZ() > (island_radius-3)+island_centre_location.getZ() && player_location.getZ() < (island_radius+1)+island_centre_location.getZ()) { //Player moving southward
							
					player_location.setZ(player_location.getZ()-push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.exit_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.exit_border_message);
	 					
	 				}
	 				
				}
			
				if(player_location.getX() < -(island_radius-3)+island_centre_location.getX() && player_location.getX() > -(island_radius+1)+island_centre_location.getX()) { //Player moving westward
	 				
					player_location.setX(player_location.getX()+push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.exit_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.exit_border_message);
	 					
	 				}
	 				
				}
					
			}
			
		}
			
	}
	
	@EventHandler
	
	//Entry border
	private void IslandEnterEvent(IslandEnterEvent event) {
		
		if(main.entry_border_enabled ==  true) {
		
			Player player = Bukkit.getPlayer(event.getPlayer());
			
			if(!player.hasPermission("virtualborder.bypass")) {
				
				Location player_location = player.getLocation();
				Location island_centre_location = event.getIsland().getCenter();
				double island_radius = event.getIsland().getProtectionSize()/2;
				double push_distance = 0.35;
				
				if(player_location.getZ() > (island_radius-1)+island_centre_location.getZ() && player_location.getZ() < (island_radius+3)+island_centre_location.getZ()) { //Player moving northward
					
					player_location.setZ(player_location.getZ()+push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.entry_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.entry_border_message);
	 					
	 				}
	 				
				}
				
				if(player_location.getX() < -(island_radius-1)+island_centre_location.getX() && player_location.getX() > -(island_radius+3)+island_centre_location.getX()) { //Player moving eastward
	 				
					player_location.setX(player_location.getX()-push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.entry_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.entry_border_message);
	 					
	 				}
	 				
				}
				
				if(player_location.getZ() < -(island_radius-1)+island_centre_location.getZ() && player_location.getZ() > -(island_radius+3)+island_centre_location.getZ()) { //Player moving southward
							
					player_location.setZ(player_location.getZ()-push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.entry_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.entry_border_message);
	 					
	 				}
	 				
				}
						
				if(player_location.getX() > (island_radius-1)+island_centre_location.getX() && player_location.getX() < (island_radius+3)+island_centre_location.getX()) { //Player moving westward
							
					player_location.setX(player_location.getX()+push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.entry_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.entry_border_message);
	 					
	 				}
	 				
				}
				
			}
				
		}
	
	}
		
}