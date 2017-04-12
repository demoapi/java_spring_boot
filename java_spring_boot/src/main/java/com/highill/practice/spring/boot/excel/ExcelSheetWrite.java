package com.highill.practice.spring.boot.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.highill.practice.spring.boot.bean.ExcelSheet;

public class ExcelSheetWrite {

	public static void write(String fileName, String sheetName, ExcelSheet excelSheet)
	{

		try
		{

			if (fileName != null && !fileName.trim().isEmpty() && sheetName != null && !sheetName.trim().isEmpty() && excelSheet != null)
			{
				if (fileName.indexOf("/") >= 0)
				{
					String filePath = fileName.substring(0, fileName.lastIndexOf("/"));
					File file = new File(filePath);
					if (!file.exists())
					{
						file.mkdirs();
					}
				}

				String excelFileName = fileName + ".xlsx";
				File excelFile = new File(excelFileName);
				Workbook workbook = null;
				if (excelFile.exists())
				{
					workbook = WorkbookFactory.create(excelFile);
				} else
				{
					workbook = new XSSFWorkbook();
				}
				
				Sheet sheet = workbook.getSheet(sheetName);
				if(sheet == null) {
					sheet = workbook.createSheet(sheetName);
				}
				
				List<String> headerNameList = excelSheet.getHeaderNameList();
				if(headerNameList != null && !headerNameList.isEmpty()) {
					Row headerRow = sheet.getRow(0);
					if(headerRow == null) {
						headerRow = sheet.createRow(0);
					}
					
					for(int headerColumnSize = 0; headerColumnSize < headerNameList.size(); headerColumnSize++) {
						Cell headerCell = headerRow.getCell(headerColumnSize);
						if(headerCell == null) {
							headerCell = headerRow.createCell(headerColumnSize);
						}
						
						String headerName = headerNameList.get(headerColumnSize);
						if(headerName != null) {
							headerCell.setCellValue(headerName);
						}
					}
				}

				
				FileOutputStream fileOutput = new FileOutputStream(excelFileName);
				workbook.write(fileOutput);
				workbook.close();
				fileOutput.close();
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
