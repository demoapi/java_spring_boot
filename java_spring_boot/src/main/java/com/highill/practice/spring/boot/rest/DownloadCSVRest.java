package com.highill.practice.spring.boot.rest;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.highill.practice.spring.boot.bean.NameBean;

/**
 * <a href="http://www.codejava.net/frameworks/spring/spring-mvc-with-csv-file-download-example">Spring MVC CSV</a>
 *
 */
@RestController
public class DownloadCSVRest {

	@RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
	public void downloadCSV(@RequestParam(name = "count", required = false, defaultValue = "3") int count, HttpServletResponse httpResponse)
	{

		String fileName = "downlaod.csv";

		httpResponse.setContentType("text/csv");

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", fileName);
		httpResponse.setHeader(headerKey, headerValue);

		NameBean name1 = new NameBean("f1.name", "last l");

		NameBean name2 = new NameBean("ff2 name", "l2");

		List<NameBean> nameList = Arrays.asList(name1, name2);

		try
		{
			ICsvBeanWriter csvWriter = new CsvBeanWriter(httpResponse.getWriter(), CsvPreference.STANDARD_PREFERENCE);

			String[] titleName = new String[]
			{ "First Name", "Last Name", "Full Name" };

			String[] attributeName = new String[]
			{ "firstName", "lastName", "fullName" };

			csvWriter.writeHeader(titleName);

			for (NameBean name : nameList)
			{
				csvWriter.write(name, attributeName);
			}

			csvWriter.close();

		} catch (Exception e)
		{
			System.out.println(e);

		}

	}
}
