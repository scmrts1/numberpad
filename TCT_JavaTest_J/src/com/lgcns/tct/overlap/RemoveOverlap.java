package com.lgcns.tct.overlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
		List<String> uniqList = new ArrayList<String>();
		
		
		for (String tempString : inputData) {
			if(uniqList.contains(tempString)){
				continue;
			} else {
				uniqList.add(tempString);
			}
		}
		
		for (String tempUniq : uniqList) {
			
			int tempCount = 0;
			
			for( String tempString2 : inputData) {
				if(tempUniq.equals(tempString2)) {
					tempCount++;
				} else {
					
				}
			}
			
			result.add(tempUniq + "=" + tempCount);
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
		
		
		// uniq list를 구한다.
		List<String> uniqList = new ArrayList<String>();
		
		for (String tempString : inputData) {
			if(uniqList.contains(tempString)){
				continue;
			} else {
				uniqList.add(tempString);
			}
		}
		//System.out.println("uniqList==>" + uniqList);
		
		// count map을 구한다.
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		
		for (String tempUniq : uniqList) {
			
			int tempCount = 0;
			
			for( String tempString2 : inputData) {
				if(tempUniq.equals(tempString2)) {
					tempCount++;
				} else {
					
				}
			}
			countMap.put(tempUniq, tempCount);
		}
		
		//System.out.println("countMap==> \n" + countMap);
		
		// 갯수 -1 만큼 삭제한다.
		List<String> tempList = new ArrayList<String>();
		tempList.addAll(inputData);
		
		//System.out.println("inputData==>" + inputData);
		//System.out.println("tempList==>" + tempList);
		
		for (String tempUniq : uniqList) {
			
			int containCount = countMap.get(tempUniq);
			if(containCount == 1) {
				continue;
			} else {
				System.out.print("tempList traverse start - tempList.size() ==>"+tempList.size()+"\n");
				int occurCount=0;
				for (int idx = tempList.size()-1 ; idx >-1 ; idx--) {
					String occurString = tempList.get(idx);
					//System.out.println("idx:" + idx + ", " +occurString + ", ");
					
					if(tempUniq.equalsIgnoreCase(occurString)){
						occurCount++;
						if(occurCount != 1) {
							tempList.remove(idx);
						} 
					}
					
					
				}
				//System.out.print("\ntempList traverse end ==>\n");
			}
			
		}		
		
		// result에 assign한다.
		//System.out.print("\nResult ==>"+tempList+"\n");
		result = tempList;
		///////////////////////////// <-------------- 여기까지 코딩 (2)
		return result;
	}
}