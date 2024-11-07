package main.plugin_Develompent;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GlacialScepterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Check if the sender is a player
        if (sender instanceof Player) {
            Player p = (Player) sender;

            // Give the Glacial Scepter to the player
            ItemStack glacialScepter = GlacialScepterItem.getGlacialScepterItem();
            p.getInventory().addItem(glacialScepter);

            p.sendMessage("You have received the Glacial Scepter!");
            return true;
        } else {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
    }
}