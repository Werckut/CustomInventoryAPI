package ru.werckut.custominventoryapi;

import org.bukkit.plugin.java.JavaPlugin;
import ru.werckut.custominventoryapi.listener.CustomInventoryListener;

public final class CustomInventoryAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CustomInventoryListener(this), this);
    }
}
