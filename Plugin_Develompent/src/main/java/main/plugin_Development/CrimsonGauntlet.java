package main.plugin_Development;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CrimsonGauntlet implements Listener {
    public CrimsonGauntlet(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        // Check if the entity involved in the event is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            // Debug message to confirm the event is triggered
          player.sendMessage("Event triggered: " + event.getEntity().getName());
            ItemStack item = player.getInventory().getItemInMainHand();

            // Check if the player is holding the Crimson Gauntlet in their main hand
            if (item != null && item.isSimilar(CrimsonGauntlet_Item.createCrimsonGauntlet())) {
                player.sendMessage("Player is holding the Crimson Gauntlet!");

                // If the player is holding the Crimson Gauntlet, proceed with health and absorption logic
                double damage = event.getDamage();
                double healthGained = damage * 3;
                double newHealth = player.getHealth() + healthGained;

                // If new health exceeds max health, set health to max and apply excess as absorption
                if (newHealth > player.getMaxHealth()) {
                    double excessHealth = newHealth - player.getMaxHealth();
                    player.setHealth(player.getMaxHealth()); // Set health to max health
                    player.setAbsorptionAmount(player.getAbsorptionAmount() + excessHealth); // Apply excess as absorption
                } else {
                    player.setHealth(newHealth); // Set health normally if it's under max
                }
            } else {
                // Debug message if the item doesn't match
                player.sendMessage("Item in main hand does not match Crimson Gauntlet.");
            }

        }
    }

}