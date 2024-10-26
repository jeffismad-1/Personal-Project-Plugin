package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TurtleHatcherItem {

    public static ItemStack createTurtleHatcher() {
        ItemStack turtleHatche = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = turtleHatche.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.GOLD + "Turtle Hatcher");
            meta.setUnbreakable(true);
            meta.setLore(Arrays.asList(ChatColor.GREEN + "Right click for a Turtle"));
            turtleHatche.setItemMeta(meta);
        }

        return turtleHatche;
    }
}