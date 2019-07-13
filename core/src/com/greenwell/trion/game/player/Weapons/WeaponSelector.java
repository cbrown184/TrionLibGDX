package com.greenwell.trion.game.player.Weapons;

public class WeaponSelector {

    private MachineGun machineGun = new MachineGun();

    public WeaponSelector(){}

    public Weapon equip(WeaponType weapon){
        return weapon.equals(WeaponType.MACHINEGUN) ? machineGun
                : null;

    }
}
