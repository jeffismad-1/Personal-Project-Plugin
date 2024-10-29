package main.plugin_Develompent;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TheLauncher implements Listener {
    public TheLauncher(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void Shoot(PlayerInteractEvent  event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (itemInHand!= null
                && itemInHand 
                && (event.getAction().toString().contains("RIGHT_CLICK") || event.getAction().toString().contains("LEFT_CLICK")));
        TNTPrimed tnt = player.getWorld().spawn(player.getEyeLocation().add(player.getLocation().getDirection()), TNTPrimed.class);
        tnt.setVelocity(player.getLocation().getDirection().multiply(1.5));
        tnt.setFuseTicks(20);



        }

    }
}
