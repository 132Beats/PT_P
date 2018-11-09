import java.util.*;
/*@author
§ @version
§ @param
§ @return
§ @exception
§ @see
*/
public class PT_P1_2 {
	PT_P1_2(){
		int n=3;
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
		gauss(n,a,b);
	}
	public static void main(String[] args) {
		PT_P1_2 pt1_2=new PT_P1_2();
	}
	public void gauss(int n,double a[][], double b[]){
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
}
