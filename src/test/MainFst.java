package test;

import info.puneetsingh.jhs.controller.HappyOrSadController;

public class MainFst {
	public static void main(String[] args) {
		String text = "I love the fact that google is doing so good".replaceAll("[,']"," ").toLowerCase();
		HappyOrSadController hsc = new HappyOrSadController(text);
		System.out.println(hsc.getXcordinate());
		System.out.println(hsc.getYcordinate());
		System.out.println(hsc.getMoodValue());
	}
}
