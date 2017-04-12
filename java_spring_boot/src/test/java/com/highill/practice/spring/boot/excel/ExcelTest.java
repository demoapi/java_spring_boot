package com.highill.practice.spring.boot.excel;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.highill.practice.spring.boot.bean.ExcelSheet;


@RunWith(BlockJUnit4ClassRunner.class)
public class ExcelTest {
	
	
	@Test
	public void excel() {
		
		
		String fileName = "test/excel/create_1";
		
		String[] fileNameArray = new String[]{fileName};
		for(String name : fileNameArray) {
			String excelFileName = name + ".xlsx";
			File file = new File(excelFileName);
			if(file.exists()) {
				file.delete();
				System.out.println(" delete file: " + excelFileName + "   absolutePath: " + file.getAbsolutePath());
			}
		}
		
		List<String> headerNameList = Arrays.asList(new String[]{"用户名", "姓名", "登陆时间"});
				
		ExcelSheet excelSheet = new ExcelSheet();
		excelSheet.setHeaderNameList(headerNameList);
		ExcelSheetWrite.write(fileName, "测试", excelSheet);
	}

}
