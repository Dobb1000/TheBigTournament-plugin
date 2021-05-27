package de.dobbcraft.main;
import de.dobbcraft.Scoreboard.BingoBoard;
import de.dobbcraft.Scoreboard.LobbyBoard;
import de.dobbcraft.Scoreboard.UHCBoard;
import de.dobbcraft.TabCompeleter.BingoTab;
import de.dobbcraft.TabCompeleter.TimerTab;
import de.dobbcraft.commands.*;
import de.dobbcraft.listeners.JoinListener;
import de.dobbcraft.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    private static Main instance;
    private Timer timer;
    public LobbyBoard lobbyBoard = new LobbyBoard();
    public UHCBoard uhcboard = new UHCBoard();
    public BingoBoard bingoBoard = new BingoBoard();
    //private ScoreboardCompleter scoreboardCompleter;

    private File file = new File("plugins//TBT//config.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getLogger().info("TBT plugin loaded!");


        //new Config();
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(),this);
        //Command
        getCommand("test").setExecutor(new Testcommand());
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("Bingo").setExecutor(new BingoCommand());
        getCommand("Hilfe").setExecutor(new HilfeCommand());
        //TAB
        getCommand("timer").setTabCompleter(new TimerTab());
        getCommand("Bingo").setTabCompleter(new BingoTab());
        timer = new Timer(false, 0, false);

        if (!file.exists()) {
            yamlConfiguration.set("Board", "Lobby");
            getLogger().info("Cant find Config, creating one...");
        }

        try {
            yamlConfiguration.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String boardstring = yamlConfiguration.getString("Board");
        getLogger().info(boardstring);

        //scoreboardCompleter = new ScoreboardCompleter(true, false, false);



    }
    @Override
    public void onDisable() {
        getLogger().info("TBT plugin unloaded!");
    }


    public static Main getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }



    //public ScoreboardCompleter getScoreboardCompleter() {
        //return scoreboardCompleter;
    //}

}