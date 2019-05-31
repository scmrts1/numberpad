package com.lgcns.tct.orgol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		
//		Stream<String[]> sorted = soundData.stream().map(o -> new String[] {o.getPitch(), ""+o.getSounds().length}).sorted(new Comparator<String[]>() {
//
//			@Override
//			public int compare(String[] o1, String[] o2) {
//				
//				return o2[1].compareTo(o1[1]);
//			}
//		});
//		String[] array = sorted.toArray(String[]::new);
		
		
		
		String[] strings = soundData.stream().map(o -> new String[] {o.getPitch(), ""+IntStream.of(o.getSounds()).sum()}).max(new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return o1[1].compareTo(o2[1]);
			}
		}).get();
		///////////////////////////// <-------------- 여기까지 코딩 (1)
		result = strings[0];
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
		
		for(SoundInfo info : soundData) {
			
		}
		
		///////////////////////////// <-------------- 여기까지 코딩 (2)
		
		return result;
	}
	
}

