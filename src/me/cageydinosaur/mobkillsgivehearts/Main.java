package me.cageydinosaur.mobkillsgivehearts;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(new Events(this), this);
	}
	
	public void onDisable() {
		
	}
	
}
