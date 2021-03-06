package ask.ctci.hard;


import java.util.Arrays;
import java.util.HashMap;

public class LongestWord 
{
	public static String printLongestWord(String arr[]) 
	{
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String str : arr) {
			map.put(str, true);
		}
		Arrays.sort(arr, new LengthComparator()); // Sort by length
		for (String s : arr) {
			if (canBuildWord(s, true, map)) {
				System.out.println(s);
				return s;
			}
		}
		return "";
	}
	
	public static boolean canBuildWord(String str, boolean isOriginalWord, HashMap<String, Boolean> map) 
	{
		if (map.containsKey(str) && !isOriginalWord) {
			return map.get(str);
		}
		for (int i = 1; i < str.length(); i++) 
		{
			String left = str.substring(0, i);
			String right = str.substring(i);
			if (map.containsKey(left) && map.get(left) == true && 
				canBuildWord(right, false, map)) {
				return true;
			}
		}
		map.put(str, false);
		return false;
	}	

	public static void main(String[] args) 
	{
		String[] arr = createGiantArray();	
		printLongestWord(arr);
	}
	
	public static String[] createGiantArray() 
	{
		String arr[] = {"dog", "d", "boy", "walk", "walker", "dogwalk", "dogwalker"};
		
		return arr;
	}
}