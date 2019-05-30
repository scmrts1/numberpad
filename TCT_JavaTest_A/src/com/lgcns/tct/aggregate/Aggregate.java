package com.lgcns.tct.aggregate;

public class Aggregate {
	
	
	/**
	 * 부분 배열의 개수를 구하는 기능
	 *
     * @param		arraySize			int		배열 크기
     * @return							int		부분 배열의 개수
	 */
	public int getNumberOfSubArrays(int arraySize) {
		int numberOfSubArrays = 0;
		////////////////////////여기부터 구현 (1) ---------------->
		for(int k = 0 ; k < arraySize ; k++) {
			for ( int i = 0 ; i< arraySize - k; i++) {
				for(int j = 0 ; j < arraySize - k; j++) {
					numberOfSubArrays += 1;
				}
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return numberOfSubArrays;
	}


	
	/**
	 * 최대값을 찾는 기능
	 *
     * @param		inputData			int[][]		입력데이터(NxN배열)
     * @return							int			최대값
	 */
	public int getMaximumValue(int[][] inputData) {
		int maximumValue = -1;
		
		////////////////////////여기부터 구현 (2) ---------------->
		int arraySize = inputData.length;
		int[] position = new int[] {0, 0};			
		for(int k = 1 ; k < arraySize ; k++) {
			
		}
		
		
		
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return maximumValue;
	}
	
}