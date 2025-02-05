package main.plugin_Develompent;

import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TheLauncher implements Listener {
    private final JavaPlugin plugin; // Store the plugin instance

    public TheLauncher(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin); // Register events properly
    }

    @EventHandler
    public void Shoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        // Check if the player is holding the launcher item and right-clicking or left-clicking
        if (itemInHand != null
                && itemInHand.isSimilar(TheLauncherItem.createLauncherItem())
                && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK
                || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)) {

            // Spawn and launch TNT
            TNTPrimed tnt = player.getWorld().spawn(player.getEyeLocation().add(player.getLocation().getDirection()), TNTPrimed.class);
            tnt.setVelocity(player.getLocation().getDirection().multiply(1.5)); // Adjust launch speed
            tnt.setFuseTicks(40); // Set fuse time (1 second)
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTNTExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof TNTPrimed) {
            event.setCancelled(true);
            float customPower = 40; // Custom explosion power
            event.getLocation().getWorld().createExplosion(event.getLocation(), customPower, true , true); // Create custom explosion
        }
    }
}