package test;



import info.puneetsingh.jhs.controller.BigramController;
import info.puneetsingh.jhs.controller.UnigramController;
import info.puneetsingh.jhs.loader.UnigramLoader;
public class MainFst {
	public static void main(String[] args) {
		BigramController bc = new BigramController();
		UnigramController uc = new UnigramController();
		String str = "chances are that this would work out but I am not very sure";
		System.out.println(bc.getResultantCordinate(str).getX());
		System.out.println(bc.getResultantCordinate(str).getY());
		System.out.println(uc.getScore(str));
	}
}
