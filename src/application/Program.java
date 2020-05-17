package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entities.Registers;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> map = new LinkedHashMap<>();
		List<Registers> list = new ArrayList<>();

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			int quantity;
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				quantity = Integer.parseInt(fields[1]);
				if (map.containsKey(fields[0])) {
					quantity += map.get(fields[0]);
				}
				map.put(fields[0], quantity);
				line = br.readLine();
			}

			for (String key : map.keySet()) {
				list.add(new Registers(key, map.get(key)));
			}

			for (Registers rg : list) {
				System.out.println(rg);
			}

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
