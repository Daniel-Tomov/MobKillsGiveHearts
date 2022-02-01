package me.cageydinosaur.mobkillsgivehearts;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Events implements Listener {
	Main plugin;

	public Events(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMobKill(EntityDeathEvent e) {
		if (e.getEntity() instanceof LivingEntity) {
			if (e.getEntity().getKiller() instanceof Player) {
				Player p = e.getEntity().getKiller();
				int mobKills = p.getStatistic(Statistic.MOB_KILLS);
				if (mobKills > 25) {
					double health = 21 + ((.2 * mobKills) - 5);
					if (health == (int) health) {
						p.setMaxHealth(health);
						p.sendMessage(ChatColor.GREEN + "You have increased your health by one");
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
					}
				}
			}
		}
	}

}