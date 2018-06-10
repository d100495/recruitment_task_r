package com.dungr.recruitmenttaskr.util;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.dungr.recruitmenttaskr.util.StreamReader;

public class StreamReaderTest {

	StreamReader streamReader = null;

	@Before
	public void setUp() {
		streamReader = new StreamReader();
	}

	@Test
	public void testGetStringFromStream_WhenInputStreamIsCorrect_ShouldReturnTestString() {
		InputStream inputStream = new ByteArrayInputStream("test".getBytes());
		assertEquals("test", streamReader.getStringFromStream(inputStream));
	}

	@Test
	public void testGetStringFromStream_WhenInputStreamIsNull_ShouldReturnNoContent() {
		InputStream inputStream = null;
		assertEquals("No content", streamReader.getStringFromStream(inputStream));
	}
}
