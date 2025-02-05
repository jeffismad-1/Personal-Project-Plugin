package main.plugin_Develompent;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChallengeCommand implements CommandExecutor {

    private final BlockBreakChallenge blockBreakChallenge;
    private final RandomBlockChallenge randomBlockChallenge;

    // Constructor to initialize both challenges
    public ChallengeCommand(BlockBreakChallenge blockBreakChallenge, RandomBlockChallenge randomBlockChallenge) {
        this.blockBreakChallenge = blockBreakChallenge;
        this.randomBlockChallenge = randomBlockChallenge;
    }

    // Command to start/stop the challenges
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("challenges")) {
            if (args.length == 1) {
                // Handle Block Break Challenge
                if (args[0].equalsIgnoreCase("start")) {
                    if (!blockBreakChallenge.isChallengeActive()) {
                        blockBreakChallenge.startChallenge();
                        sender.sendMessage("Block Break Challenge has started!");
                    } else {
                        sender.sendMessage("Block Break Challenge is already running.");
                    }
                    return true;
                } else if (args[0].equalsIgnoreCase("stop")) {
                    if (blockBreakChallenge.isChallengeActive()) {
                        blockBreakChallenge.stopChallenge();
                        sender.sendMessage("Block Break Challenge has stopped and all multipliers have been reset.");
                    } else {
                        sender.sendMessage("Block Break Challenge is not running.");
                    }
                    return true;
                }

                // Handle Random Block Challenge
                else if (args[0].equalsIgnoreCase("randomstart")) {
                    if (!randomBlockChallenge.isChallengeActive()) {
                        randomBlockChallenge.startRandomBlockChallenge();
                        sender.sendMessage("Random Block Challenge has started!");
                    } else {
                        sender.sendMessage("Random Block Challenge is already running.");
                    }
                    return true;
                } else if (args[0].equalsIgnoreCase("randomstop")) {
                    if (randomBlockChallenge.isChallengeActive()) {
                        randomBlockChallenge.stopRandomBlockChallenge();
                        sender.sendMessage("Random Block Challenge has stopped.");
                    } else {
                        sender.sendMessage("Random Block Challenge is not running.");
                    }
                    return true;
                }
            }
        }
        return false;
    }
}