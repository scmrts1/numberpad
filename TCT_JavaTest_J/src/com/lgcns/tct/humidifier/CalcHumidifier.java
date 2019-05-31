package com.lgcns.tct.humidifier;

import java.util.HashMap;
import java.util.Iterator;
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
		for (String humidTime : inputData) {
			int tempTime = Integer.parseInt(humidTime.substring(1));
			result += tempTime;
			
			System.out.println(String.format("tempTime = %d, totalTime = %d", tempTime, result));
		}


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

		HashMap humidTimeMap = new HashMap();
		humidTimeMap.put(new Integer(0), new Integer(0));
		humidTimeMap.put(new Integer(1), new Integer(0));
		humidTimeMap.put(new Integer(2), new Integer(0));
		
		////////////////////////여기부터 코딩 (2) ---------------->
		
		for (String tempTime : inputData) {
			String humidType = tempTime.substring(0, 1);
			
			int humidIdx =  humidType.equals("L") ? 0 : ( humidType.equals("M") ? 1 : 2 );
			int humidTime = Integer.parseInt(tempTime.substring(1));
			
			int tempHumidTime = (Integer)humidTimeMap.get(new Integer(humidIdx));
			humidTimeMap.put(new Integer(humidIdx), tempHumidTime + humidTime);
			// System.out.println(String.format("humidType = %s, humidIdx = %d, humidTime = %d, tempHumidTime = %d", humidType, humidIdx, humidTime, tempHumidTime));
			
		}
		// System.out.println("humidTimeMap==>\n" + humidTimeMap);
		
		Iterator<Integer> ite = humidTimeMap.keySet().iterator();
		while(ite.hasNext()) {
			int humidIdx = ite.next();
			int humidTime = (int) humidTimeMap.get(humidIdx);
			int tempResult= (int)(ccInfo.get(humidIdx) * humidTime/60);
			// System.out.println(String.format("humidIdx = %d, humidTime = %d, tempResult = %d", humidIdx, humidTime, tempResult));
			
			result += tempResult;
		}
		// System.out.println("result ==> " + result);
		
		


		///////////////////////////// <-------------- 여기까지 코딩 (2)

		return result;
	}
}