package pl.combatargprevent.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.combatargprevent.CombatArgPrevent;
import pl.combatargprevent.data.DataHandler;
import pl.combatargprevent.util.PlayerUtil;

public class Events implements Listener {

    private final CombatArgPrevent plugin = CombatArgPrevent.getInstance();
    private final DataHandler dataHandler = plugin.getDataHandler();

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if(event.isCancelled()) return;
        String givenCmd = event.getMessage();
        String[] givenSplit = givenCmd.split(" ");
        if(givenSplit.length < 1) return;
        if(dataHandler.getCommands().containsKey(givenSplit[0])) {
            String cmd = dataHandler.getCommands().get(givenSplit[0]);
            String[] split = cmd.split(" ");
            for(int i = 0; i < givenSplit.length; i++) {
                if(i >= split.length) return;
                if(split[i].equals("%player%")) {
                    Player p = PlayerUtil.getPlayer(givenSplit[i]);
                    if(p == null) return;
                    if(plugin.getAPI().isInCombat(p)) {
                        event.setCancelled(true);
                        event.getPlayer().sendMessage(dataHandler.getMessage());
                        return;
                    }
                }
            }
        }
    }

}
