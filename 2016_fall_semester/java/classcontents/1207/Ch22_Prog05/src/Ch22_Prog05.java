import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ch22_Prog05 {
	public static void main(String[] args) {
		ArrayList <Double> list = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 10; i++)
			list.add(rand.nextDouble() * 10);
		for(Double d : list)
			System.out.println(d);
		Collections.sort(list);
		System.out.println(list.size()); 
		list.remove(0);
		System.out.println(list.size()); 
		list.remove(8);
		System.out.println(list); 	// toString() 메소드 호출
		
		double sum = 0.0;
		for(int i = 0; i < list.size(); i++)
			sum += list.get(i);
		System.out.printf("%.2f", sum);
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
	}
}
