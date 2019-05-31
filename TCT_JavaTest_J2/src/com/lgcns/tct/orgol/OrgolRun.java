package com.lgcns.tct.orgol;

import java.util.Arrays;
import java.util.List;

public class OrgolRun {

    public static void main(String[] args) {
    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	List<SoundInfo> inputData = loadData();
    	printInput(inputData);
    	
    	Orgol orgol = new Orgol();
    	
    	printResultheader();
    	
    	// 1. 마지막에 연주되는 음 출력
    	String lastSound = orgol.getLastSound(inputData);
    	printLastSound(lastSound);
    	
    	// 2. 연주되는 모든 음을 순서대로 출력
    	List<String> playSound = orgol.getPlaySound(inputData);
    	printLastSound(playSound);
    }

	private static List<SoundInfo> loadData() {
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
//		List<SoundInfo> inputData = Arrays.asList(
//			new SoundInfo("G", 1, 1, 3, 1, 3, 1),
//			new SoundInfo("A", 3, 1),
//			new SoundInfo("E", 7, 4, 1),
//			new SoundInfo("D", 13)
//		);
		
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
    	List<SoundInfo> inputData = Arrays.asList(
	    	new SoundInfo("C", 1, 3, 3, 1, 1, 2, 8),
	    	new SoundInfo("E", 1, 3, 3, 4, 3, 1),
	    	new SoundInfo("G", 1, 3, 4, 8, 2),
	    	new SoundInfo("A", 3, 4, 1, 12),
	    	new SoundInfo("F", 9, 1, 4, 6),
	    	new SoundInfo("D", 5, 4, 2, 7),
	    	new SoundInfo("B", 5, 5, 11)
    	);
    	
    	return inputData;
	}

    private static void printInput(List<SoundInfo> inputData){
    	System.out.println("[입력데이터]");
    	for(SoundInfo s : inputData){
    		System.out.println(s.getPitch() + " - " + Arrays.toString(s.getSounds()));
    	}
    	System.out.println();
    }
    
    private static void printResultheader() {
		System.out.println("[결과]");
	}
    
    private static void printLastSound(String lastSound) {
		System.out.println("마지막 음 : " + lastSound);
	}  
    
    private static void printLastSound(List<String> playSound) {
		System.out.print("연주 : [");
		for(int inx = 0 ; inx < playSound.size() ; inx ++){
			System.out.print(playSound.get(inx));
			if(inx < playSound.size() - 1){
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}