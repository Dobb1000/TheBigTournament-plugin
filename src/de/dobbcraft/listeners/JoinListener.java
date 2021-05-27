package de.dobbcraft.listeners;
import java.io.File;
import java.util.Random;


import de.dobbcraft.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitTask;

public class JoinListener implements Listener {
    private File file = new File("plugins//TBT//config.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        int playercount = Bukkit.getOnlinePlayers().size();
        Player player = event.getPlayer();
        Random wuerfel = new Random();
        int augenZahl;
        int rand_dom = wuerfel.nextInt(3);
        if ( rand_dom == 0) {

            event.setJoinMessage("§8>> §c" + player.getName() );
        }
        if (rand_dom == 1) {
            event.setJoinMessage("§8>> §a" + player.getName() );
        }
        if (rand_dom == 2) {
            event.setJoinMessage("§8>> " + ChatColor.DARK_RED  + player.getName() );
        }








       // new TestScoreboard(player);
    }
}
