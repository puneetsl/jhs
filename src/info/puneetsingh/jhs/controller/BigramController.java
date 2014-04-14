package info.puneetsingh.jhs.controller;

import java.util.ArrayList;

import info.puneetsingh.jhs.bean.Cordinates;
import info.puneetsingh.jhs.loader.BigramLoader;
import info.puneetsingh.jhs.loader.LIWCLoader;
import info.puneetsingh.jhs.utils.Ngrams;

public class BigramController {
	private LIWCLoader liwcLoader = new LIWCLoader();
	private BigramLoader bigramLoader= new BigramLoader();
	private int totalPositive;
	private int totalNegative;
	private int q1;
	private int q2;
	private int q3;
	private int q4;
	public Cordinates getResultantCordinate(String text)
	{
		Ngrams ng = new Ngrams(text);
		ArrayList<Cordinates> cordinatesArr = new ArrayList<Cordinates>(); 
		ArrayList<String> bigrams = ng.getNgrams(2);
		
		for (int i = 0; i < bigrams.size(); i++) {
//			System.out.println(bigrams.get(i));
			String[] words = bigrams.get(i).split(" ");
			String[] categories1 = null;
			String[] categories2 = null;
			if(words.length>1)
			{
				categories1 = liwcLoader.getDictionaryValue(words[0]).split(",");
				categories2 = liwcLoader.getDictionaryValue(words[1]).split(",");
				for (int j = 0; j < categories1.length; j++) {
					for (int k = 0; k < categories2.length; k++) {
						cordinatesArr.add(bigramLoader.getBigramCordinates(Integer.parseInt(categories1[j]),Integer.parseInt(categories2[k])));
					}
				}
			}
		}
		float sumX=0,sumY=0;
		totalPositive=0;totalNegative=0;
		q1=0;q2=0;q3=0;q4=0;
		for (int i = 0; i < cordinatesArr.size(); i++) {
			sumX += cordinatesArr.get(i).getX();
			sumY += cordinatesArr.get(i).getY();
			if(cordinatesArr.get(i).getY()>0&&cordinatesArr.get(i).getX()>0)
				q1++;
			else if(cordinatesArr.get(i).getY()<0&&cordinatesArr.get(i).getX()>0)
				q2++;
			else if(cordinatesArr.get(i).getY()<0&&cordinatesArr.get(i).getX()<0)
				q3++;
			else
				q4++;
				
				
			if(cordinatesArr.get(i).getY()>0)
			{
				totalPositive+=cordinatesArr.get(i).getY();
			}
			else if(cordinatesArr.get(i).getY()<=0)
			{
				totalNegative+=cordinatesArr.get(i).getY();
			}
		}
		Cordinates retCord = new Cordinates();
		retCord.setX(sumX);retCord.setY(sumY);
		return retCord;
	}
	public int[] getQuadrants()
	{
		int[] retQ = {q1,q2,q3,q4};
		return retQ;
	}
	public int getTotalPositive() {
		return totalPositive;
	}
	public int getTotalNegative() {
		return totalNegative;
	}
}
