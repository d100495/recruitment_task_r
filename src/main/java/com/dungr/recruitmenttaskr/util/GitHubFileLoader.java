package com.dungr.recruitmenttaskr.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubFileLoader {

	public String loadGitHubFileContent(String path) {
		String response = new String();
		try {
			URL url = new URL(validateGitHubFilePath(path));
			HttpURLConnection Http = (HttpURLConnection) url.openConnection();
			InputStream Stream = Http.getInputStream();
			response = new StreamReader().getStringFromStream(Stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	String validateGitHubFilePath(String path) {
		if (path.length() > 0 && !path.contains("?raw=true")) {
			path += "?raw=true";
		}
		return path;
	}

}
