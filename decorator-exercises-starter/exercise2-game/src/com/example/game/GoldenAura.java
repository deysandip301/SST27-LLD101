package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character character) {
        super(character);
    }

    @Override
    public void move() {
        System.out.println("[Golden Aura Active]");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[Golden Aura Active]");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + 2; // small buff
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 2; // small buff
    }

    @Override
    public String getSprite() {
        return "golden-" + super.getSprite();
    }
}
