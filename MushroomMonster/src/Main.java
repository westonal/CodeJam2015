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
				"A-large.in").toPath(), StandardCharsets.UTF_8);

		int testCases = Integer.parseInt(readAllLines.get(0));

		System.out.println(testCases + " Cases");

		List<String> results = new ArrayList<String>();

		for (int i = 1; i <= testCases; i++) {
			int len =Integer.parseInt(readAllLines.get(i*2-1));
			int[] sequence = new int[len];
			String[] split = readAllLines.get(i*2).split(" ");
			for(int j=0;j<split.length;j++)
				sequence[j]=Integer.parseInt(split[j]);
				
			MushroomSequence mush = new MushroomSequence(sequence);
			String result = String.format("Case #%d: %d %d", i,
					mush.minEaten(), mush.maxEaten());
			results.add(result);
			System.out.println(result);
		}

		OutputStream s = new FileOutputStream(new File("A-large.out"));
		OutputStreamWriter writer = new OutputStreamWriter(s);
		for (String result : results)
			writer.write(result + "\n");
		writer.flush();
		s.close();
	}

}

