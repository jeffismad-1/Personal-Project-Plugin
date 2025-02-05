package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class CrimsonGauntlet implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            ItemStack weapon = attacker.getInventory().getItemInMainHand();

            if (CrimsonGauntlet_Item.isCrimsonGauntlet(weapon)) {
                double damage = event.getDamage();
                double healing = damage * 1.5; // Adjust multiplier as needed

                applyHealing(attacker, healing);
                attacker.sendMessage(ChatColor.RED + "❤ Healed " + String.format("%.1f", healing) + " HP");
            }
        }
    }

    private void applyHealing(Player player, double amount) {
        double maxHealth = player.getMaxHealth();
        double currentHealth = player.getHealth();
        double newHealth = Math.min(currentHealth + amount, maxHealth);

        player.setHealth(newHealth);

        // If healing exceeds max health, apply overflow to absorption
        double overflow = (currentHealth + amount) - maxHealth;
        if (overflow > 0) {
            double newAbsorption = Math.min(player.getAbsorptionAmount() + overflow, 20.0); // Cap absorption at 20
            player.setAbsorptionAmount((float) newAbsorption);
        }
    }
}