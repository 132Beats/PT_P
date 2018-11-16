import java.util.Calendar;
import java.util.GregorianCalendar;
public class PT_P2 {

	public static void main(String[] args) {
		GregorianCalendar greg=new GregorianCalendar();
		int day_of_week=greg.get(Calendar.DAY_OF_WEEK);
		int counter=0;
		if(greg.get(Calendar.ZONE_OFFSET)==3600000) {
			day_of_week=(day_of_week+6)%7;
		}
		//System.out.println((day_of_week-((greg.get(Calendar.DAY_OF_MONTH)%7))+7)%7);
		for(int i=0;i<(day_of_week-((greg.get(Calendar.DAY_OF_MONTH)%7))+7)%7;i++) {
			System.out.print("      ");
			counter++;
		}
		for(int i=0;i<greg.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
			//System.out.print("("+counter+")");
			if (counter>=7) {
				counter=counter-7;
				System.out.print("\n");
			}
			if(i<9) {
				System.out.print(" ");
			}
			System.out.print(i+1);
			if(i+1==greg.get(Calendar.DAY_OF_MONTH)){
				System.out.print("*   ");
			}
			else {
				System.out.print("    ");
			}
			counter++;
		}
		//System.out.println("");
		//System.out.println(day_of_week);
		//System.out.println(greg.getActualMaximum(Calendar.DAY_OF_MONTH));
		//System.out.println(greg.get(Calendar.DAY_OF_MONTH));
		//System.out.println(greg.get(Calendar.ZONE_OFFSET));
	}

}
