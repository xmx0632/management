package ant.task;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class FileNameConverter extends Task {

	private File dir;

	private String extName;

	public void execute() throws BuildException {

		FilenameFilter filter = new FilenameFilter() {

			public boolean accept(File dir, String name) {
				if (name.endsWith(extName)) {
					return true;
				}
				return false;
			}
		};
		File[] filelist = dir.listFiles(filter);
		for (File file : filelist) {
			final String filename = file.getName();
			System.out.println("filename:" + filename);
			final String firstChar = filename.substring(0, 1);
			System.out.println("firstChar:" + firstChar);
			final String lowerCase = firstChar.toLowerCase();
			final boolean isStartLowerCaseNow = firstChar.equals(lowerCase);
			System.out.println("isStartLowerCaseNow:" + isStartLowerCaseNow);
			if (isStartLowerCaseNow) {
				return;
			}
			String newFilename = file.getParent() + "\\" + lowerCase
					+ filename.substring(1);
			System.out.println("newFilename:" + newFilename);
			file.renameTo(new File(newFilename));
		}
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}
}
