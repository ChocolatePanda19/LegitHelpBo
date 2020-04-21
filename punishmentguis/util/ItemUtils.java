package punishmentguis.punishmentguis.util;


import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import punishmentguis.punishmentguis.Utils;
import java.util.List;

public class ItemUtils {



    public ItemStack createItemWithLoreAndShort(Material m, int setShort,String itemName, String... lore){
        ItemStack itemStack = new ItemStack(m, 1 , (short)setShort);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Utils.toColor(itemName));
        List<String> l = Lists.newArrayList();
        for (String lo : lore) {
            lo = Utils.toColor(lo);
            l.add(lo);
        }
        itemMeta.setLore(l);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
