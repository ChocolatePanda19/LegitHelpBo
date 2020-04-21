package punishmentguis.punishmentguis.Guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import punishmentguis.punishmentguis.Main;
import punishmentguis.punishmentguis.util.ItemUtils;

import java.util.Arrays;

public class BanGui {

    public Inventory BanGUIInventory;
    private ItemUtils util = new ItemUtils();
    public static Main main = Main.main;

    public void BanGUIInventory(Player p) {
        Player target = (Player) main.playerPunish;
        Inventory bInv = Bukkit.createInventory(null, 27, ("&7Ban Punishments"));
        ItemStack fill = new ItemStack(util.createItemWithLoreAndShort(Material.STAINED_GLASS_PANE, 7, " "));
        ItemStack ban1 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&41 Hour Ban", "&7&o(( &7Click to ban &f" + target.getName()));
        ItemStack ban2 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&45 Hour Ban", "&7&o(( &7Click to ban &f" + target.getName()));
        ItemStack ban3 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&47 Hour Hour Ban", "&7&o(( &7Click to ban &f" + target.getName()));
        ItemStack ban4 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&41 Day Hour Ban", "&7&o(( &7Click to ban &f" + target.getName()));
        ItemStack ban5 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&45 Day Hour Ban", "&7&o(( &7Click to ban &f" + target.getName()));
        ItemStack ban6 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&47 Day Hour Ban", "&7&o(( &7Click to ban &f" + target.getName()));
        ItemStack ban7 = new ItemStack(util.createItemWithLoreAndShort(Material.ANVIL, 0, "&4Permanent Ban", "&7&o(( &7Click to ban &f" + target.getName()));
        ItemStack back = new ItemStack(util.createItemWithLoreAndShort(Material.BARRIER, 0, "&7«&cReturn", "&7&o(( &7Click to return to the main punishment gui &7&o))"));

        for(int i : Arrays.asList(1,2,3,4,5,6,7,8,9,10,17,18,19,20,21,23,24,25,26)) {
            bInv.setItem(i, fill);
        }
        bInv.setItem(11, ban1);
        bInv.setItem(12, ban2);
        bInv.setItem(13, ban3);
        bInv.setItem(14, ban4);
        bInv.setItem(15, ban5);
        bInv.setItem(16, ban6);
        bInv.setItem(17, ban7);
        bInv.setItem(22, back);

        p.openInventory(bInv);
    }
}