package me.reratos.sqlplugintest;

import me.reratos.sqlplugintest.dao.PlayerDAO;
import me.reratos.sqlplugintest.model.PlayerModel;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class SQLPluginTest extends JavaPlugin {

    public static Server server = Bukkit.getServer();

    @Override
    public void onEnable() {
        PlayerDAO pdao = new PlayerDAO();
        PlayerModel player = new PlayerModel();

        player.setName("Player Teste 1");
        player.setUuid(new UUID(33, 78));
        pdao.persist(player);

        player = null;
        player = pdao.find(1);

        server.getConsoleSender().sendMessage("Player: " + player.getName());
        server.getConsoleSender().sendMessage("UUID..: " + player.getUuid());
    }
}
