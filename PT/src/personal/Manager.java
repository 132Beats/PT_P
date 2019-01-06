package personal;

public class Manager extends Personal{
	int bonus=0;
	public Manager(String pname,int pgehalt,String peinst_datum,int ppid){
		super(pname,pgehalt,peinst_datum,ppid);
	}
	public void bonus(int bonusgehalt) {
		bonus=bonus+bonusgehalt;
	}
	public int getBonus() {
		return bonus;
	}
	public String toString() {
		return "Manager:"+name+","+gehalt+","+einst_datum+","+pid;
	}
}
