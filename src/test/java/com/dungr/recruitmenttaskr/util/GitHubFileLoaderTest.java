package com.dungr.recruitmenttaskr.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dungr.recruitmenttaskr.util.GitHubFileLoader;

public class GitHubFileLoaderTest {

	GitHubFileLoader githubfileloader = null;

	@Before
	public void setUp() {
		githubfileloader = new GitHubFileLoader();
	}

	@Test
	public void testValidateGitHubFilePath_WhenStringIsNotNull_ShouldReturnStringWithRawContent() {
		String string = "test";
		assertEquals("test?raw=true", githubfileloader.validateGitHubFilePath(string));
	}

}
