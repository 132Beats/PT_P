package verwaltung;

import java.util.ArrayList;

import personal.Manager;
import personal.Mitarbeiter;
import personal.Personal;

public class Personalverwaltung {
	ArrayList<Personal> personas;
	
	Personalverwaltung(){
		personas=new ArrayList<Personal>();
		personas.add(new Mitarbeiter("Schmeink",650,"1.1.2000",0));
		personas.add(new Manager("Graffe",850,"1.1.2008",0));
	}
	
	public static void main(String[] args) {
		Personalverwaltung p=new Personalverwaltung();
	}

	public boolean istDoppelt() {
		if(!personas.isEmpty()) {
			for(int i=0;personas.size()<i;i++) {
				for(int j=i+1;personas.get(j)!=null;j++) {
					if(personas.get(i).toString().equals(personas.get(j).toString())) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public void givePair() {
		if(!personas.isEmpty()) {
			Personal klein = personas.get(0);
			Personal groß = personas.get(0);
			for(int i=0;personas.size()<i;i++) {
				
			}
		}
	}
	public void ausgabe() {
		if(!personas.isEmpty()) {
			for(int i=0;personas.size()<i;i++) {
				System.out.println(personas.get(i).toString());
			}
		}
	}
	public Personal highest() {
		if(personas.isEmpty()) {
			return null;
		}
		else {
			int index=0;
			int i=0;
			for(i=0;personas.size()<i;i++) {
				if(personas.get(index).getMoney()<personas.get(i).getMoney()) {
					index=i;
				}
			}
			return personas.get(i);
		}
	}
	public Personal lowest() {
		if(personas.isEmpty()) {
			return null;
		}
		else {
			int index=0;
			int i=0;
			for(i=0;personas.size()<i;i++) {
				if(personas.get(index).getMoney()>personas.get(i).getMoney()) {
					index=i;
				}
			}
			return personas.get(i);
		}
	}
}
