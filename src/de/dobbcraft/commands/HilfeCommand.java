package de.dobbcraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class HilfeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
               for(Player ops : Bukkit.getOnlinePlayers()){
            if(ops.isOp()){
                ops.sendMessage( ChatColor.RED + sender.getName() + ChatColor.GRAY +  " Hat Hilfe angefordert. Schreib ihn an." ); }}


        sender.sendMessage(ChatColor.GRAY + "Du hast Hilfe angefordert, hab gedult und warte bis du von einem Moderator angeschrieben wirst.");
        return false;

    }
}
