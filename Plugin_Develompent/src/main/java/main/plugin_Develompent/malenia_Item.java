package main.plugin_Develompent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.UUID;

public class malenia_Item {

    public static ItemStack getMaleniaItem() {
        ItemStack malenia = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta meta = malenia.getItemMeta();
        if (meta == null) return malenia; // Safety check

        // Set custom item display properties
        meta.setDisplayName(ChatColor.RED + "Hand of Malenia");
        meta.setLore(Arrays.asList(
                ChatColor.GRAY + "Right-click to unleash the",
                ChatColor.GOLD + "Waterfowl Dance!"
        ));
        meta.setUnbreakable(true);

        // Add glowing effect by using a fake enchantment
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Set custom attribute for attack damage
        AttributeModifier damageModifier = new AttributeModifier(
                UUID.randomUUID(),
                "custom_attack_damage",
                5000000000.0, // Adjusted value for better balance
                AttributeModifier.Operation.ADD_NUMBER
        );
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);

        // Hide attributes if needed
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        malenia.setItemMeta(meta);
        return malenia;
    }

    public static void addRecipe(JavaPlugin plugin) {
        ItemStack malenia = getMaleniaItem();
        NamespacedKey key = new NamespacedKey(plugin, "malenia");
        ShapedRecipe recipe = new ShapedRecipe(key, malenia);

        // Define the recipe
        recipe.shape(
                " D ",
                " D ",
                " S "
        );
        recipe.setIngredient('D', Material.DIAMOND_SWORD);
        recipe.setIngredient('S', Material.STICK);

        // Add the recipe to the server
        plugin.getServer().addRecipe(recipe);
    }
}