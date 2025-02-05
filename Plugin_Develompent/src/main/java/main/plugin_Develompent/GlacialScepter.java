package main.plugin_Develompent;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GlacialScepter implements Listener {

    private JavaPlugin plugin;

    public GlacialScepter(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin); // Correct registration
    }

    @EventHandler
    public void Shoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.isSimilar(GlacialScepterItem.getGlacialScepterItem()) && event.getAction() == Action.RIGHT_CLICK_AIR) {
            Snowball snowball = player.launchProjectile(Snowball.class);
            snowball.setShooter(player);
        }
    }

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile instanceof Snowball) {
            if (projectile.getShooter() instanceof Player) {
                if (event.getHitEntity() instanceof LivingEntity) {
                    LivingEntity livingEntity = (LivingEntity) event.getHitEntity();
                    livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 5)); // Adds slowness for 5 seconds
                }
            }
        }
    }
}