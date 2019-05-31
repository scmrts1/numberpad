package com.lgcns.tct.overlap;

import java.util.Arrays;
import java.util.List;

public class RemoveOverlapRun {

    public static void main(String[] args) {
    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	List<String> inputData = loadData();
    	printInput(inputData);
    	
    	RemoveOverlap removeOverlap = new RemoveOverlap();
    	
    	// 1. 문자열 중복 현황 구하기
    	List<String> overlapStr = removeOverlap.getOverlapStr(inputData);
    	printOverlapString(overlapStr);
    	
    	// 2. 중복이 제거된 문자열을 구하기
    	List<String> removeOverlapStr = removeOverlap.getRemoveOverlapStr(inputData);
    	printRemoveOverlapString(removeOverlapStr);
    }

	private static List<String> loadData() {
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
		List<String> inputData = Arrays.asList(
				"AS", "QWER", "ZXV", "HJKL", "YO", "QWER", "VBNM", "FGH", "QWER", "ABCD", "YO", "QWER", "FGH", "YO"
		); 
		
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
//		List<String> inputData = Arrays.asList(
//				"ABC", "ABC", "AB", "YUL", "YUL", "BAK", "KKA", "BAK", "ABC", "CC", "TOP", "CC", "CC", "CC", "DABK", "ABCDEFG", "LOP"
//		);
    	
    	return inputData;
	}

    private static void printInput(List<String> inputData){
    	System.out.println("[입력 문자열]");
    	System.out.println(Arrays.toString(inputData.toArray()));
    	System.out.println("------------------------------------------------------------");
    }
    
	private static void printOverlapString(List<String> overlapStr) {
		System.out.println("[중복 문자열 현황]");
		for(String overlap : overlapStr){
			System.out.println(overlap);
    	}
		System.out.println("------------------------------------------------------------");
	}

	private static void printRemoveOverlapString(List<String> removeOverlapStr) {
		System.out.println("[중복이 제거된 문자열]");
		System.out.println(Arrays.toString(removeOverlapStr.toArray()));
		System.out.println("------------------------------------------------------------");
	}
}