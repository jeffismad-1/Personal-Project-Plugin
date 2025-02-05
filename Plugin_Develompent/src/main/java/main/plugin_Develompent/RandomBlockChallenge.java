package main.plugin_Develompent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomBlockChallenge implements Listener {
    private boolean isRandomBlockChallengeActive = false;

    private final List<Material> RandomBlockChallengeMaterials = Arrays.stream(Material.values())
            .filter(material -> material.isItem() || material.isBlock() || material.name().contains("CHEST")) // Include blocks, items, and chests
            .collect(Collectors.toList());

    public void startRandomBlockChallenge() {
        isRandomBlockChallengeActive = true;
    }

    public boolean isRandomBlockChallengeActive() {
        return isRandomBlockChallengeActive;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!isRandomBlockChallengeActive) {
            return;
        }

        // Cancel the default block drop (so the original block doesn't drop)
        event.setDropItems(false);

        Random random = new Random();
        Material randomMaterial = RandomBlockChallengeMaterials.get(random.nextInt(RandomBlockChallengeMaterials.size()));
        ItemStack randomItem = new ItemStack(randomMaterial, 1);

        // Drop the random item at the location of the block the player broke
        World world = event.getBlock().getWorld();
        world.dropItemNaturally(event.getBlock().getLocation(), randomItem);
    }

    public void stopRandomBlockChallenge() {
        isRandomBlockChallengeActive = false;
    }

    public boolean isChallengeActive() {
        return isRandomBlockChallengeActive;
    }
}