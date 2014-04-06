package info.puneetsingh.jhs.loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import info.puneetsingh.jhs.bean.Cordinates;
import info.puneetsingh.jhs.utils.SimpleDictionaryLoader;

public class BigramLoader {
	private static SimpleDictionaryLoader bigram = null;
	private InputStream input = null;
	private void loadDictionary()
	{
		try {			
			bigram = new SimpleDictionaryLoader();
			input = new FileInputStream("Dictionaries/bigram_liwc.db");
			bigram.load(input);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Cordinates getBigramCordinates(int Category1, int Category2)
	{
		String key = String.valueOf(Category1)+"_"+String.valueOf(Category2);
		Cordinates crdntsRet = new Cordinates();
		if(bigram == null)
		{
			loadDictionary();
		}
		String value = bigram.getDictionaryValue(key);
		if(value!=null)
		{
			String[] cordStr = value.split(",");
			crdntsRet.setX(Float.parseFloat(cordStr[0]));
			crdntsRet.setY(Float.parseFloat(cordStr[1]));
			return crdntsRet;
		}
		else
		{
			crdntsRet.setX(0);
			crdntsRet.setY(0);
			return crdntsRet;
		}
	}
}
