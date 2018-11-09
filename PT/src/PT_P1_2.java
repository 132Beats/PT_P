import java.util.*;
/**	@author Hendrik Klein-Hitpaß
	@version 1.0
**/
public class PT_P1_2 {
	int n=3;
	double[][] a = new double[n][n]; //[Zeile][Spalte]
	double[] b = new double[n]; //[Zeile]
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
			zeilentausch(i,tauschpartnerFinden(i));
			ausgabe();
			auf1setzen(i);
			ausgabe();
			unterhalbAuf0setzen(i);
		}
		ausgabe();
		for(int q=n-2;q>=0;q--) {
			rechtsAuf0setzen(q);
			ausgabe();
		}
	}

/**	@param spalte In dieser Spalte soll das Betragshöchste Element gesucht werden
**/
	public int tauschpartnerFinden(int spalte) {
		int k=spalte;
		double l=Math.abs(a[spalte][spalte]);
		for(int j=spalte;j<n;j++){
			if(Math.abs(a[j][spalte])>l){
				l=Math.abs(a[j][spalte]);
				k=j;
			}
		}
		return k;
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
	
	/**	@param zeile Dieser Zeile soll so faktorisiert werden, dass das Element der Diagonalen 1 wird.
	**/
		public void auf1setzen(int zeile) {
			double teiler=a[zeile][zeile];
			for(int q=zeile;q<n;q++){
				a[zeile][q]=a[zeile][q]/teiler;
			}
			b[zeile]=b[zeile]/teiler;
		}

		/**	@param spalte Um in dieser Spalte die Elemente, die unter der Diagonalen liegen auf 0 zu bringen, werden Zeilen faktorisiert und subtrahiert.
		**/
		public void unterhalbAuf0setzen(int spalte) {
			for(int q=(spalte+1);q<n;q++) {
				double factor=a[q][spalte];
				for(int p=spalte;p<n;p++) {
					a[q][p]=a[q][p]-(a[spalte][p]*factor);
				}
				b[q]=b[q]-(b[spalte]*factor);
			}
		}

		/**	@param zeile Um in dieser Zeile die Elemente, die rechts von der Diagonalen liegen auf 0 zu bringen, werden bereits errechnete Werte eingesetzt und umgeformt.
		**/
		
		public void rechtsAuf0setzen(int zeile) {
			for(int p=zeile+1;p<n;p++) {
				b[zeile]=b[zeile]-(a[zeile][p]*b[p]);
				a[zeile][p]=0;
			}
		}
				
	public void ausgabe() {
		for(int q=0;q<n;q++) {
			for(int p=0;p<n;p++) {
				System.out.print(a[q][p]+"  ");
			}
			System.out.println(b[q]);
		}
		System.out.print("\n");
	}
}
