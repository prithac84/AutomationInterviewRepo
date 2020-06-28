package pkgInterview.AutomationInterviewAll;

public class FindOccurences {

	
	public static void main(String[] args) {		// TODO Auto-generated method stub
		String word1="Prgdgasgjaaaaaj5778873378";
		char a1='g';		
		int noValues=countChar(word1,a1);	
		System.out.println(noValues);
}

	private static int countChar(String word, char a) {
		int count = 0;
		for(int i=0;i<word.length();i++)
		{
			if(word.charAt(i)==a)
				count++;
		}
		return count;	
	}
	}
	
	
	