package main.plugin_Develompent;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Plugin_Develompent extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the TurtleHatche event listener
        new TurtleHatche(this);
        new TheLauncher(this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);


        // Register the TurtleHatcheCommand executor for the command "turtlehatche"
        Objects.requireNonNull(this.getCommand("thelauncher")).setExecutor(new TheLauncherCommand(this));
        Objects.requireNonNull(this.getCommand("turtlehatche")).setExecutor(new TurtleHatcheCommand(this));
    }
}