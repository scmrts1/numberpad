package com.lgcns.tct.statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Statistic {

	/**
	 * 출생아 수가 가장 많은 연도 검색 기능
	 *
	 * @param 	inputData   	int[]			입력데이터(출생아 수 데이터) ([0]:2010년, [1]:2011년, [2]:2012년, [3]:2013년, [4]:2014년, [5]:2015년, [6]:2016년) 
	 * @return 					int 			출생아 수가 가장 많은 연도
	 */
	public int getMaxYear(int[] inputData) {
		int maxYear = 2010;
		//////////////////////// 여기부터 구현 (1) ---------------->
		int reduce = Arrays.stream(inputData).reduce(Integer::max).getAsInt();
		for( int data : inputData) {
			if(data == reduce) {
				break;
			}
			maxYear +=1;
		}
		
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return maxYear;
	}

	/**
	 * 출생아 수가 가장 크게 감소한 연도 검색 기능
	 *
	 * @param 	inputData   	int[]			입력데이터(출생아 수 데이터) ([0]:2010년, [1]:2011년, [2]:2012년, [3]:2013년, [4]:2014년, [5]:2015년, [6]:2016년)
	 * @return 					int 			출생아 수가 가장 크게 감소한 연도
	 */
	public int getMaxDecreaseYear(int[] inputData) {
		int maxDecreaseYear = 2010;
		//////////////////////// 여기부터 구현 (2) ---------------->
		List<Integer> tmp = new ArrayList<Integer>();
		for(int i = 0 ; i < inputData.length ; i++) {
			if ( i == 0 ) {
				tmp.add(0);
			} else {
				tmp.add(inputData[i-1] - inputData[i]);
			}
		}
		
		int asInt = tmp.stream().mapToInt(v->v).max().getAsInt();
		
		for( int data : tmp) {
			if(data == asInt) {
				break;
			}
			maxDecreaseYear +=1;
		}
		
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return maxDecreaseYear;
	}

}