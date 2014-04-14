package info.puneetsingh.jhs.controller;

import info.puneetsingh.jhs.loader.UnigramLoader;

public class UnigramController {
	UnigramLoader uniLoader = new UnigramLoader();
	public float getScore(String text)
	{
		String[] words = text.split(" ");
		int total=0,sumValue=0;
		
		for (int i = 0; i < words.length; i++) {
			total++;
			sumValue += (Integer.parseInt(uniLoader.getDictionaryValue(words[i]))+5);
		}
		return (float)sumValue/(10*total);
	}
}
