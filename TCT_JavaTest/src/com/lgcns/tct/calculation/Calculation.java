package com.lgcns.tct.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Calculation {
	
	
	/**
	 * 세 수를 만들어서 큰 순서로 정렬하는 기능
	 *
     * @param		inputData		String			입력데이터(숫자열)
     * @return						List			정렬된 숫자열 목록
	 */
	public List<String> sortNumbers(String inputData) {
		List<String> sortedNumbers = new ArrayList<String>();
		
		////////////////////////여기부터 구현 (1) ---------------->
//		if(inputData.length() == 7)
//			inputData += "12";
//		else if(inputData.length() == 8)
//			inputData += "1";
		int last = inputData.length();
		int first = last - 3;
		for(int i = 0 ;i < 3 ; i++) {
			if(first < 0) first = 0;
			String tmp = inputData.substring(first, last);
			if(tmp.length() == 1) tmp +="12";
			if(tmp.length() == 2) tmp +="1";
			sortedNumbers.add(tmp);
			first -= 3;
			last -= 3;
			
		}
		
		sortedNumbers.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int i1 = Integer.parseInt(o1);
				int i2 = Integer.parseInt(o2);
				return i2 - i1;
			}
		});
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return sortedNumbers;
	}
	
	/**
	 * 세 수를 이용하여 새로운 수를 생성하는 기능
	 *
     * @param		sortedNumbers	List			정렬된 숫자열 목록
     * @return						int				생성된 숫자
	 */
	public int generateNumber(List<String> sortedNumbers) {
		int generatedNumber = 0;
		////////////////////////여기부터 구현 (2) ---------------->
		
		char[] i0 = sortedNumbers.get(0).toCharArray();
		char[] i1 = sortedNumbers.get(1).toCharArray();
		char[] i2 = sortedNumbers.get(2).toCharArray();
		
		int s0 = Integer.parseInt(""+i0[0]) + Integer.parseInt(""+i1[0]) + Integer.parseInt(""+i2[0]);
		
		if(s0 >= 10) {
			s0 -= 10;
		} 
		s0 *= 100;
		
		int s1 = Integer.parseInt(""+i0[1]) + Integer.parseInt(""+i1[1]) + Integer.parseInt(""+i2[1]);
		if(s1 >= 10) {
			s1 -= 10;
		} 
		s1 *= 10;
		int s2 = Integer.parseInt(""+i0[2]) + Integer.parseInt(""+i1[2]) + Integer.parseInt(""+i2[2]);
		if(s2 >= 10) {
			s2 -= 10;
		} 
			
		generatedNumber = s1 + s2+ s0;	
		
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return generatedNumber;
	}
	
}