package com.wenjie.xu.entry;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 徐文杰
 *
 */
public class AbnormalMoveEntry extends Entry{
	private List<TermInfoList> TermInfoList = new ArrayList<TermInfoList>();

	public List<TermInfoList> getTermInfoList() {
		return TermInfoList;
	}

	public void setTermInfoList(TermInfoList termInfoList) {
		if(termInfoList==null) return;
		this.TermInfoList.add(termInfoList);
	}
}
