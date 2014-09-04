package net.plommer.EnderVanish.Utils;

import java.util.UUID;

public class VanishPlayer {

	private UUID uuid;
	private String name;
	private boolean isVanish, block, silentChest, potions, godMode, bow, joinVanish;
	
	public VanishPlayer(UUID uuid, String name, boolean block, boolean silentChest, boolean potions, boolean godMode, boolean bow, boolean joinVanish) {
		setUUID(uuid);
		setName(name);
		setVanish(false);
		setBlock(block);
		setSilentChest(silentChest);
		setPotion(potions);
		setGodMode(godMode);
		setBow(bow);
		setJoinVanish(joinVanish);
	}
	
	public VanishPlayer(UUID uuid, String name, boolean vanish) {
		setUUID(uuid);
		setName(name);
		setVanish(vanish);
	}
	
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVanish(boolean vanish) {
		this.isVanish = vanish;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public void setSilentChest(boolean silentChest) {
		this.silentChest = silentChest;
	}
	public void setPotion(boolean potions) {
		this.potions = potions;
	}
	public void setGodMode(boolean godMode) {
		this.godMode = godMode;
	}
	public void setBow(boolean bow) {
		this.bow = bow;
	}
	public void setJoinVanish(boolean joinVanish) {
		this.joinVanish = joinVanish;
	}
	 
	public UUID getUUID() {
		return this.uuid;
	}
	public String getName() {
		return this.name;
	}
	public boolean isVanish() {
		return this.isVanish;
	}
	public boolean getBlock() {
		return this.block;
	}
	public boolean getSilentChest() {
		return this.silentChest;
	}
	public boolean getPotion() {
		return this.potions;
	}
	public boolean getGodMode() {
		return this.godMode;
	}
	public boolean getBow() {
		return this.bow;
	}
	public boolean getJoinVanish() {
		return this.joinVanish;
	}
	
}
