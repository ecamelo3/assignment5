import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Converts Morse Code into English using a tree
 * @author ecam2
 * CMSC 204 - Monshi -4/12/2021
 */

public class MorseCodeConverter {
	
	static MorseCodeTree tree = new MorseCodeTree();
	
	public MorseCodeConverter() {}
	
	/**Returns a string with all the data in the tree in LNR order with an space in between them. 
	 * Uses the toArrayList method in MorseCodeTree.
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		ArrayList<String> s = tree.toArrayList();
		String str = "";	
		
		for(int x = 0; x < s.size(); x++) {
			str += s.get(x);
		}
	
		return str;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’. 
	 * @param code - the morse code 
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String codeParts[] = code.split(" ");
		String str = "";
		
		for(String codeLetter: codeParts) {
			if(codeLetter.equals("/")) 
				str += " ";
			else
				str += tree.fetch(codeLetter);
		}
		
		return str;
	}
	
	/**
	 * Converts a file of Morse code into English
	 * Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/
	 * @param codeFile - name of the File that contains Morse Code 
	 * @return the English translation of the file 
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner scan = new Scanner(codeFile);
		String str = "";
		
		while(scan.hasNextLine()){
			 str += convertToEnglish(scan.nextLine());			
		}
		
		scan.close();
		return str;
	}
	
}
