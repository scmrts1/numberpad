package com.lgcns.tct.compress;

public class StringCompressRun {

    public static void main(String[] args) {  
    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	String inputData = loadData();
    	printInput(inputData);
    	
    	StringCompress compress = new StringCompress();
    	
    	// 1. 문자열 압축하기
    	String result = compress.getCompressStr(inputData);
    	printResult(result);
    	
    }

	private static String loadData() {
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
//    	String inputData = "aabcccccaaa"; 
		
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
    	String inputData = "apple";
		
//    	String inputData = "abc";
		
//		String inputData = "aabcccccaaac";
    	
    	return inputData;
	}

    private static void printInput(String inputData){
    	System.out.println("[입력 문자열]");
    	System.out.println(inputData);
    }
    
    private static void printResult(String result) {
		System.out.println("[출력 문자열]");
		System.out.println(result);
	}
}