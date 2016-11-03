package GID.AID;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ReducerOfIPFilter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		// List<String> list = new ArrayList<String>();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] tokens = line.split("\t");
			set.add(tokens[0]);
		}
		System.out.println(set.size());

		sc.close();

	}
}
