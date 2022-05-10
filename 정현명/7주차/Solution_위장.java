import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution_위장 {
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellohat","headgear"},{"bluesunglasses","eyewear"},{"green_turban","headgear"}};
		System.out.println(solution(clothes));
	}
	static public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String[] item : clothes) {
        	String name = item[0];
        	String type = item[1];
        	
        	List<String> list = map.getOrDefault(type, new ArrayList<>());
        	list.add(name);
        	map.put(type, list);
        }
        
        int answer = 1;
        for(List<String> list : map.values()) {
        	answer *= list.size()+1; 
        }
        
        return answer - 1;
    }
}
