package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TurtleHatche implements Listener {
    private final JavaPlugin plugin;

    // Constructor now accepts a JavaPlugin instance
    public TurtleHatche(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin); // Register events
    }

    @EventHandler
    public void onTurtleHatcherInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Check if the player right-clicks in the air or on a block
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack itemInHand = player.getInventory().getItemInMainHand();

            // Check if the item in hand is the Turtle Hatcher
            if (itemInHand != null && itemInHand.isSimilar(TurtleHatcherItem.createTurtleHatcher())) {
                // Spawn a turtle at the player's location
                player.getWorld().spawnEntity(player.getLocation(), EntityType.TURTLE);
                player.sendMessage(ChatColor.RED + "You hatched a Turtle!");
            }
        }
    }
}