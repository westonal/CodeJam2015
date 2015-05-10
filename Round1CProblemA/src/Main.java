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
		List<String> readAllLines = Files.readAllLines(new File(
				"A-small-attempt0.in").toPath(), StandardCharsets.UTF_8);

		int testCases = Integer.parseInt(readAllLines.get(0));

		System.out.println(testCases + " Cases");

		List<String> results = new ArrayList<String>();

		for (int i = 1; i <= testCases; i++) {
			String[] split = readAllLines.get(i).split(" ");
			int[] values = toInts(split);
			String result = String.format("Case #%d: %d", i,
					calc(values[0], values[1], values[2]));
			results.add(result);
			System.out.println(result);
		}

		OutputStream s = new FileOutputStream(new File("A-small-attempt0.out"));
		OutputStreamWriter writer = new OutputStreamWriter(s);
		for (String result : results)
			writer.write(result + "\n");
		writer.flush();
		s.close();
	}

	private static int[] toInts(String[] split) {
		int[] values = new int[split.length];
		for (int j = 0; j < split.length; j++)
			values[j] = Integer.parseInt(split[j]);
		return values;
	}

	public static int calc(int rows, int cols, int w) {
		int fit = rows * (cols / w);
		int hit = cols % w == 0 ? w - 1 : w;
		return fit + hit;
	}
}
