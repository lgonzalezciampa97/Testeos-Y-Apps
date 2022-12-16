package com.loto.sorteo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AppSorteos {


	public static Integer number() {
		Loader.loadNumbers();
		Random rd = new Random();
		Integer n = rd.nextInt(127);
		return Loader.lotoNumbers.get(n);
	}

	public static Integer jack() {
		Loader.loadJacks();
		Random rd = new Random();
		Integer n = rd.nextInt(40);
		return Loader.lotoJacks.get(n);
	}

	public static List<Integer> sortNumbers() {

		List<Integer> numbers = new ArrayList<>();

		numbers.add(AppSorteos.number());

		for (int i = 0; i < 5; i++) {
			Integer aux = AppSorteos.number();
			if (numbers.contains(aux)) {
				if (i >= 0) {
					i--;
				}
			} else if (!numbers.contains(aux)) {
				numbers.add(aux);
			}
		}

		return numbers;
	}

	public static List<Integer> sortJacks() {

		List<Integer> jacks = new ArrayList<>();

		jacks.add(AppSorteos.jack());

		for (int i = 0; i < 1; i++) {
			Integer aux = AppSorteos.jack();
			if (jacks.contains(aux)) {
				if (i >= 0) {
					i--;
				}
			} else if (!jacks.contains(aux)) {
				jacks.add(aux);
			}
		}

		return jacks;
	}

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			System.out.println("Ejecucion Numero = " + i);
			System.out.println("Numeros: " + AppSorteos.sortNumbers());
			System.out.println("Jacks: " + AppSorteos.sortJacks());
			System.out.println("\n");
		}

	}

}
