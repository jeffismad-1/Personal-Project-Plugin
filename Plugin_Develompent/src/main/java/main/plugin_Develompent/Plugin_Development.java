package main.plugin_Develompent;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Plugin_Development extends JavaPlugin {

    @Override
    public void onEnable() {
        // Create challenge instances
        BlockBreakChallenge blockBreakChallenge = new BlockBreakChallenge();
        RandomBlockChallenge randomBlockChallenge = new RandomBlockChallenge();

        // Register challenges
        getServer().getPluginManager().registerEvents(blockBreakChallenge, this);
        getServer().getPluginManager().registerEvents(randomBlockChallenge, this);

        // Register commands
        Objects.requireNonNull(getCommand("challenges"))
                .setExecutor(new ChallengeCommand(blockBreakChallenge, randomBlockChallenge));

        // Register event listeners for other components
        getServer().getPluginManager().registerEvents(new TurtleHatche(this), this);
        getServer().getPluginManager().registerEvents(new TheLauncher(this), this);
        getServer().getPluginManager().registerEvents(new GlacialScepter(this), this); // Pass 'this' to the constructor
        getServer().getPluginManager().registerEvents(new CrimsonGauntlet(), this); // Event registration fixed
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);

        // Add custom recipes (ensure `malenia_Item` is properly defined)
        GlacialScepterItem.addRecipe(this);

        // Register specific commands
        Objects.requireNonNull(getCommand("thelauncher"))
                .setExecutor(new TheLauncherCommand(this));
        Objects.requireNonNull(getCommand("turtlehatche"))
                .setExecutor(new TurtleHatcheCommand(this));
        Objects.requireNonNull(getCommand("giveglacialscepter"))
                .setExecutor(new GlacialScepterCommand());
        Objects.requireNonNull(getCommand("givecrimsongauntlet"))
                .setExecutor(new CrimsonGauntletCommand());
    }
}