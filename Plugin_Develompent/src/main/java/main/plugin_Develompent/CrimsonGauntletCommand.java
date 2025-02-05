package main.plugin_Develompent;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CrimsonGauntletCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Check if the sender is a player
        if (sender instanceof Player) {
            Player p = (Player) sender;

            // Give the Crimson Gauntlet to the player
            ItemStack Crimson_Gauntlet  = CrimsonGauntlet_Item.createCrimsonGauntlet();
            p.getInventory().addItem(Crimson_Gauntlet);

            p.sendMessage("You have received the Crimson Gauntlet!");
            return true;
        } else {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
    }
}