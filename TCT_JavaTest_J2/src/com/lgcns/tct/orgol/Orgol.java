package com.lgcns.tct.orgol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orgol {
	
	/**
	 * 마지막에 연주되는 음을 출력하는 기능 
	 *
	 * @param 	inputData  		List<SoundInfo>		입력 데이터(음별 돌기정보)
	 * @return  	       		String				마지막 음
	 */
	public String getLastSound( List<SoundInfo> soundData ) {
		
		String result = "";
		
		////////////////////////여기부터 코딩 (1) ---------------->

		for(SoundInfo soundVo : soundData) {
			int[] sounds = soundVo.getSounds();
			int last = 0;
			for (int sound : sounds) {
				last += sound;
			}
			soundVo.setLastOder(last);
		}
		
		List<SoundInfo> cloneSoundData = new ArrayList<SoundInfo>();
		cloneSoundData.addAll(soundData);
		
		Collections.sort(cloneSoundData);
		result = cloneSoundData.get(cloneSoundData.size()-1).getPitch();
		
		///////////////////////////// <-------------- 여기까지 코딩 (1)
		
		return result;
	}

	/**
	 * 연주되는 순서대로 음을 모두 출력하는 기능
	 *
	 * @param 	soundData  		List<SoundInfo>		입력 데이터(음별 정보 목록)
	 * @return  	       		List<String>		연주되는 모든 음의 목록
	 */
	public List<String> getPlaySound( List<SoundInfo> soundData ) {
		
		List<String> result = new ArrayList<String>();
		
		////////////////////////여기부터 코딩 (2) ---------------->

		int maxOrder = 0;
		for(SoundInfo soundVo : soundData) {
			int[] sounds = soundVo.getSounds();
			List<Integer> orderSoundList = new ArrayList<Integer>();
			int last = 0;
			for (int inx=0; inx<sounds.length; inx++) {
				last += sounds[inx];
				orderSoundList.add(last);
			}
			if (maxOrder < last) {
				maxOrder = last;
			}
			soundVo.setOrderSounds(orderSoundList);
		}

		List<SoundInfo> cloneSoundData = new ArrayList<SoundInfo>();
		cloneSoundData.addAll(soundData);
		
		OrgolComparator comparator = new OrgolComparator();
		Collections.sort(cloneSoundData, comparator);
		
		for (int inx=1; inx<maxOrder+1; inx++) {
			String sound = "";
			for(SoundInfo soundVo : cloneSoundData) {
				if (soundVo.getOrderSounds().contains(inx)) {
					sound = sound + soundVo.getPitch();
				}
			}
			if (sound != "") {
				result.add(sound);
			}
		}

		///////////////////////////// <-------------- 여기까지 코딩 (2)
		
		return result;
	}
}