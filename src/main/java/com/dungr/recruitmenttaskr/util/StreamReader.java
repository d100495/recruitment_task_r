package com.dungr.recruitmenttaskr.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class StreamReader {

	public String getStringFromStream(InputStream inputStream) {
		if (inputStream != null) {
			Writer Writer = new StringWriter();
			char[] Buffer = new char[4096];
			try {
				Reader Reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				int counter;
				while ((counter = Reader.read(Buffer)) != -1) {
					Writer.write(Buffer, 0, counter);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return Writer.toString();
		} else {
			return "No content";
		}
	}
}
