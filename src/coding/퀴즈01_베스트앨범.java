package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ÄûÁî01_º£½ºÆ®¾Ù¹ü {
	
	public static void main(String[] args) {
		Solution01 sol = new Solution01();
		String genres[] = {"classic", "pop", "classic", "classic", "pop"};
		int plays[] = {500, 600, 150, 800, 2500};
		int result[] = sol.solution(genres, plays);
		System.out.println(Arrays.toString(result));
	}
}
class Solution01 {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<genres.length; i++) {
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        System.out.println(map);
       
        List<String> listKeySet = new ArrayList<>(map.keySet());
        Collections.sort(listKeySet, (o1,o2)-> map.get(o2).compareTo(map.get(o1)));
        System.out.println(listKeySet);
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<listKeySet.size(); i++) {
        	String g = listKeySet.get(i);
        	int max = 0;
        	int firstIdx = -1;
        	for(int j=0; j<plays.length; j++) {
        		if(genres[j].equals(g)) {
        			if(plays[j] > max) {
        				max = plays[j];
        				firstIdx = j;
        			}
        		}
        	}
        	max = 0;
        	int secondIdx = -1;
        	for(int j=0; j<plays.length; j++) {
        		if(genres[j].equals(g)) {
        			if(plays[j] > max && j!=firstIdx) {
        				max = plays[j];
        				secondIdx = j;
        			}
        		}
        	}
        	list.add(firstIdx);
        	if(secondIdx >= 0) list.add(secondIdx);
        	      	 	
        }
        
        System.out.println(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}