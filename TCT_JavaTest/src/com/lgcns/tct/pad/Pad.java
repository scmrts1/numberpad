package com.lgcns.tct.pad;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pad {

	/**
	 * 이동문자열을 추출하는 기능
	 *
	 * @param 	inputData   	String			입력데이터(문자열)
	 * @return 					String 			이동문자열
	 */
	public String getRotationStr(String inputData) {
		String rotationStr = "";
		//////////////////////// 여기부터 구현 (1) ---------------->
		System.out.println(inputData);
		
		ArrayList<String> seq = new ArrayList<String>();
		
		for(int i = 0 ; i < inputData.length() ; i++) {
			String str = inputData.substring(i, (i+2));
			i += 1;
			if((str.indexOf('U') != -1 || str.indexOf('D') != -1 || str.indexOf('L') != -1 || str.indexOf('R') != -1) && !str.substring(0, 1).equals("0")) {
				seq.add(str);
				rotationStr += str;
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return rotationStr;
	}

	/**
	 * 숫자패드를 이동시키는 기능
	 *
	 * @param 	inputNumberPad   	int[][]			입력데이터(숫자패드)
	 * @param 	rotationStr   		String			이동문자열
	 * @return 						int[][]			이동된 숫자패드
	 */
	public int[][] getNumberPad(int[][] inputNumberPad, String rotationStr) {
		int[][] numberPad = inputNumberPad;
		//////////////////////// 여기부터 구현 (2) ---------------->
		Pattern pattern = Pattern.compile("([1-9][A-Z])");
		Matcher matcher = pattern.matcher(rotationStr);
		while(matcher.find()) {
			String tmp = matcher.group();
			char[] ct = tmp.toCharArray();
			for(int i = 0 ; i < Integer.parseInt(""+ct[0]) ; i++) {
				switch(ct[1]) {
				case 'L' : 
					numberPad = l(numberPad);
					break;
				case 'R' : 
					numberPad = r(numberPad);
					break;
				case 'D' : 
					numberPad = d(numberPad);
					break;
				case 'U' : 
					numberPad = u(numberPad);
					break;
				
				}
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return numberPad;
	}

	private int[][] u(int[][] inputNumberPad) {
		int[] tmp = inputNumberPad[0];
		
		for ( int i  = 1 ; i < inputNumberPad[0].length ; i++) {
			inputNumberPad[i-1] = inputNumberPad[i];
		}
		inputNumberPad[inputNumberPad[0].length -1] = tmp;
		return inputNumberPad;
	}
	
	private int[][] d(int[][] inputNumberPad) {
		int[] tmp = inputNumberPad[inputNumberPad[0].length -1];
		
		for ( int i  = inputNumberPad[0].length - 1 ; i > 0  ; i--) {
			inputNumberPad[i] = inputNumberPad[i-1];
		}
		inputNumberPad[0] = tmp;
		return inputNumberPad;
	}
	
	private int[][] l(int[][] inputNumberPad) {
		
		for(int i = 0 ; i < inputNumberPad.length ; i++) {
			int tmp = inputNumberPad[i][0];
			
			for(int j = 1 ; j < inputNumberPad[i].length ; j++) {
				inputNumberPad[i][j-1] = inputNumberPad[i][j];
			}
			inputNumberPad[i][inputNumberPad.length - 1] = tmp;
		}
		
		return inputNumberPad;
	}
	
	private int[][] r(int[][] inputNumberPad) {
		
		for(int i = 0 ; i < inputNumberPad.length ; i++) {
			int tmp = inputNumberPad[i][inputNumberPad.length - 1];
			
			for(int j = inputNumberPad[i].length - 1 ; j > 0 ; j--) {
				inputNumberPad[i][j] = inputNumberPad[i][j-1];
			}
			inputNumberPad[i][0] = tmp;
		}
		
		return inputNumberPad;
	}
}