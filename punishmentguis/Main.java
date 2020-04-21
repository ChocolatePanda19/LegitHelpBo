package punishmentguis.punishmentguis;

import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import punishmentguis.punishmentguis.Commands.PunishCommand;
import punishmentguis.punishmentguis.Events.BanEvent;
import punishmentguis.punishmentguis.Events.DragonEggEvent;
import punishmentguis.punishmentguis.Events.KickEvent;
import punishmentguis.punishmentguis.Events.MuteEvent;
import punishmentguis.punishmentguis.Guis.MainGui;

import java.util.Map;

public final class Main extends JavaPlugin implements Listener, CommandExecutor {

    public static Main main;
    public static Map<Player, OfflinePlayer> playerPunish = Maps.newHashMap();
    Map<Player, String> reasonList = Maps.newHashMap();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("Loading PunishGUI!");
        this.getCommand("punish").setExecutor(new PunishCommand());
        this.getServer().getPluginManager().registerEvents(new BanEvent(), this);
        this.getServer().getPluginManager().registerEvents(new DragonEggEvent(), this);
        this.getServer().getPluginManager().registerEvents(new KickEvent(), this);
        this.getServer().getPluginManager().registerEvents(new MuteEvent(), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Unloading PunishGUI!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players are allowed to use this command.");
        }

        if (args.length == 0) {
            sender.sendMessage(Utils.toColor(main.getConfig().getString("Correct-Usage")));
            return true;
        }

        if (cmd.getName().equals("punish")) {
            if (!sender.hasPermission("punishgui.use")) {
                sender.sendMessage(main.getConfig().getString("no-permission"));
                return true;
            }
            Player p = (Player) sender;
            OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
            if (target != null) {
                playerPunish.put((Player) sender, target);
                p.openInventory(new MainGui().MainGUIInventory());
            } else {
                p.sendMessage(Utils.toColor(main.getConfig().getString("invalid-player").replaceAll("\\{player}", target.getName())));
            }
        }
        return false;
    }

    public Map<Player, String> getReasonList() {
        return reasonList;
    }
}
