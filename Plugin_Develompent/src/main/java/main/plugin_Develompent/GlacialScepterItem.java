package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GlacialScepterItem {
    public static ItemStack getGlacialScepterItem() {
        ItemStack GlacialScepter = new ItemStack(Material.IRON_HOE);
        ItemMeta meta = GlacialScepter.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "Glacial Scepter");
        GlacialScepter.setItemMeta(meta);

        meta.setLore(Arrays.asList(
                "Right Click to shoot a snow ball to slow down your Enemy "
        ));
        return GlacialScepter;
    }
}
