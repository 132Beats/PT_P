import java.util.ArrayList;

public class Bubblesort{
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<32;i++) {
			al.add((int)Math.ceil(Math.random()*100));
		}
		print(al);
		System.out.println("Sortiert:");
		print(bubblesort(al));
	}
	public static <T extends Comparable<T>> ArrayList<T> bubblesort(ArrayList<T> al){
		for(int j=0;al.size()>j;j++) {
			for(int i=0;al.size()-1-j>i;i++) {
				if(al.get(i).compareTo(al.get(i+1))>0) {
					T buff=al.get(i);
					al.set(i,al.get(i+1));
					al.set(i+1,buff);
				}
			}
		}
		return al;
		
	}
	public static void print(ArrayList<?> al) {
		for(int i=0;al.size()>i;i++) {
			System.out.println(al.get(i).toString());
		}
	}

}
