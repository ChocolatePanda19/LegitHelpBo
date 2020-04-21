package punishmentguis.punishmentguis.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import punishmentguis.punishmentguis.Main;

public class DragonEggEvent {

    public static Main main = Main.main;

    @EventHandler
    public void onInteraction(PlayerInteractEvent e) {
        Block block = e.getClickedBlock();
        if (block == null) {
            return;
        }

        if (block.getType() == Material.DRAGON_EGG){
            e.setCancelled(true);
        }
    }
}
