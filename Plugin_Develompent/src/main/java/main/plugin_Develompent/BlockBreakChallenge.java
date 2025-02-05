package main.plugin_Develompent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class BlockBreakChallenge implements Listener {

    private boolean isChallengeActive = false; // Track if the challenge is active
    private final HashMap<UUID, Integer> playerMultipliers = new HashMap<>();

    // Max multiplier value to avoid overflow (use Integer.MAX_VALUE)
    private static final int MAX_MULTIPLIER = Integer.MAX_VALUE;
    private static final int MAX_BILLION = 2_000_000_000; // 2 billion (stop sending message)

    // Method to start the challenge
    public void startChallenge() {
        isChallengeActive = true;
    }

    // Method to stop the challenge and reset multipliers
    public void stopChallenge() {
        isChallengeActive = false;
        resetMultipliers();
    }

    // Method to reset all multipliers
    private void resetMultipliers() {
        playerMultipliers.clear(); // Clears all multipliers
    }

    // Check if the challenge is active
    public boolean isChallengeActive() {
        return isChallengeActive;
    }

    // Method to format the multiplier with k, m, and b
    private String formatMultiplier(int multiplier) {
        if (multiplier >= 1_000_000_000) {
            return (multiplier / 1_000_000_000) + "b"; // For billions
        } else if (multiplier >= 1_000_000) {
            return (multiplier / 1_000_000) + "m"; // For millions
        } else if (multiplier >= 1_000) {
            return (multiplier / 1_000) + "k"; // For thousands
        } else {
            return String.valueOf(multiplier); // For numbers less than 1k
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        // If challenge is not active, return
        if (!isChallengeActive) {
            return;
        }

        UUID playerId = player.getUniqueId();

        // Initialize multiplier to 1 if not already set
        playerMultipliers.putIfAbsent(playerId, 1);

        // Get the current multiplier
        int currentMultiplier = playerMultipliers.get(playerId);

        // Drop blocks based on the multiplier
        Material blockType = event.getBlock().getType();
        if (blockType != Material.AIR) { // Avoid air blocks
            ItemStack blockDrop = new ItemStack(blockType, currentMultiplier);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), blockDrop);
        }

        // Break the block
        event.getBlock().setType(Material.AIR);

        // Check if the next multiplier will exceed the MAX_MULTIPLIER
        if (currentMultiplier > MAX_MULTIPLIER / 2) {
            playerMultipliers.put(playerId, MAX_MULTIPLIER); // Set it to MAX_MULTIPLIER to avoid overflow
        } else {
            // Double the multiplier
            playerMultipliers.put(playerId, currentMultiplier * 2);
        }

        // If the multiplier is greater than or equal to 2 billion, stop sending the message
        if (playerMultipliers.get(playerId) >= MAX_BILLION) {
            return; // Don't send the message anymore
        }

        // Format and send the new multiplier message
        String formattedMultiplier = formatMultiplier(playerMultipliers.get(playerId));
        player.sendMessage("Your multiplier is now: " + formattedMultiplier + "!");
    }
}