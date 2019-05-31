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

		StringBuilder sb = new StringBuilder();
		inputData = inputData.toLowerCase();
		char exChar = inputData.charAt(0);
		int count = 1;
		for (int inx=1; inx<inputData.length(); inx++) {
			char ch = inputData.charAt(inx);
			if (exChar == ch) {
				count++;
			} else {
				sb.append(exChar).append(count);
				exChar = ch;
				count = 1;
			}
		}

		sb.append(exChar).append(count);
		result = sb.toString();
		if (result.length() > inputData.length()) {
			return inputData;
		}

		///////////////////////////// <-------------- 여기까지 코딩 (1)
		return result;
	}

}
