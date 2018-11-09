import java.util.*;
/**	@author Hendrik Klein-Hitpaﬂ
	@version 1.0
**/
public class PT_P1_2 {
	//int n;
	//double[][] a; //[Zeile][Spalte]
	//double[] b;
	int n=3;
	double[][] a = new double[n][n];
	double[] b = new double[n];
	PT_P1_2(){
		a[0][0] = 1;
		a[0][1] = 1;
		a[0][2] = 0;
		a[1][0] = 2;
		a[1][1] = 1;
		a[1][2] = -1;
		a[2][0] = 3;
		a[2][1] = -1;
		a[2][2] = -1;
		b[0] = 4;
		b[1] = 5;
		b[2] = 6;
		gauss();
	}
	public static void main(String[] args) {
		PT_P1_2 pt1_2=new PT_P1_2();
	}
	public void gauss(){
		for(int i=0;i<n;i++){
			ausgabe();
			//tauschpartner finden
			int k=i;
			double l=Math.abs(a[i][i]);
			for(int j=i;j<n;j++){
				if(Math.abs(a[j][i])>l){
					l=Math.abs(a[j][i]);
					k=j;
				}
			}
			zeilentausch(k,i);
			ausgabe();
			//auf 1 setzen
			double teiler=a[i][i];
			for(int q=i;q<n;q++){
				a[i][q]=a[i][q]/teiler;
			}
			b[i]=b[i]/teiler;
			//auf 0 setzen
			for(int q=(i+1);q<n;q++) {
				double factor=a[q][i];
				for(int p=i;p<n;p++) {
					a[q][p]=a[q][p]-(a[i][p]*factor);
				}
				b[q]=b[q]-(b[i]*factor);
			}
		}
		//r¸ckw‰rts
		ausgabe();
		for(int q=n-2;q>=0;q--) {
			for(int p=q+1;p<n;p++) {
				b[q]=b[q]-(a[q][p]*b[p]);
				a[q][p]=0;
			}
		}
		ausgabe();
	}

/**	@param zeileA erste Zeile die getauscht werden soll
 * 	@param zeileB zweite Zeile die getauscht werden soll
	@exception gleicheZeile Du kannst keine Zeile mit sich selber tauschen!
	@exception ZeilenIOOB ZeilenIndex out of Bounds!
**/
	public void zeilentausch(int zeileA,int zeileB) {
		if(zeileA==zeileB) {
			System.out.println("Du kannst keine Zeile mit sich selber tauschen! (Zeile "+zeileA+")");
		}
		else if(zeileA >= n && zeileB >= n && zeileA < 0 && zeileB < 0){
			System.out.println("ZeilenIndex out of Bounds! (Zeile "+zeileA+" und Zeile "+zeileB+")");
		}
		else{
			System.out.println("Tausch Zeile "+zeileA+" und Zeile "+zeileB);
			double[] tempA=new double[n];
			for(int q=0;q<n;q++){
				tempA[q]=a[zeileA][q];
			}
			for(int q=0;q<n;q++){
				a[zeileA][q]=a[zeileB][q];
			}
			for(int q=0;q<n;q++){
				a[zeileB][q]=tempA[q];
			}
			double tempB=b[zeileA];
			b[zeileA]=b[zeileB];
			b[zeileB]=tempB;
		}
	}
	public void ausgabe() {
		for(int q=0;q<n;q++) {
			for(int p=0;p<n;p++) {
				System.out.print(a[q][p]+"  ");
			}
			System.out.println(b[q]);
		}
		System.out.print("\n\n\n");
	}
}
