package main.plugin_Development;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Plugin_Develompent extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the TurtleHatche event listener
        new TurtleHatche(this);
        new TheLauncher(this);
        new GlacialScepter(this);
        new CrimsonGauntlet(this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        GlacialScepterItem.addRecipe(this);
        malenia_Item.addRecipe(this);


        // Register the TurtleHatcheCommand executor for the command "turtlehatche"
        Objects.requireNonNull(this.getCommand("thelauncher")).setExecutor(new TheLauncherCommand(this));
        Objects.requireNonNull(this.getCommand("turtlehatche")).setExecutor(new TurtleHatcheCommand(this));
        this.getCommand("giveglacialscepter").setExecutor(new GlacialScepterCommand());
        this.getCommand("givecrimsongauntlet").setExecutor(new CrimsonGauntletCommand());

    }
}