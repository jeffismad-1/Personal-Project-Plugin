package main.plugin_Develompent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class World_Eater_Item {

    // Method to create a "World Eater" snowball item
    public static ItemStack createWorldEaterSnowball() {
        // Create a snowball item
        ItemStack snowball = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = snowball.getItemMeta();

        if (meta != null) {
            // Set the custom name for the snowball item
            meta.setDisplayName("§6World Eater"); // Gold color for the name
            snowball.setItemMeta(meta);
        }

        return snowball;
    }

    // Method to give the "World Eater" snowball to a player
    public static void giveWorldEaterSnowball(Player player) {
        ItemStack snowball = createWorldEaterSnowball();

        // Add the "World Eater" snowball to the player's inventory
        player.getInventory().addItem(snowball);
    }
}
