package xyz.tehbrian.nobedexplosions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tehbrian.nobedexplosions.NoBedExplosions;
import xyz.tehbrian.nobedexplosions.util.MessageUtils;

import java.util.Objects;

public class ReloadCommand implements CommandExecutor {

    private final NoBedExplosions main;

    public ReloadCommand(NoBedExplosions main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        main.reloadConfig();

        String reloadMsg = Objects.requireNonNull(MessageUtils.color(main.getConfig().getString("reload_msg")));
        if (!reloadMsg.isEmpty()) {
            sender.sendMessage(reloadMsg);
        }

        return true;
    }
}
