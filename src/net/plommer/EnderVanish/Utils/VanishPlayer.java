package net.plommer.EnderVanish.Utils;

import java.util.UUID;

public class VanishPlayer {

	private UUID uuid;
	private String name;
	private boolean isVanish;
	
	public VanishPlayer(UUID uuid, String name) {
		setUUID(uuid);
		setName(name);
		setVanish(true);
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
	
	public UUID getUUID() {
		return this.uuid;
	}
	public String getName() {
		return this.name;
	}
	public boolean isVanish() {
		return this.isVanish;
	}
	
}
