package com.lgcns.tct.humidifier;

import java.util.List;

public class CalcHumidifier {
	
	/**
	 * 총 가습 시간을 계산하는 기능
	 *
	 * @param 	inputData  		List<String>		시뮬레이션 가습구간 정보
	 * @return  	       		int					총 가습 시간 계산 결과
	 */
	public int getTotalTime( List<String> inputData ) {
		
		int result = 0;
		
		////////////////////////여기부터 코딩 (1) ---------------->
		
		int totalMin = 0;
		for (String input : inputData) {
			String strMin = input.substring(1);
			int min = Integer.valueOf(strMin);
			totalMin += min;
		}		
		result = totalMin;

		///////////////////////////// <-------------- 여기까지 코딩 (1)
		return result;
	}

	/**
	 * 시뮬레이션 총 가습량 계산하기
	 *
	 * @param 	inputData  		List<String>		시뮬레이션 가습구간 정보
	 * @param  	ccInfo     		List<Integer>		구간별 시간당 가습량 정보 (저습도, 중습도, 고습도 순)
	 * @return  				int					총 가습량 계산 결과
	 */
	public int getTotalAmount( List<String> inputData, List<Integer> ccInfo ) {
		
		int result = 0;
		
		////////////////////////여기부터 코딩 (2) ---------------->

		int subTotalL = 0;
		int subTotalM = 0;
		int subTotalH = 0;
		for (String input : inputData) {
			char mode = input.charAt(0);
			String strMin = input.substring(1);
			int min = Integer.valueOf(strMin);
			if (mode == 'L') {
				subTotalL +=  min;
			} else if (mode == 'M') {
				subTotalM +=  min;
			} else if (mode == 'H') {
				subTotalH +=  min;
			} else {
				// nothing
			}			
		}
		
		int hourL = (int) (subTotalL / 60);
		int hourM = (int) (subTotalM / 60);
		int hourH = (int) (subTotalH / 60);
		
		int totalAmount = 0;
		totalAmount += ccInfo.get(0) * hourL;
		totalAmount += ccInfo.get(1) * hourM;
		totalAmount += ccInfo.get(2) * hourH;

		result = totalAmount;

		///////////////////////////// <-------------- 여기까지 코딩 (2)

		return result;
	}
}