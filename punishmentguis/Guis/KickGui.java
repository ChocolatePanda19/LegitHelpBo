package punishmentguis.punishmentguis.Guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import punishmentguis.punishmentguis.Main;
import punishmentguis.punishmentguis.util.ItemUtils;

import java.util.Arrays;

public class KickGui {

    public Inventory KickGUIInventory;
    private ItemUtils util = new ItemUtils();
    public static Main main = Main.main;

    public void KickGUIInventory(Player p) {
        Player target = (Player) main.playerPunish;
        Inventory kInv = Bukkit.createInventory(null, 27, ("&7Kick Punishments"));
        ItemStack fill = new ItemStack(util.createItemWithLoreAndShort(Material.STAINED_GLASS_PANE, 7, " "));
        ItemStack kick = new ItemStack(util.createItemWithLoreAndShort(Material.DIAMOND_BOOTS, 0, "&6Kick", "&7&o(( &7Click to kick &f" + target.getName()));
        ItemStack back = new ItemStack(util.createItemWithLoreAndShort(Material.BARRIER, 0, "&7«&cReturn", "&7&o(( &7Click to return to the main punishment gui &7&o))"));

        for(int i : Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20,21,23,24,25,26)) {
            kInv.setItem(i, fill);
        }
        kInv.setItem(13, kick);
        kInv.setItem(22, back);

        p.openInventory(kInv);
    }
}