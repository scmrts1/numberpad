package com.lgcns.tct.orgol;

import java.util.Comparator;

public class OrgolComparator implements Comparator<SoundInfo> {

	private String orgolOrder = "CDEFGAB";

	@Override
	public int compare(SoundInfo p1, SoundInfo p2) {
		int orderP1 = orgolOrder.indexOf(p1.getPitch());
		int orderP2 = orgolOrder.indexOf(p2.getPitch());

		if (orderP1 > orderP2) {
			return 1; // x에 대해서는 오름차순
		} else if (orderP1 == orderP2) {
			return 0;
		}
		return -1;
	}
}
