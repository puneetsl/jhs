package test;



import info.puneetsingh.jhs.controller.BigramController;
public class MainFst {
	public static void main(String[] args) {
		BigramController bc = new BigramController();
		String str = "gasp this is so bad";
		System.out.println(bc.getResultantCordinate(str).getX());
		System.out.println(bc.getResultantCordinate(str).getY());
	}
}
