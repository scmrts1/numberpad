package com.lgcns.tct.orgol;

public class SoundInfo {

	String pitch;
	
	int[] sounds;

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
}