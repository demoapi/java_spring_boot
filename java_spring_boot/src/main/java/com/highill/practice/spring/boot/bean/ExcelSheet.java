package com.highill.practice.spring.boot.bean;

import java.util.List;
import java.util.Map;

public class ExcelSheet {
	
	private List<String> headerNameList;
	
	private List<Map<String, String>> sheetValueList;

	public List<String> getHeaderNameList()
	{
		return headerNameList;
	}

	public void setHeaderNameList(List<String> headerNameList)
	{
		this.headerNameList = headerNameList;
	}

	public List<Map<String, String>> getSheetValueList()
	{
		return sheetValueList;
	}

	public void setSheetValueList(List<Map<String, String>> sheetValueList)
	{
		this.sheetValueList = sheetValueList;
	}

	@Override
    public String toString()
    {
	    return "ExcelSheet [headerNameList=" + headerNameList + ", sheetValueList=" + sheetValueList + "]";
    }
	
	

}
