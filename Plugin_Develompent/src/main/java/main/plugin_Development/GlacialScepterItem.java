package main.plugin_Development;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class GlacialScepterItem {
    public static ItemStack getGlacialScepterItem() {
        ItemStack GlacialScepter = new ItemStack(Material.IRON_HOE);
        ItemMeta meta = GlacialScepter.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "Glacial Scepter");

        meta.setLore(Arrays.asList(
                "Right Click to shoot a snow ball to slow down your Enemy "
        ));
        meta.setUnbreakable(true);
        meta.setEnchantmentGlintOverride(true);
        GlacialScepter.setItemMeta(meta);


        return GlacialScepter;
    }
    public static void addRecipe(JavaPlugin plugin) {
        ItemStack glacialScepterItem = getGlacialScepterItem();
        NamespacedKey key = new NamespacedKey(plugin, "glacial_scepter");
        ShapedRecipe recipe = new ShapedRecipe(key, glacialScepterItem);
        recipe.shape("XX ", " | ", " | ");
        recipe.setIngredient('X', Material.SNOWBALL);
        recipe.setIngredient('|', Material.STICK);
        Bukkit.addRecipe(recipe);
}
}
