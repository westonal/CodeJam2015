import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public final class Main {

	public static void main(String[] args) throws IOException {
		List<String> readAllLines = Files.readAllLines(
				new File("B-small-attempt0.in").toPath(), StandardCharsets.UTF_8);

		int testCases = Integer.parseInt(readAllLines.get(0));

		System.out.println(testCases + " Cases");

		List<String> results = new ArrayList<String>();

		for (int i = 1; i <= testCases; i++) {
			String line1 = readAllLines.get(i * 2 - 1);
			String line2 = readAllLines.get(i * 2);
			String[] split1 = line1.split(" ");
			String[] split2 = line2.split(" ");

			int len = Integer.parseInt(split1[0]);
			int yourPlaceInLine = Integer.parseInt(split1[1]);
			int[] timesOfBarbers = new int[len];

			for (int j = 0; j < split2.length; j++)
				timesOfBarbers[j] = Integer.parseInt(split2[j]);

			int b = Haircut.calcBarber(yourPlaceInLine, timesOfBarbers);
			String result = String.format("Case #%d: %d", i, b);
			results.add(result);
			System.out.println(result);
		}

		OutputStream s = new FileOutputStream(new File("B-small-attempt0.out"));
		OutputStreamWriter writer = new OutputStreamWriter(s);
		for (String result : results)
			writer.write(result + "\n");
		writer.flush();
		s.close();
	}

}
