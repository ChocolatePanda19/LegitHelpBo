package punishmentguis.punishmentguis.Guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import punishmentguis.punishmentguis.Main;
import punishmentguis.punishmentguis.util.ItemUtils;

import java.util.Arrays;

public class MainGui implements Listener {

    public Inventory MainGUIInventory;
    private ItemUtils util = new ItemUtils();
    public static Main main = Main.main;

    public Inventory MainGUIInventory() {
        Inventory mInv = Bukkit.createInventory(null, 27, ("&7Punishments"));
        ItemStack fill = new ItemStack(util.createItemWithLoreAndShort(Material.STAINED_GLASS_PANE, 7, " "));
        ItemStack item1 = new ItemStack(util.createItemWithLoreAndShort(Material.EYE_OF_ENDER, 0, "&cMute Punishments", "&7&o(( &7Click to chose a mute punishment for a player. &7&o))"));
        ItemStack item2 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&4Ban Punishments", "&7&o(( &7Click to chose a ban punishment for a player. &7&o))"));
        ItemStack item3 = new ItemStack(util.createItemWithLoreAndShort(Material.DIAMOND_BOOTS, 0, "&6Kick Punishments", "&7&o(( &7Click to kick a player. &7&o))"));

        for (int i : Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,12,14,16,17,18,19,20,21,22,23,24,25,26)) {
            mInv.setItem(i, fill);
        }
        mInv.setItem(11, item3);
        mInv.setItem(13, item2);
        mInv.setItem(15, item1);
        return mInv;
    }

    @EventHandler
    public static void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains("&7Punishments")) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem() != null) {
                if (e.getSlot() == 11) {
                    p.openInventory(new KickGui().KickGUIInventory);
                }
                if (e.getSlot() == 13) {
                    p.openInventory(new BanGui().BanGUIInventory);
                }
                if (e.getSlot() == 15) {
                    p.openInventory(new MuteGui().MuteGUIInventory);
                }
            }
        }
    }
}