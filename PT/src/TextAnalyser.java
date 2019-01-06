
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class TextAnalyser {
	
	public static void main(String[] args) {
		analyse();
	}
	
	public static void analyse() {
		Scanner sysIn = new Scanner(System.in);
		LinkedList<String> wList = new LinkedList<String>();
		TreeSet<String> wMap = new TreeSet<String>();
		sysIn.forEachRemaining(x -> {wList.addAll(Arrays.asList(x.split("\\PL+")));});
		System.out.println("Wortanzahl: " + wList.size());
		wMap.addAll(wList);
		System.out.println("Anzahl unterschiedlicher Wörter:" + wMap.size());
		System.out.println("Sortierte unterschiedliche Wörter: " + wMap);
		sysIn.close();
	}

}