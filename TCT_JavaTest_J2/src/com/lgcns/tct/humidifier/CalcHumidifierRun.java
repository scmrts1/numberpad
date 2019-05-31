package com.lgcns.tct.humidifier;

import java.util.Arrays;
import java.util.List;

public class CalcHumidifierRun {

    public static void main(String[] args) {
    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	List<String> inputData = loadInputData();
    	List<Integer> ccInfo = loadCcInfoData();
    	
    	printInput(inputData, ccInfo);
    	
    	CalcHumidifier calcHumidifier = new CalcHumidifier();
    	
    	// 1. 총 가습 시간
    	int totalTime = calcHumidifier.getTotalTime(inputData);
    	printTotalTime(totalTime);
    	
    	// 2. 총 가습량
    	int totalAcmount = calcHumidifier.getTotalAmount(inputData, ccInfo);
    	printTotalAcmount(totalAcmount);
    }

	private static List<String> loadInputData() {
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
		List<String> inputData = Arrays.asList(
				"L180", "M70", "H20", "M50", "H40"
		); 
		
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
		/*List<String> inputData = Arrays.asList(
				"H20", "L80", "M120", "L100", "H80", "H20"
		); */
    	
    	return inputData;
	}
	
	private static List<Integer> loadCcInfoData() {
		
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
		
		List<Integer> ccInfo = Arrays.asList(
				350, 200, 50
		); 
		
		
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
		
		/*List<Integer> ccInfo = Arrays.asList(
				200, 100, 50
		); */
		
		return ccInfo;
	}

	private static void printInput(List<String> inputData, List<Integer> ccInfo) {
		System.out.println("[초기 입력 데이터]");
		System.out.println("습도 구간 정보: " + Arrays.toString(inputData.toArray()));
		System.out.println("구간별 가습량: " + Arrays.toString(ccInfo.toArray()));
		System.out.println();
	}

	private static void printTotalTime(int totalTime) {
		System.out.println("[총 가습 시간]");
		System.out.println(totalTime + "분");
		System.out.println();
	}
	
	private static void printTotalAcmount(int totalAcmount) {
		System.out.println("[총 가습량]");
		System.out.println(totalAcmount + "cc");
	}
	
}

