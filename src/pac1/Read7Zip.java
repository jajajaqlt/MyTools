package pac1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

public class Read7Zip {
	public static String fileName = "E:\\Data\\Stack_Exchange_Data\\stackoverflow.com-Users.7z";
	// public static String fileName = "stackoverflow.com-Badges.7z";
	// number of bytes to be read from file with fileName
	public static int numberOfBytes = 1000000;

	public static void main(String[] args) throws IOException {
		SevenZFile archiveFile = new SevenZFile(new File(fileName));
		SevenZArchiveEntry entry;
		try {
			// Go through all entries
			while ((entry = archiveFile.getNextEntry()) != null) {
				// Maybe filter by name. Name can contain a path.
				String name = entry.getName();
				if (entry.isDirectory()) {
					System.out.println(String.format(
							"Found directory entry %s", name));
				} else {
					// If this is a file, we read the file content into a
					// ByteArrayOutputStream ...
					System.out.println(String.format("Unpacking %s ...", name));
					ByteArrayOutputStream contentBytes = new ByteArrayOutputStream();

					// ... using a small buffer byte array.
					byte[] buffer = new byte[numberOfBytes];
					int bytesRead;

					// while ((bytesRead = archiveFile.read(buffer)) != -1) {
					bytesRead = archiveFile.read(buffer);
					contentBytes.write(buffer, 0, bytesRead);

					// Assuming the content is a UTF-8 text file we can
					// interpret the
					// bytes as a string.
					String content = contentBytes.toString("UTF-8");
					System.out.println(content);
				}
			}
		} finally {
			archiveFile.close();
		}
	}
}
