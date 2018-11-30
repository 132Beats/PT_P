package personal;

public abstract class Personal {
	String name;
	int gehalt;
	String einst_datum;
	int pid;
	Personal(String pname,int pgehalt,String peinst_datum,int ppid){
		name=pname;
		gehalt=pgehalt;
		einst_datum=peinst_datum;
		pid=ppid;
	}
	public void gehaltserhoehung(int prozent) {
		gehalt=gehalt+(gehalt*prozent/100);
	}
	public int getMoney() {
		return gehalt;
	}
	public abstract String toString();
}
