package personal;

public class Mitarbeiter extends Personal{
	public Mitarbeiter(String pname,int pgehalt,String peinst_datum,int pkleidergr,int ppid){
		super(pname,pgehalt,peinst_datum,pkleidergr,ppid);
		System.out.println(test);
	}
	public String toString() {
		return "Mitarbeiter:"+name+","+gehalt+","+einst_datum+","+kleidergr+","+pid;
	}
	
}
