package org.xmx0632.management.utilities.image;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xmx0632.management.utilities.image.WaterMarkUtil;

public class WaterMarkUtilTest {

	@Before
	public void setup() {
		File testTargetDir = new File("target");
		if (!testTargetDir.exists()) {
			testTargetDir.mkdir();
			return;
		}

		File[] imageFiles = testTargetDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String extension = FilenameUtils.getExtension(name);
				return ("jpg".equalsIgnoreCase(extension) || "png"
						.equalsIgnoreCase(extension));
			}
		});

		for (File file : imageFiles) {
			file.delete();
		}
	}

	@Test
	public void testPressImage() {
		String markedImage = "target/testPressImage.png";
		assertFalse(new File(markedImage).exists());
		WaterMarkUtil.pressImage("src/test/resources/watermarker/logo.png",
				"src/test/resources/watermarker/backgroud.png", markedImage,
				100, 100);
		assertTrue(new File(markedImage).exists());
	}

	@Test
	public void testPressText1() {
		String markedImage = "target/testPressText1.png";
		assertFalse(new File(markedImage).exists());
		WaterMarkUtil.pressText("美果人生",
				"src/test/resources/watermarker/backgroud.png", markedImage,
				Font.SANS_SERIF, Font.TRUETYPE_FONT, Color.RED, 18, 538, 938);
		assertTrue(new File(markedImage).exists());
	}

	@Test
	public void testPressText2() {
		String markedImage = "target/testPressText2.png";
		assertFalse(new File(markedImage).exists());
		WaterMarkUtil.pressText("美果人生",
				"src/test/resources/watermarker/backgroud.png", markedImage,
				Font.SANS_SERIF, Font.TRUETYPE_FONT, Color.RED, 9, 538, 938);
		assertTrue(new File(markedImage).exists());
	}

	@Test
	public void testPressTextAndImagePngRelativePath() {
		String markedImage = "target/testPressTextAndImage.png";
		assertFalse(new File(markedImage).exists());
		WaterMarkUtil.pressTextAndImage("美果人生美果人生",
				"src/test/resources/watermarker/logo.png",
				"src/test/resources/watermarker/backgroud.png", markedImage,
				Font.SANS_SERIF, Font.TRUETYPE_FONT, Color.RED, 18, 26, 16);
		assertTrue(new File(markedImage).exists());
	}

	@Ignore
	@Test
	public void testPressTextAndImagePng() {
		String markedImage = "C:/watermarker/testPressTextAndImage.png";
		assertFalse(new File(markedImage).exists());
		WaterMarkUtil.pressTextAndImage("美果人生美果人生", "C:/watermarker/logo.png",
				"C:/watermarker/backgroud.png", markedImage, Font.SANS_SERIF,
				Font.TRUETYPE_FONT, Color.RED, 18, 26, 16);
		assertTrue(new File(markedImage).exists());
	}

	@Ignore
	@Test
	public void testPressTextAndImageJpg() {
		String markedImage = "C:/watermarker/testPressTextAndImage.jpg";
		assertFalse(new File(markedImage).exists());
		WaterMarkUtil.pressTextAndImage("美果人生美果人生", "C:/watermarker/logo.jpg",
				"C:/watermarker/backgroud.jpg", markedImage, Font.SANS_SERIF,
				Font.TRUETYPE_FONT, Color.RED, 18, 26, 16);
		assertTrue(new File(markedImage).exists());
	}
}
