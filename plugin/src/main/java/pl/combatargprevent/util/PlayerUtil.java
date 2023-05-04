package pl.combatargprevent.util;

import org.bukkit.entity.Player;
import pl.combatargprevent.CombatArgPrevent;

import javax.annotation.Nullable;

public class PlayerUtil {

    @Nullable
    public static Player getPlayer(String name) {
        for(Player p : CombatArgPrevent.getInstance().getServer().getOnlinePlayers()) {
            if(p.getName().equals(name)) return p;
        }
        return null;
    }

}
