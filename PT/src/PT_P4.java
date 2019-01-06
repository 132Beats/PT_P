import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PT_P4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Klassennamen eingeben:");
		String str = scan.nextLine();
		try {
			Class c = Class.forName(str);
			System.out.println("Class: "+c.getName());
			Class c1 = c.getSuperclass();
			System.out.println("Superclass: "+c1.getName());
			System.out.println("Constructors:");
			Constructor[] constructors = c.getDeclaredConstructors();
			for(int i =0;constructors.length>i;i++) {
				System.out.println(constructors[i]);
			}
			System.out.println("Methods:");
			Method[] methods = c.getDeclaredMethods();
			for(int i =0;methods.length>i;i++) {
				System.out.println(methods[i]);
			}
			System.out.println("Fields:");
			Field[] fields = c.getDeclaredFields();
			for(int i =0;fields.length>i;i++) {
				System.out.println(fields[i]);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
	}

}
