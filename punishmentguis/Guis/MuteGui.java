package punishmentguis.punishmentguis.Guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import punishmentguis.punishmentguis.Main;
import punishmentguis.punishmentguis.util.ItemUtils;

import java.util.Arrays;

public class MuteGui implements Listener {

    public Inventory MuteGUIInventory;
    private ItemUtils util = new ItemUtils();
    public static Main main = Main.main;

    public void MuteGUIInventory(Player p) {
        Player target = (Player) main.playerPunish;
        Inventory muInv = Bukkit.createInventory(null, 27, ("&7Mute Punishments"));
        ItemStack fill = new ItemStack(util.createItemWithLoreAndShort(Material.STAINED_GLASS_PANE, 7, " "));
        ItemStack mute1 = new ItemStack(util.createItemWithLoreAndShort(Material.EYE_OF_ENDER, 0, "&c15 Minute Mute", "&7&o(( &7Click to mute &f" + target.getName()));
        ItemStack mute2 = new ItemStack(util.createItemWithLoreAndShort(Material.EYE_OF_ENDER, 0, "&c30 Minute Mute", "&7&o(( &7Click to mute &f" + target.getName()));
        ItemStack mute3 = new ItemStack(util.createItemWithLoreAndShort(Material.EYE_OF_ENDER, 0, "&c1 Hour Mute", "&7&o(( &7Click to mute &f" + target.getName()));
        ItemStack mute4 = new ItemStack(util.createItemWithLoreAndShort(Material.EYE_OF_ENDER, 0, "&c2 Hour Mute", "&7&o(( &7Click to mute &f" + target.getName()));
        ItemStack mute5 = new ItemStack(util.createItemWithLoreAndShort(Material.EYE_OF_ENDER, 0, "&cPermanent Mute", "&7&o(( &7Click to mute &f" + target.getName()));
        ItemStack back = new ItemStack(util.createItemWithLoreAndShort(Material.BARRIER, 0, "&7«&cReturn", "&7&o(( &7Click to return to the main punishment gui &7&o))"));

        for(int i : Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,15,16,17,18,19,20,21,23,24,25,26)) {
            muInv.setItem(i, fill);
        }
        muInv.setItem(11, mute1);
        muInv.setItem(12, mute2);
        muInv.setItem(13, mute3);
        muInv.setItem(14, mute4);
        muInv.setItem(15, mute5);
        muInv.setItem(22, back);

        p.openInventory(muInv);
    }
}