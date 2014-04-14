package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import info.puneetsingh.jhs.controller.HappyOrSadController;

public class MainFst {
	public static void main(String[] args) {
		String text = "I hate the fact that google is doing so good".replaceAll("[,']"," ").toLowerCase();
		HappyOrSadController hsc = new HappyOrSadController(text);
		hsc.setText(text);
//		System.out.println(hsc.getXcordinate());
//		System.out.println(hsc.getYcordinate());
//		System.out.println(hsc.getMoodValue());
		final File folder = new File("/home/puneet/Development/HappyOrSad/aclImdb/test/pos");
		listFilesForFolder(folder,1,hsc);
//		final File folder = new File("/home/puneet/Development/HappyOrSad/aclImdb/test/neg");
//		listFilesForFolder(folder,0,hsc);
	}
	public static void listFilesForFolder(final File folder,int label,HappyOrSadController hsc) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry,label,hsc);
	        } else {
//	            System.out.println(fileEntry.getName());
	            try {
					String text = readFileAsString(fileEntry.getAbsolutePath());
					text = text.replaceAll("[,']"," ").toLowerCase();
					hsc.setText(text);
					float score = hsc.getMoodValue();
					if(score >99)
					{
						System.out.println(label+",1");
					}
					else
					{
						System.out.println(label+",0");
					}
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }
	}
	private static String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}
