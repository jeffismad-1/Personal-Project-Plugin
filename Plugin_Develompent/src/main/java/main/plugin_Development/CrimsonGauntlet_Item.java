package main.plugin_Development;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CrimsonGauntlet_Item {
    public static ItemStack createCrimsonGauntlet() {
        ItemStack crimsonGauntlet = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = crimsonGauntlet.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Crimson Gauntlet");
            meta.setLore(Arrays.asList(
                    ChatColor.GRAY + "Deals high melee damage and",
                    ChatColor.GRAY + "drains a small amount of health from enemies on hit,",
                    ChatColor.GRAY + "restoring a portion to the player."
            ));
            meta.setUnbreakable(true);
            crimsonGauntlet.setItemMeta(meta);
        }
        return crimsonGauntlet;
    }
}