package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class TurtleHatche  implements Listener {

    public TurtleHatche(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onturtleHatche(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack TurtleHatche = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = TurtleHatche.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + " Turtle Hatcher");
        meta.setUnbreakable(true);
        meta.setLore(Arrays.asList(
                ChatColor.GREEN + "Right click for a Turtle"
                )
        );

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().equals(TurtleHatche)) {

            }
        }
    }

    private boolean playerHasItem(Player player, ItemStack TurtleHatche) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.isSimilar(TurtleHatche)) {
                return true;
            }
        }
        return false;
    }

}



