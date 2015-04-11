package com.coltsoftware.codejam.standingovation;

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
		System.out.println(System.getProperty("user.dir"));

		List<String> readAllLines = Files.readAllLines(new File(
				"A-small-attempt0.in").toPath(), StandardCharsets.UTF_8);

		int testCases = Integer.parseInt(readAllLines.get(0));

		System.out.println(testCases + " Cases");

		List<String> results = new ArrayList<String>();

		for (int i = 1; i <= testCases; i++) {
			String result = String.format("Case #%d: %d", i,
					new OvationCalculator(readAllLines.get(i).split(" ")[1]).audienceToAdd());
			results.add(result);
			System.out.println(result);
		}

		OutputStream s = new FileOutputStream(new File(new File(
				System.getProperty("user.dir")), "A-small-attempt0.out"));
		OutputStreamWriter writer = new OutputStreamWriter(s);
		for (String result : results)
			writer.write(result + "\n");
		writer.flush();
		s.close();

		System.out.println(System.getProperty("user.dir"));
	}

}
