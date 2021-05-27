package de.dobbcraft.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class LobbyBoard {
    public int coinCount = 0;
    public int friendCount = 0;

    public void setScoreboard(Player p ) {
        String displayName = p.getDisplayName();
        String none = " ";
        String none2 = " ";
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Stats", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§lTHE BIG§7");

        Team name =  board.registerNewTeam("name");
        Team friends =  board.registerNewTeam("friends");

        obj.getScore("§L     TOURNAMENT").setScore(5);
        obj.getScore("    §l------------").setScore(4);
        obj.getScore("       §lWilkommen:").setScore(3);
        obj.getScore("§d").setScore(2);


        //obj.getScore("§e").setScore(0);
        obj.getScore(none).setScore(1);
        obj.getScore("discord.gg/FuENGZV5").setScore(0);


        name.addEntry("§d");
        name.setPrefix("§e" + displayName);


        friends.addEntry("§e");
        friends.setPrefix("§a" + coinCount);


        p.setScoreboard(board);

    }

    public void updateScoreboard(Player p) {
        String displayName = p.getDisplayName();
        Scoreboard board = p.getScoreboard();
        Team name = board.getTeam("name");
        Team friends = board.getTeam("friends");
        name.setPrefix("§e" + displayName); //p.getDisplayName());
        friends.setPrefix("§a" + friendCount);

    }


}
