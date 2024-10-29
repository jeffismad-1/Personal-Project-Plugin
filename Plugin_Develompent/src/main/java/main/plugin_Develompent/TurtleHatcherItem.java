package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TurtleHatcherItem {

    public static ItemStack createTurtleHatcher() {
        ItemStack turtleHatcher = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = turtleHatcher.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.GOLD + "Turtle Hatcher");
            meta.setUnbreakable(true);
            meta.setLore(Arrays.asList(
                    ChatColor.GREEN + "Right click for a Turtle"));
            meta.setCustomModelData(5353); // Set unique Custom Model Data value
            turtleHatcher.setItemMeta(meta);
        }

        return turtleHatcher;
    }
}