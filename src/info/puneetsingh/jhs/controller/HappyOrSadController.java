package info.puneetsingh.jhs.controller;

public class HappyOrSadController {
	private BigramController bc = new BigramController();
	private UnigramController uc = new UnigramController();
	private String text;
	public HappyOrSadController(String text) {
		this.text = text;
		bc.getResultantCordinate(text);
	}
//	System.out.println(bc.getResultantCordinate(str).getX());
//	System.out.println(bc.getResultantCordinate(str).getY());
//	System.out.println(uc.getScore(str));
	public float getXcordinate()
	{
		return bc.getResultantCordinate(text).getX();
	}
	public float getYcordinate()
	{
		return bc.getResultantCordinate(text).getY();
	}
	public float getUnigramScore()
	{
		return uc.getScore(text);
	}
	/**
	 * This is the main and important function of this library. You can use this and trust it to give you mood
	 * or your sentiments in percentage. 
	 * @return happiness percent of the mood
	 */
	public float getMoodValue()
	{
		int totalPositives = bc.getTotalPositive();
		int totalNegatives = bc.getTotalNegative();
		int total  = totalPositives - totalNegatives;
		if(total==0)
			return 50;
		float happy = totalPositives*100.0f/(float)total;//one of the three fetures
		double intensity = 0;
		if(getXcordinate()>0)
		{
			intensity = Math.log10(10+getXcordinate());
		}
		else if(getXcordinate()<0)
		{
			intensity = 1/Math.log10(10+(-1*getXcordinate()));
		}
		happy = (float) (happy*intensity);
		float happyUni = getUnigramScore();
		happy = happy*0.90f+happyUni*0.10f;//9:1 weights for bigram and unigram
		if(happy>100) happy=100;
		if(happy<0) happy=0;
		if(getXcordinate()<-2 && happy>50)
		{
			happy = 100-happy;
		}
		return happy;
	}
	public void setText(String text) {
		this.text = text;
	}
}
