package com.javiergg.Essentials.commands;

import com.javiergg.Essentials.Clases.Teleport;
import com.javiergg.Essentials.Principal;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Tpaccept implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            ArrayList<Teleport> teleports = Principal.get().tpa;
            if (strings.length==0){
                for(int i = 0; i < teleports.size(); i++){
                    Teleport teleport = teleports.get(i);
                    if (teleport.getTo().getUniqueId() == player.getUniqueId()){
                        teleport.getFrom().sendMessage(ChatColor.GOLD + "Teletransportando...");
                        player.sendMessage(ChatColor.GOLD + "Teletransporte aceptado");

                        new BukkitRunnable(){
                            public void run(){
                                teleport.getFrom().teleport(player);
                                Principal.get().tpa.remove(teleport);
                            }
                        }.runTaskLater(Principal.get(), 30);

                    }
                }
            }else if (strings.length==1){
                for(int i = 0; i < teleports.size(); i++){
                    Teleport teleport = teleports.get(i);
                    if (teleport.getTo().getUniqueId() == player.getUniqueId() && teleport.getFrom().getName().equals(strings[0])){
                        teleport.getFrom().sendMessage(ChatColor.GOLD + "Teletransportando...");
                        player.sendMessage(ChatColor.GOLD + "Teletransporte aceptado");

                        new BukkitRunnable(){
                            public void run(){
                                teleport.getFrom().teleport(player);
                                Principal.get().tpa.remove(teleport);
                            }
                        }.runTaskLater(Principal.get(), 30);

                    }
                }
            }

        }

        return false;
    }
}
