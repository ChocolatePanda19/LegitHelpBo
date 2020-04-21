package punishmentguis.punishmentguis.Events;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import punishmentguis.punishmentguis.Guis.MainGui;
import punishmentguis.punishmentguis.Main;
import punishmentguis.punishmentguis.Utils;

public class KickEvent {
    public static Main main = Main.main;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains("&7Kick Punishments")) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            OfflinePlayer target = main.playerPunish.get(p);
            if (e.getCurrentItem() != null) {
                if (e.getSlot() == 13) {
                    p.closeInventory();
                    p.sendMessage(Utils.toColor(main.getConfig().getString("kick-reason-message").replaceAll("\\{player}", target.getName())));
                }
                if (e.getSlot() == 22) {
                    p.closeInventory();
                    p.openInventory(new MainGui().MainGUIInventory);
                }
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (main.getReasonList().containsKey(p)) {
            e.setCancelled(true);
            OfflinePlayer target = main.playerPunish.get(e.getPlayer());
            Bukkit.dispatchCommand(p, "kick " + target.getName() + " " + e.getMessage());
            main.getReasonList().remove(p);
        }
    }
}
