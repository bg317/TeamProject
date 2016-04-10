package dragonspiretournament.GameObjects;

import dragonspiretournament.GameObjects.Dragons.Dragon;

public class Player {

    private String name;
    private Army army;
    private Dice dice;
    private int strongholdHP;
    private int lastDamage;
    private Dragon lastDragon;

    private static final int MAX_HP = 20;//

    public Player(String playerName) {
        name = playerName;
        army = null;
        dice = new Dice();
        strongholdHP = MAX_HP;
        lastDamage = (Integer) null;
        lastDragon = null;
    }

    
}
