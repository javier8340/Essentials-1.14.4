package com.javiergg.Essentials;

import com.javiergg.Essentials.Clases.Teleport;
import com.javiergg.Essentials.commands.Tpa;
import com.javiergg.Essentials.commands.Tpaccept;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Principal extends JavaPlugin {

    private static Principal plugin  = null;
    public static Principal get(){
        return plugin;
    }

    public ArrayList<Teleport> tpa = new ArrayList<Teleport>();

    @Override
    public void onEnable(){

        Principal.plugin = this;
//        registerConfig();
        registerCommands();
//        registerConfig();
//        registerEvents();


//        FileConfiguration file = getConfig();
//        conexion = new DatosArchivo(file);


    }


    public void registerCommands(){

        this.getCommand("tpa").setExecutor(new Tpa());
        this.getCommand("tpaccept").setExecutor(new Tpaccept());
//        this.getCommand("recarga").setExecutor(new reload());
    }

}
