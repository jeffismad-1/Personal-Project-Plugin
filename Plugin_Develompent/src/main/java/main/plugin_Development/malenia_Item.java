package main.plugin_Development;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class malenia_Item {
    public static ItemStack getMaleniaItem(){
        ItemStack malenia = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta meta = malenia.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Hand of Malenia");
        meta.setLore(Arrays.asList(
                "Right click to do Waterfowl Dance"
        ));
        meta.setUnbreakable(true);
        meta.setEnchantmentGlintOverride(true);
        malenia.setItemMeta(meta);
        return malenia;
    }
    public static void addRecipe(JavaPlugin plugin){
        ItemStack malenia = getMaleniaItem();
        NamespacedKey key = new NamespacedKey(plugin, "malenia");
        ShapedRecipe recipe = new ShapedRecipe(key, malenia);
        recipe.shape(
                "D",
                "D",
                "S"
        );
        recipe.setIngredient('D', Material.DIAMOND_SWORD);
        recipe.setIngredient('S', Material.STICK);
    }

}
