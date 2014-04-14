package test;

import info.puneetsingh.jhs.controller.HappyOrSadController;

public class MainFst {
	public static void main(String[] args) {
		String text = "This library is awesome".replaceAll("[,']"," ").toLowerCase();
		HappyOrSadController hsc = new HappyOrSadController(text);
		System.out.println(hsc.getXcordinate());
		System.out.println(hsc.getYcordinate());
		System.out.println(hsc.getMoodValue());
	}
}
