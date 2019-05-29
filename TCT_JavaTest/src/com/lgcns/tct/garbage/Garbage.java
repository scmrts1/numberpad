package com.lgcns.tct.garbage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Garbage {
	
	/**
	 * 가장 많이 수거된 재활용품의 종류 검색 기능
	 *
	 * @param 	inputData   	String			입력데이터(재활용품과 일반쓰레기 정보를 담고 있는 정보)
	 * @return 					List			가장 많이 수거된 재활용품 (P:플라스틱, B:비닐, S:스티로폼, W:종이)
	 */
	public List<Character> getNameList(String inputData) {
		List<Character> nameList = new ArrayList<Character>();;
		//////////////////////// 여기부터 구현 (1) ---------------->
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i < inputData.length() / 2 ; i++) {
			list.add(inputData.substring(i * 2, (i+1)*(2)));
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		list.stream().forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				char[] tmp = t.toCharArray();
				Integer integer = map.get(tmp[1]);
				if(integer == null) integer = 0;
				map.put(tmp[1], integer + Integer.parseInt(""+tmp[0]));
			}
			
		});
		
		Map<Character, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		Set<Entry<Character, Integer>> entrySet = result.entrySet();
		Integer value = entrySet.iterator().next().getValue();
		Iterator<Entry<Character, Integer>> iterator = entrySet.iterator();
		
		for( ; iterator.hasNext() ; ) {
			Entry<Character, Integer> next = iterator.next();
			if(value == next.getValue()) {
				nameList.add(next.getKey());
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return nameList;
	}

	/**
	 * 재활용품의 백분율 계산 기능
	 *
	 * @param 	inputData   	String			입력데이터(재활용품과 일반쓰레기 정보를 담고 있는 정보)
	 * @return 					int				재활용품의 백분율
	 */
	public int getRatio(String inputData) {
		int ratio = 0;
		//////////////////////// 여기부터 구현 (2) ---------------->		
		
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i < inputData.length() / 2 ; i++) {
			list.add(inputData.substring(i * 2, (i+1)*(2)));
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		list.stream().forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				char[] tmp = t.toCharArray();
				Integer integer = map.get(tmp[1]);
				if(integer == null) integer = 0;
				map.put(tmp[1], integer + Integer.parseInt(""+tmp[0]));
			}
			
		});
		
		Integer g = map.get('G');
		
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Character, Integer>> iterator = entrySet.iterator();
		int sum = 0;
		for( ; iterator.hasNext() ; ) {
			Entry<Character, Integer> next = iterator.next();
			sum += next.getValue();
		}
		
		ratio = ((sum-g) * 100) / sum;
		
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return ratio;
	}

}