package main.plugin_Develompent;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TurtleHatche  implements Listener {

    public TurtleHatche(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


}
