package de.dobbcraft.commands;

import de.dobbcraft.main.Main;
import de.dobbcraft.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sendUsage(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "resume": {
                Timer timer = Main.getInstance().getTimer();

                if (timer.isRunning()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer läuft bereits.");
                    break;
                }

                timer.setRunning(true);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestartet.");
                break;
            }
            case "pause": {
                Timer timer = Main.getInstance().getTimer();

                if (!timer.isRunning()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer läuft nicht.");
                    break;
                }

                timer.setRunning(false);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestoppt.");
                break;
            }
            case "time": {
                if(args.length != 2) {
                    sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                            "/timer time <Zeit>");
                    return true;
                }

                try {
                    Timer timer = Main.getInstance().getTimer();

                    timer.setRunning(false);
                    timer.setTime(Integer.parseInt(args[1]));
                    sender.sendMessage(ChatColor.GRAY + "Die Zeit wurde auf " + args[1] + " gesetzt.");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Dein Parameter 2 muss eine Zahl sein.");
                }
                break;
            }
            case "reset": {
                Timer timer = Main.getInstance().getTimer();

                timer.setRunning(false);
                timer.setTime(0);
                timer.min = 0;
                timer.hour = 0;
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde zurückgesetzt.");
                break;
            }
            case "add": {
                if(args.length != 2) {
                    sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                            "/timer add <Zeit>");
                    return true;
                }

                try {
                    Timer timer = Main.getInstance().getTimer();

                    timer.setTime(timer.getTime() + Integer.parseInt(args[1]) - 1);
                    sender.sendMessage(ChatColor.GRAY + "Die Zeit wurde auf " + args[1] + " gesetzt.");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Dein Parameter 2 muss eine Zahl sein.");
                }
                break;
            }
            case "remove": {
                if(args.length != 2) {
                    sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                            "/timer remove <Zeit>");
                    return true;
                }

                try {
                    Timer timer = Main.getInstance().getTimer();

                    timer.setTime(timer.getTime() - Integer.parseInt(args[1]) - 1);
                    sender.sendMessage(ChatColor.GRAY + "Die Zeit wurde auf " + args[1] + " gesetzt.");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Dein Parameter 2 muss eine Zahl sein.");
                }
                break;
            }
            case "on": {
                Timer timer = Main.getInstance().getTimer();

                if (timer.ison()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer ist schon angeschaltet.");
                    break;
                }

                timer.seton(true);
                sender.sendMessage(ChatColor.GRAY + "Der Timer ist nun angeschaltet." + timer.ison());
                break;

            }
            case "off": {
                Timer timer = Main.getInstance().getTimer();

                if (!timer.ison()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer ist schon ausgeschaltet.");
                    break;
                }

                timer.seton(false);
                sender.sendMessage(ChatColor.GRAY + "Der Timer ist nun ausgeschaltet." + timer.ison());
                break;
            }

            default:
                sendUsage(sender);
                break;
        }
        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                "/timer resume, /timer pause, /timer time <Zeit>, /timer reset, /timer add, /timer remove");
    }
}