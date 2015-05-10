import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public final class Main {

	public static void main(String[] args) throws IOException {
		List<String> readAllLines = Files.readAllLines(new File(
				"B-small-attempt4.in").toPath(), StandardCharsets.UTF_8);

		int testCases = Integer.parseInt(readAllLines.get(0));

		System.out.println(testCases + " Cases");

		List<String> results = new ArrayList<String>();

		DecimalFormat decimalFormat = new DecimalFormat("0.0######");

		for (int i = 1; i <= testCases; i++) {
			int l = i * 3 - 2;
			String[] split = readAllLines.get(l).split(" ");
			String keyboard = readAllLines.get(l + 1);
			String target = readAllLines.get(l + 2);
			int[] values = toInts(split);
			String result = String.format("Case #%d: %s", i, decimalFormat
					.format(calc(values[0], values[1], values[2], keyboard,
							target)));
			results.add(result);
			System.out.println(result);
		}

		OutputStream s = new FileOutputStream(new File("B-small-attempt4.out"));
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

	public static double calc(int k, int l, int s, String keyboard,
			String target) {
		return new C(keyboard, s).chance(target);
	}
}
