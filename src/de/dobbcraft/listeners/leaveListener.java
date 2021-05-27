package de.dobbcraft.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import java.util.Random;

public class leaveListener implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

        Random wuerfel = new Random();
        int augenZahl;
        int rand_dom = wuerfel.nextInt(3);
        if ( rand_dom == 0) {
            Player player = event.getPlayer();
            event.setQuitMessage("§8<< §c" + player.getName() );
        }
        if (rand_dom == 1) {
            Player player = event.getPlayer();
            event.setQuitMessage("§8<< §a" + player.getName() );
        }
        if (rand_dom == 2) {
            Player player = event.getPlayer();
            event.setQuitMessage("§8<< " + ChatColor.DARK_RED  + player.getName() );
        }
        System.out.println(rand_dom);





    }
}
