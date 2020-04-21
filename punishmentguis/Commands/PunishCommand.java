package punishmentguis.punishmentguis.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import punishmentguis.punishmentguis.Guis.MainGui;
import punishmentguis.punishmentguis.Main;
import punishmentguis.punishmentguis.Utils;

public class PunishCommand {

    public static Main main = Main.main;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equals("punish")) {
                if (!sender.hasPermission("punishgui.use")) {
                    sender.sendMessage(Utils.toColor(main.getConfig().getString("no-permission")));
                    return true;
                }
                Player p = (Player) sender;
                Player target = Bukkit.getPlayer(args[0]);
                p.openInventory(new MainGui().MainGUIInventory);

                if (main.playerPunish.containsKey((Player) sender)) {
                    main.playerPunish.remove((Player) sender);
                }
                main.playerPunish.put((Player) sender, target);

                if (args.length >= 1) {
                    if (target != null) {
                        p.sendMessage(Utils.toColor(main.getConfig().getString("invalid-player").replaceAll("\\{player}", target.getName())));
                    }
                }
                if (args.length >= 1) {
                    if (target != null) {
                        p.sendMessage(Utils.toColor(main.getConfig().getString("invalid-player").replaceAll("\\{player}", target.getName())));
                    }
                }
            }
        }
        return false;
    }
}
