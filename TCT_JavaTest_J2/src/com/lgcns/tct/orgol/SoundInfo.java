package com.lgcns.tct.orgol;

import java.util.List;

public class SoundInfo implements Comparable<SoundInfo>{

	String pitch;
	
	int[] sounds;

	List<Integer> orderSounds;
	
	int lastOder;

	public SoundInfo( String pitch, int... sounds ) {
		super();
		this.pitch = pitch;
		this.sounds = sounds;
	}

	public String getPitch() {
		return pitch;
	}

	public void setPitch( String pitch ) {
		this.pitch = pitch;
	}

	public int[] getSounds() {
		return sounds;
	}

	public void setSounds( int[] sounds ) {
		this.sounds = sounds;
	}

	public List<Integer> getOrderSounds() {
		return orderSounds;
	}

	public void setOrderSounds(List<Integer> orderSounds) {
		this.orderSounds = orderSounds;
	}

	public int getLastOder() {
		return lastOder;
	}

	public void setLastOder(int lastOder) {
		this.lastOder = lastOder;
	}

	@Override
	public int compareTo(SoundInfo arg0) {
		if (this.lastOder > arg0.getLastOder()) {
			return 1;
		} else if (this.lastOder < arg0.getLastOder()) {
			return -1;
		} else {
			return 0;
		}		
	}	
	
}