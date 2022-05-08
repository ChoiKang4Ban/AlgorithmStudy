import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class programmers_튜플 {

	public static void main(String[] args) {
		String s = "{{1,2},{2},{2,1,3},{2,1,3,4}}";
		String[] tuples = s.substring(2,s.length()-2).split("\\},\\{");
		
		Arrays.sort(tuples, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		List<Integer> answerList = new ArrayList<>();
		
		for(String tuple : tuples) {
			String[] values = tuple.split(",");
			for(String value : values) {
				int valueToInt = Integer.parseInt(value);
				if(answerList.contains(valueToInt)) continue;
				else answerList.add(valueToInt);
			}
		}
		
		answerList.toArray();
		
		
	}

}
