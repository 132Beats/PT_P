package personal;

public abstract class Personal implements Comparable<Personal>,ComparablePersonal{
	String name;
	int gehalt;
	String einst_datum;
	int kleidergr;
	int pid;
	Personal(String pname,int pgehalt,String peinst_datum,int pkleidergr,int ppid){
		name=pname;
		gehalt=pgehalt;
		einst_datum=peinst_datum;
		kleidergr=pkleidergr;
		pid=ppid;
	}
	public void gehaltserhoehung(int prozent) {
		gehalt=gehalt+(gehalt*prozent/100);
	}
	public int getMoney() {
		return gehalt;
	}public int getKleidergr() {
		return kleidergr;
	}
	public int compareTo(Personal other) {
		return gehalt-other.getMoney();
	}
	public int comparePersonal(Personal other) {
		return kleidergr-other.getKleidergr();
	}
	public abstract String toString();
}
