package fr.eole_.virtualborder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import world.bentobox.bentobox.api.events.island.IslandEvent.IslandEnterEvent;
import world.bentobox.bentobox.api.events.island.IslandEvent.IslandExitEvent;


public class BentoBox implements Listener {
	
	private static Main main;
	public BentoBox(Main main) {
		BentoBox.main = main;
		
	}
		
	@EventHandler
	private void IslandExitEvent(IslandExitEvent event) {
		
		if(main.exit_border_enabled ==  true) {
		
			Player player = Bukkit.getPlayer(event.getPlayerUUID());
			
			if(!player.hasPermission("virtualborder.bypass")) {
				
				Location player_location = player.getLocation();
				Location island_center_location = event.getIsland().getCenter();
				double island_radius = event.getIsland().getProtectionRange();
				double push_distance = 0.35;
				
				//Northern border
				if(player_location.getZ() < -(island_radius-3)+island_center_location.getZ() && player_location.getZ() > -(island_radius+1)+island_center_location.getZ()) {
						
					player_location.setZ(player_location.getZ()+push_distance);
					player.teleport(player_location);
				
	 				if(!main.exit_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.exit_border_message);
	 					
	 				}
	 				
				}
				
				//Eastern border
				if(player_location.getX() > (island_radius-3)+island_center_location.getX() && player_location.getX() < (island_radius+1)+island_center_location.getX()) {
						
					player_location.setX(player_location.getX()-push_distance);
					player.teleport(player_location);
					
	 				if(!main.exit_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.exit_border_message);
	 					
	 				}
	 				
				}
				
				//Southern border
				if(player_location.getZ() > (island_radius-3)+island_center_location.getZ() && player_location.getZ() < (island_radius+1)+island_center_location.getZ()) {
					
					player_location.setZ(player_location.getZ()-push_distance);
					player.teleport(player_location);
					
	 				if(!main.exit_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.exit_border_message);
	 					
	 				}
					
				}
			
				//Western border
				if(player_location.getX() < -(island_radius-3)+island_center_location.getX() && player_location.getX() > -(island_radius+1)+island_center_location.getX()) {
							
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
	private void IslandEnterEvent(IslandEnterEvent event) {
		
		if(main.entry_border_enabled ==  true) {
		
			Player player = Bukkit.getPlayer(event.getPlayerUUID());
			
			if(!player.hasPermission("virtualborder.bypass")) {
				
				Location player_location = player.getLocation();
				Location island_center_location = event.getIsland().getCenter();
				double island_radius = event.getIsland().getProtectionRange();
				double push_distance = 0.35;
				
				//Northern border
				if(player_location.getZ() > (island_radius-1)+island_center_location.getZ() && player_location.getZ() < (island_radius+3)+island_center_location.getZ()) {
					
					player_location.setZ(player_location.getZ()+push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.entry_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.entry_border_message);
	 					
	 				}
	 				
				}
				
				//Eastern border
				if(player_location.getX() < -(island_radius-1)+island_center_location.getX() && player_location.getX() > -(island_radius+3)+island_center_location.getX()) {
	 				
					player_location.setX(player_location.getX()-push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.entry_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.entry_border_message);
	 					
	 				}
	 				
				}
				
				//Southern border
				if(player_location.getZ() < -(island_radius-1)+island_center_location.getZ() && player_location.getZ() > -(island_radius+3)+island_center_location.getZ()) {
					
					player_location.setZ(player_location.getZ()-push_distance);
	 				player.teleport(player_location);
	 				
	 				if(!main.entry_border_message.equalsIgnoreCase("")) {
	 					
	 					player.sendMessage(main.entry_border_message);
	 					
	 				}
	 				
				}
				
				//Western border
				if(player_location.getX() > (island_radius-1)+island_center_location.getX() && player_location.getX() < (island_radius+3)+island_center_location.getX()) {
							
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
