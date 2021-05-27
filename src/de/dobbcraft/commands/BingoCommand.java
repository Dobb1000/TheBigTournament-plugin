package de.dobbcraft.commands;

import de.dobbcraft.main.Main;
import de.dobbcraft.timer.Timer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class BingoCommand implements CommandExecutor {
    public boolean start = false;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (start) {
         List<String> terms = new ArrayList<String>();
         if(args.length == 0) {
             if (!sender.isOp()) {
                 sender.sendMessage(ChatColor.GRAY + "Du hast Bingo gerufen! Deine Anfrage wird gerade verabeitet bitte hab gedult und behalte alle deine Bingo Items im Inventar.");
                 sender.sendMessage(terms.toString());
             } else {
                 sender.sendMessage(ChatColor.GRAY + "Du kannst nicht Bingo rufen da du nur zuschauer bist.");
                 return false;

             }
             for (Player ops : Bukkit.getOnlinePlayers()) {
                 if (ops.isOp()) {
                     ops.sendMessage(ChatColor.RED + sender.getName() + ChatColor.GRAY + " hat gerade Bingo gerufen! mit /Bingowinner <Playername> kannst du es akzeptieren.");
                     System.out.println(ChatColor.RED + sender.getName() + ChatColor.GRAY + " hat gerade Bingo gerufen! mit /Bingowinner <Playername> kannst du es akzeptieren.");
                 }
             }
             return false;

         }
        }
        if (sender.isOp()) {
            switch (args[0].toLowerCase()) {
                case "win": {
                    if (start) {
                        Player player = Bukkit.getServer().getPlayer(args[1]);
                        if (player != null) {


                            Timer timer = Main.getInstance().getTimer();
                            timer.setRunning(false);
                            timer.setTime(0);
                            timer.min = 0;
                            timer.hour = 0;
                            sender.sendMessage(ChatColor.GRAY + args[1] + " hat gewonnen!");
                            Player player1 = (Player) sender;
                            player1.sendTitle(ChatColor.GOLD + "§l" + args[1], "Hat gewonnen!", 2, 20, 2);
                            start = false;
                            return false;

                        } else {
                            sender.sendMessage(ChatColor.GRAY + "Der Spieler ist nicht auf der liste!.");
                        }
                    }
                    break;

                }
                case "start": {
                    if (start) {
                        sender.sendMessage(ChatColor.RED + "Bingo ist schon gestartet");
                        return false;
                    }
                    start = true;
                    for (Player player: Bukkit.getOnlinePlayers()) {
                        player.sendMessage("Bingo wurdse ");
                    }
                    }
                default:




                    break;


                }


                    }









 if (!start) {
            sender.sendMessage(ChatColor.RED + "Bingo ist nocht nicht gestartet");

        }
        return false;
    }

}

