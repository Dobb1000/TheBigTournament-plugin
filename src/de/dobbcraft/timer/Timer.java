package de.dobbcraft.timer;

import de.dobbcraft.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean running;
    private int time;
    private boolean on;
    public int min = 0;
    public int hour = 0;
    public int sek = 0;
    public Timer(boolean running, int time, boolean on) {
        this.running = running;
        this.time = time;
        this.on = on;
        run();



    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean ison() {
        return on;
    }

    public void seton(boolean on) {
        this.on = on;
    }

    public void sendActionBar() {

        for (Player player: Bukkit.getOnlinePlayers()) {




                    if (!isRunning()) {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED.toString() + "Timer is pausiert!"));
                        continue;
                    }

                    if (!ison()) {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED.toString() + ""));
                        break;
                    }
                    if (getTime() >= 60) {
                        setTime(getTime() - 60);
                        min += 1;
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + getTime()));


                    }
                    if (min >= 60) {
                        setTime(getTime() - 60);
                        min -= 60;
                        hour += 1;
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + getTime()));


                    }

                    if (min < 0) {
                        min = min * -1;

                    }
                    if (hour < 0) {
                        hour = hour * -1;

                    }
                    if (getTime() < 0) {
                        setTime(getTime() * -1);

                    }
                    if (getTime() != 60) {
                        if (hour >= 1) {
                            if (min <= 9) {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + hour + ":0" + min + ":" + getTime()));
                                if (getTime() <= 9) {
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + hour + ":0" + min + ":0" + getTime()));
                                } else {
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + hour + ":0" + min + ":" + getTime()));
                                }
                            }
                            if (min > 9) {
                                if (getTime() <= 9) {
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + hour + ":" + min + ":0" + getTime()));
                                } else {
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + hour + ":" + min + ":" + getTime()));
                                }
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + hour + ":" + min + ":" + getTime()));
                            }

                        } else {
                            if (getTime() <= 9) {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + min + ":0" + getTime()));
                            } else {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + min + ":" + getTime()));
                            }
                        }


                    }
                }

        }


    private void run() {

            new BukkitRunnable() {



                    @Override

                    public void run () {
                        if (ison()) {
                            sendActionBar();}
                            if (!isRunning()) {
                                return;
                            }
                            if (!ison()) {
                                return;
                            }
                            setTime(getTime() + 1);

                }

            }.runTaskTimer(Main.getInstance(), 20, 20);
        }



}
