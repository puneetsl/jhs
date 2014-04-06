package info.puneetsingh.jhs.loader;

import info.puneetsingh.jhs.utils.SimpleDictionaryLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UnigramLoader {
	private static SimpleDictionaryLoader unigram = null;
	private InputStream input = null;
		private void loadDictionary()
		{
			try {			
				unigram = new SimpleDictionaryLoader();
				input = new FileInputStream("Dictionaries/unigram.db");
				unigram.load(input);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public String getDictionaryValue(String text) {
			if(unigram == null)
			{
				loadDictionary();
			}
			String dictValue = unigram.getDictionaryValue(text.toLowerCase());
			
			if(dictValue !=null)
				return dictValue;
			return "0";
		}

}
