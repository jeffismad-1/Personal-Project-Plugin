package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TheLauncherItem {
    public static ItemStack createLauncherItem() {
        ItemStack Launcher = new ItemStack(Material.BOW);
        ItemMeta meta = Launcher.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "THE LAUNCHER");
            meta.setUnbreakable(true);
            meta.setLore(Arrays.asList(
                    ChatColor.GREEN + "Shoot the bow to spawn TNT"
            ));
            meta.setEnchantmentGlintOverride(true);
            Launcher.setItemMeta(meta);
        }
        return Launcher;
    }
}
