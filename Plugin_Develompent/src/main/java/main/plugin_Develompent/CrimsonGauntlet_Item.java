package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class CrimsonGauntlet_Item {
    private static final NamespacedKey GAUNTLET_KEY = new NamespacedKey(JavaPlugin.getPlugin(Plugin_Development.class), "crimson_gauntlet");

    public static ItemStack createCrimsonGauntlet() {
        ItemStack crimsonGauntlet = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = crimsonGauntlet.getItemMeta();

        if (meta != null) {
            // Add persistent data tag
            meta.getPersistentDataContainer().set(GAUNTLET_KEY, PersistentDataType.BYTE, (byte) 1);

            // Rest of your item setup
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

    public static boolean isCrimsonGauntlet(ItemStack item) {
        return item != null &&
                item.hasItemMeta() &&
                item.getItemMeta().getPersistentDataContainer().has(GAUNTLET_KEY, PersistentDataType.BYTE);
    }
}