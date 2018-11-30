package personal;

public class Manager extends Personal{
	public Manager(String pname,int pgehalt,String peinst_datum,int ppid){
		super(pname,pgehalt,peinst_datum,ppid);
	}
	public void bonus(int bonusgehalt) {
		gehalt=gehalt+bonusgehalt;
	}
	public String toString() {
		return "Manager:"+name+","+gehalt+","+einst_datum+","+pid;
	}
}
