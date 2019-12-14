package fr.eole_.virtualborder;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

	boolean exit_border_enabled;
	String exit_border_message;
	
	boolean entry_border_enabled;
	String entry_border_message;
	
	@Override
	public void onEnable() {
		
		@SuppressWarnings("unused")
		Metrics metrics = new Metrics(this);
		
		if (getServer().getPluginManager().isPluginEnabled("ASkyBlock")) {
	    
			getServer().getPluginManager().registerEvents(new ASkyBlock(this), this);
			System.out.println("§aVirtualBorder has successfully hooked into ASkyBlock.");
	      
		}
	    
		else if (getServer().getPluginManager().isPluginEnabled("BentoBox")) {
	    
			if (world.bentobox.bentobox.BentoBox.getInstance().getAddonsManager().getAddons().toString().contains("BSkyBlock")) {
	    	  
				getServer().getPluginManager().registerEvents(new BentoBox(this), this);
				System.out.println("§aVirtualBorder has successfully hooked into BentoBox: BSkyBlock.");
			}
	      
			else if (world.bentobox.bentobox.BentoBox.getInstance().getAddonsManager().getAddons().toString().contains("AcidIsland")) {
	      
				getServer().getPluginManager().registerEvents(new BentoBox(this), this);
				System.out.println("§aVirtualBorder has successfully hooked into BentoBox: AcidIsland.");
	        
			}
	      
			else if (world.bentobox.bentobox.BentoBox.getInstance().getAddonsManager().getAddons().toString().contains("SkyGrid")) {
	    	  
				getServer().getPluginManager().registerEvents(new BentoBox(this), this);
				System.out.println("§aVirtualBorder has successfully hooked into BentoBox: SkyGrid.");
				
			}
	      
			else {
	    	  
				System.out.println("§cVirtualBorder failed to hook into any BentoBox addon.");
	      
			}
	      
	    }
	    
		else {
	    	
			System.out.println("§cVirtualBorder failed to hook into ASkyBlock or BentoBox.");
	    
		}
		
		saveDefaultConfig();
		
		exit_border_enabled = this.getConfig().getBoolean("borders.exit_border.enabled");
		exit_border_message = this.getConfig().getString("borders.exit_border.message").replaceAll("&", "§");
		
		entry_border_enabled = this.getConfig().getBoolean("borders.entry_border.enabled");
		entry_border_message = this.getConfig().getString("borders.entry_border.message").replaceAll("&", "§");
		
	}
	
}