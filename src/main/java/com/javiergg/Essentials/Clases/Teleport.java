package com.javiergg.Essentials.Clases;

import org.bukkit.entity.Player;

public class Teleport {

    private Player from;
    private Player to;

    public Teleport(Player from, Player to) {
        this.from = from;
        this.to = to;
    }

    public Player getFrom() {
        return from;
    }

    public void setFrom(Player from) {
        this.from = from;
    }

    public Player getTo() {
        return to;
    }

    public void setTo(Player to) {
        this.to = to;
    }



}
