package personal;

public class Mitarbeiter extends Personal{
	public Mitarbeiter(String pname,int pgehalt,String peinst_datum,int ppid){
		super(pname,pgehalt,peinst_datum,ppid);
	}
	public String toString() {
		return "Mitarbeiter:"+name+","+gehalt+","+einst_datum+","+pid;
	}
}
