package pl.combatargprevent.data;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.combatargprevent.CombatArgPrevent;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Getter
public class DataHandler {

    private final CombatArgPrevent plugin = CombatArgPrevent.getInstance();
    private final HashMap<String, String> commands = new HashMap<>();
    private String message;

    public void loadConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if(!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(configFile);
        commands.clear();
        List<String> cmds = yml.getStringList("commands");
        for(String cmd : cmds) {
            String[] split = cmd.split(" ");
            if(split.length < 1) continue;
            boolean found = false;
            for(String s : split) {
                if(s.contains("%player%")) {
                    found = true;
                }
            }
            if(!found) continue;
            commands.put(split[0], cmd);
        }
        message = yml.getString("message", "You can't send this command. This player is in combat.")
                .replace("&", "§");
    }

}
