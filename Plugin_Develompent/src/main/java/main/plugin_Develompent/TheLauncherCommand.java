package main.plugin_Develompent; // Fixed package name spelling

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TheLauncherCommand implements CommandExecutor { // Changed class name to TheLauncherCommand

    private final JavaPlugin plugin; // Reference to the main plugin class

    public TheLauncherCommand(JavaPlugin plugin) { // Constructor
        this.plugin = plugin; // Initializing the plugin reference
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) { // Check if the sender is a player
            Player player = (Player) sender; // Cast the sender to a Player
            ItemStack launcher = TheLauncherItem.createLauncherItem(); // Create the Launcher item

            // Give The Launcher to the player
            player.getInventory().addItem(launcher); // Add the launcher to the player's inventory
            player.sendMessage(ChatColor.GREEN + "You have received The Launcher!"); // Notify the player
            return true; // Indicate the command was handled successfully
        } else {
            sender.sendMessage(ChatColor.RED + "Only players can use this command."); // Notify non-player senders
            return false; // Indicate the command was not handled successfully
        }
    }
}