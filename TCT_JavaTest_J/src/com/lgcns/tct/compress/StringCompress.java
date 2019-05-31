package com.lgcns.tct.compress;

public class StringCompress {
	
	/**
	 * 요구사항에 부합하는 압축한 문자열
	 *
	 * @param 	inputData  		String			입력 데이터(문자열)
	 * @return  	       		String			요구사항에 따른 압축 결과
	 */
	public String getCompressStr( String inputData ) {
		
		String result = "";
		
		////////////////////////여기부터 코딩 (1) ---------------->

		char currChar = ' ';
		char nextChar = ' ';
		int count=1;
		
		for(int idx=0 ; idx < inputData.length() ; idx++){
			
			currChar = inputData.charAt(idx);
			
			if(idx == (inputData.length()-1)) {
				nextChar = ' ';
			} else {
				nextChar = inputData.charAt(idx+1);
			}
			
			if(currChar == nextChar) {
				count++;
				continue;
			} else {
				result += ( (currChar+"") + ( count+""));
				count=1;
			}
			
		}
		
		if(result.length() > inputData.length()) {
			return inputData;
		}

		///////////////////////////// <-------------- 여기까지 코딩 (1)
		return result;
	}

}
