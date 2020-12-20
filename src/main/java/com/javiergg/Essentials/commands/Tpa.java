package com.javiergg.Essentials.commands;

import com.javiergg.Essentials.Clases.Teleport;
import com.javiergg.Essentials.Principal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Tpa implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player  = (Player) commandSender;
            if (strings.length==1){
                Player destino = Bukkit.getPlayer(strings[0]);
                if (destino!= null){
                    if (player.getUniqueId() != destino.getUniqueId()){
                        boolean tpAnterior = false;
                        ArrayList<Teleport> teleports = Principal.get().tpa;
                        for(int i = 0; i < teleports.size(); i++){
                            if (teleports.get(i).getFrom().getUniqueId() == player.getUniqueId()){
                                tpAnterior = true;
                            }

                        }
                        if (tpAnterior){
                            player.sendMessage(ChatColor.GOLD + "Debes esperar antes de mandar otra solicitud");
                        }else{
                            player.sendMessage(ChatColor.GOLD + "Solicitud Enviada");
                            destino.sendMessage(ChatColor.GOLD + player.getName()+" Quiere Hacerse TP hacia a ti\n" + ChatColor.GREEN + "Usa /tpaccept para aceptar" );
                            Teleport teleport = new Teleport(player,destino);
                            teleports.add(teleport);
                            new BukkitRunnable(){
                                public void run(){
                                    if (teleports.contains(teleport)){
                                        player.sendMessage(ChatColor.GOLD + destino.getName() + "No ha aceptado la solicitud");
                                        destino.sendMessage(ChatColor.GOLD + "TP expirado");
                                        teleports.remove(teleport);
                                    }

                                }
                            }.runTaskLater(Principal.get(), 1000);
                        }


                    }else{
                        player.sendMessage(ChatColor.GOLD + "No puedes hacerte tp a ti mismo");
                    }


                }else{
                    player.sendMessage(ChatColor.GOLD + "El jugador no existe");
                }

            }else{
                player.sendMessage(ChatColor.GOLD + "Debes poner a quien te quieres tepear");
            }
        }
        return false;
    }
}
