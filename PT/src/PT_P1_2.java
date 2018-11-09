import java.util.*;
/**	@author Hendrik Klein-Hitpaﬂ
	@version 1.0
**/
public class PT_P1_2 {
	int n;
	double[][] a;
	double[] b;
	PT_P1_2(){
		n=3;
		double[][] a = new double[n][n];
		double[] b = new double[n];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 1;
		a[1][0] = 3;
		a[1][1] = 1;
		a[1][2] = 4;
		a[2][0] = 5;
		a[2][1] = 1;
		a[2][2] = 6;
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		gauss();
	}
	public static void main(String[] args) {
		PT_P1_2 pt1_2=new PT_P1_2();
	}
	public void gauss(){
		for(int i=0;i<n;i++) {
			int k=i;
			double l=a[i][i];
			for(int j=i;j<n;j++) {
				if(a[i][j]>l){
					l=a[i][j];
					k=j;
				}
			}
			//tauschen
			//eliminieren
		}
	}

/**	@param zeileA erste Zeile die getauscht werden soll
 * 	@param zeileB zweite Zeile die getauscht werden soll
	@exception gleicheZeile Du kannst keine Zeile mit sich selber tauschen!
	@exception ZeilenIOOB ZeilenIndex out of Bounds!
**/
	public void zeilentausch(int zeileA,int zeileB) {
		if(zeileA==zeileB) {
			System.out.println("Du kannst keine Zeile mit sich selber tauschen!");
		}
		else if(zeileA <= n && zeileB <= n && zeileA >= 0 && zeileB >= 0){
			System.out.println("ZeilenIndex out of Bounds!");
		}
		else {
			//tauschen
		}
	}
}
