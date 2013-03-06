package org.xmx0632.management.utilities.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WaterMarkUtil {
	private static Logger log = LoggerFactory.getLogger(WaterMarkUtil.class);

	private WaterMarkUtil() {
	}

	/**
	 * 把图片印刷到图片上
	 * 
	 * @param pressImg
	 *            -- 水印文件
	 * @param targetImg
	 *            -- 目标文件
	 * @param x
	 *            --x坐标
	 * @param y
	 *            --y坐标
	 */
	public static void pressImage(String pressImg, String targetImg,
			String outputImg, int x, int y) {
		try {
			// 目标文件
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);

			// 水印文件
			File _filebiao = new File(pressImg);
			Image src_biao = ImageIO.read(_filebiao);
			int width_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);

			g.drawImage(src_biao, x, y, width_biao, height_biao, null);

			// 水印文件结束
			g.dispose();

			ImageIO.write(image, getImgFormatFrom(outputImg), new File(
					outputImg));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private static String getImgFormatFrom(String filename) {
		return FilenameUtils.getExtension(filename);
	}

	/**
	 * 打印文字水印图片
	 * 
	 * @param pressText
	 *            --文字
	 * @param targetImg
	 *            -- 目标图片
	 * @param fontName
	 *            -- 字体名
	 * @param fontStyle
	 *            -- 字体样式
	 * @param color
	 *            -- 字体颜色
	 * @param fontSize
	 *            -- 字体大小
	 * @param x
	 *            -- 偏移量
	 * @param y
	 */

	public static void pressText(String pressText, String targetImg,
			String outputImg, String fontName, int fontStyle, Color color,
			int fontSize, int x, int y) {
		try {
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));

			g.drawString(pressText, x, y);
			g.dispose();
			ImageIO.write(image, getImgFormatFrom(outputImg), new File(
					outputImg));

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 打印文字水印图片
	 * 
	 * @param pressText
	 *            --文字
	 * @param pressImg
	 *            --水印文件
	 * @param targetImg
	 *            -- 目标图片
	 * @param outputImg
	 *            -- 输出文件
	 * @param fontName
	 *            -- 字体名
	 * @param fontStyle
	 *            -- 字体样式
	 * @param color
	 *            -- 字体颜色
	 * @param fontSize
	 *            -- 字体大小
	 * @param lengthToRight
	 *            -- 右边距
	 * @param lengthToBottom
	 *            -- 距离底部距离
	 */

	public static void pressTextAndImage(String pressText, String pressImg,
			String targetImg, String outputImg, String fontName, int fontStyle,
			Color color, int fontSize, int lengthToRight, int lengthToBottom) {
		try {
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);

			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));

			// 水印文件
			File _filebiao = new File(pressImg);
			Image src_biao = ImageIO.read(_filebiao);
			int width_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);

			int text_x = width - lengthToRight - fontSize * pressText.length();
			int text_y = height - lengthToBottom - height_biao / 2 + fontSize
					/ 2;

			g.drawString(pressText, text_x, text_y);

			int img_x = text_x - 10 - width_biao;

			int img_y = height - lengthToBottom - height_biao;

			g.drawImage(src_biao, img_x, img_y, width_biao, height_biao, null);

			g.dispose();
			ImageIO.write(image, getImgFormatFrom(outputImg), new File(
					outputImg));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
