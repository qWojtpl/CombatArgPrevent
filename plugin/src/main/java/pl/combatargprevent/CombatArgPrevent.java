package pl.combatargprevent;

import lombok.Getter;
import nl.marido.deluxecombat.api.DeluxeCombatAPI;
import org.bukkit.plugin.java.JavaPlugin;
import pl.combatargprevent.data.DataHandler;
import pl.combatargprevent.events.Events;

@Getter
public final class CombatArgPrevent extends JavaPlugin {

    private static CombatArgPrevent main;
    private final DeluxeCombatAPI API = new DeluxeCombatAPI();
    private DataHandler dataHandler;

    @Override
    public void onEnable() {
        main = this;
        this.dataHandler = new DataHandler();
        dataHandler.loadConfig();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getLogger().info("Loaded.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled");
    }

    public static CombatArgPrevent getInstance() {
        return main;
    }

}
