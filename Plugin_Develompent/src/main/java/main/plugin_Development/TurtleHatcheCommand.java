package main.plugin_Development;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TurtleHatcheCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public TurtleHatcheCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack turtleHatche = TurtleHatcherItem.createTurtleHatcher();

            // Give the Turtle Hatcher to the player
            player.getInventory().addItem(turtleHatche);
            player.sendMessage(ChatColor.GREEN + "You have received a Turtle Hatcher!");
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return false;
        }
    }
}