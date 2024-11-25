package main.plugin_Development;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack(
                "https://drive.google.com/drive/folders/1U7goYZRjemWxuK8p-o_QkbTYbjxjkDN3?dmr=1&ec=wgc-drive-globalnav-goto");
        // );
    }
}
