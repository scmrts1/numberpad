package com.lgcns.tct.overlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveOverlap {
	
	/**
	 * 문자열 중복 현황
	 *
	 * @param 	inputData  		List<String>	입력 데이터(문자열 목록)
	 * @return  	       		List<String>	문자열 중복 현황
	 */
	public List<String> getOverlapStr(List<String> inputData) {
		
		List<String> result = new ArrayList<String>();
		
		////////////////////////여기부터 코딩 (1) ---------------->

		Map<String, Integer> checkOverlap = new HashMap<String, Integer>();
		for (String input : inputData) {
			if (checkOverlap.containsKey(input)) {
				checkOverlap.put(input, checkOverlap.get(input)+1);
			} else {
				checkOverlap.put(input, 1);
			}
		}

		Set<String> keySet = checkOverlap.keySet();
		for (String key : keySet) {
			if (checkOverlap.get(key) > 1) {
				String overlap = key + "=" + checkOverlap.get(key);
				result.add(overlap);
			}
		}

		///////////////////////////// <-------------- 여기까지 코딩 (1)
		return result;
	}

	/**
	 * 중복이 제거된 문자열
	 *
	 * @param 	inputData  		List<String>		입력 데이터(문자열 목록)
	 * @return  	       		List<String>		중복이 제거된 문자열 목록
	 */
	public List<String> getRemoveOverlapStr( List<String> inputData ) {
		
		List<String> result = new ArrayList<String>();
		
		////////////////////////여기부터 코딩 (2) ---------------->

		Map<String, Integer> checkOverlap = new HashMap<String, Integer>();
		for (String input : inputData) {
			if (checkOverlap.containsKey(input)) {
				checkOverlap.put(input, checkOverlap.get(input)+1);
			} else {
				checkOverlap.put(input, 1);
			}
		}
		
		for (String input : inputData) {
			if (checkOverlap.get(input) == 1) {
				result.add(input);
			} else {
				checkOverlap.put(input, checkOverlap.get(input)-1);
			}
		}

		///////////////////////////// <-------------- 여기까지 코딩 (2)
		return result;
	}
}