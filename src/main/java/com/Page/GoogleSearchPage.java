package com.Page;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.awt.print.PageFormat;

import javax.mail.BodyPart;

import mx4j.tools.adaptor.http.HttpException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchPage {

	public static void main(String[] args) throws ClientProtocolException,
			IOException {

		// WebDriver webDriver=new FirefoxDriver();
		String url = "https://www.google.com/search?q=whey";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.20 (KHTML, like Gecko) Chrome/11.0.672.2 Safari/534.20");
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		String result1 = result.toString();

		String justBody = result1;

		// select body
		// int startBody=result1.indexOf("<body");
		// int endBody=result1.indexOf("</body>");
		// String justBody=result1.substring(startBody, endBody);
		// System.out.println(justBody);

		// select first link
		int start_index_of_link = justBody.indexOf("<h3 class=\"r\"");
		justBody = justBody.substring(start_index_of_link);
		int end_index_of_link = justBody.indexOf("\" onmousedown");
		String strLink = justBody.substring(23, end_index_of_link);
		System.out.println(strLink);

		WebDriver webDriver1 = new FirefoxDriver();
		webDriver1.get(strLink);

	}

}
