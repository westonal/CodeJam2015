package com.coltsoftware.codejam.infinitehouseofpancakes;

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
			String result = String.format("Case #%d: %d", i,
					new PancakeCalculator(readAllLines.get(i * 2))
							.getMinimumMinutes());
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
