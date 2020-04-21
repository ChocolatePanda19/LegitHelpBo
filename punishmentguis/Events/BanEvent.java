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


public class BanEvent {
    public static Main main = Main.main;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains("&7Ban Punishments")) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            OfflinePlayer target = main.playerPunish.get(p);
            if (e.getCurrentItem() != null) {
                if (e.getSlot() == 11) {
                    p.closeInventory();
                    main.getReasonList().put(p, "1h");
                    p.sendMessage(Utils.toColor(main.getConfig().getString("ban-reason-message").replaceAll("\\{player}", target.getName())));
                }
                if (e.getSlot() == 12) {
                    p.closeInventory();
                    main.getReasonList().put(p, "5h");
                    p.sendMessage(Utils.toColor(main.getConfig().getString("ban-reason-message").replaceAll("\\{player}", target.getName())));
                }
                if (e.getSlot() == 13) {
                    p.closeInventory();
                    main.getReasonList().put(p, "7h");
                    p.sendMessage(Utils.toColor(main.getConfig().getString("ban-reason-message").replaceAll("\\{player}", target.getName())));
                }
                if (e.getSlot() == 14) {
                    p.closeInventory();
                    main.getReasonList().put(p, "1d");
                    p.sendMessage(Utils.toColor(main.getConfig().getString("ban-reason-message").replaceAll("\\{player}", target.getName())));
                }
                if (e.getSlot() == 15) {
                    p.closeInventory();
                    main.getReasonList().put(p, "3d");
                    p.sendMessage(Utils.toColor(main.getConfig().getString("ban-reason-message").replaceAll("\\{player}", target.getName())));
                }
                if (e.getSlot() == 16) {
                    p.closeInventory();
                    main.getReasonList().put(p, "7d");
                    p.sendMessage(Utils.toColor(main.getConfig().getString("ban-reason-message").replaceAll("\\{player}", target.getName())));
                }
                if (e.getSlot() == 17) {
                    p.closeInventory();
                    main.getReasonList().put(p, "");
                    p.sendMessage(Utils.toColor(main.getConfig().getString("ban-reason-message").replaceAll("\\{player}", target.getName())));
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
            Bukkit.dispatchCommand(p, "tempban " + target.getName() + " " + main.getReasonList().get(p) + "  " + e.getMessage());
            main.getReasonList().remove(p);
        }
    }
}
