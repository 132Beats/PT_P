package verwaltung;

import java.util.ArrayList;

import personal.Manager;
import personal.Mitarbeiter;
import personal.Personal;

public class Personalverwaltung {
	ArrayList<Personal> personas;
	
	Personalverwaltung(){
		personas=new ArrayList<Personal>();
		personas.add(new Mitarbeiter("Schmeink",650,"1.1.2000",168,0));
		personas.add(new Manager("Graffe",850,"1.1.2008",170,1));
		personas.add(new Mitarbeiter("Schmitz",600,"1.1.2001",166,2));
		personas.add(new Manager("Hans",800,"1.1.2007",180,3));
		ausgabe();
		System.out.println("Sortiert nach Gehalt:");
		personas.sort((e1,e2) -> e1.compareTo(e2));
		ausgabe();
		personas.sort((e1,e2) -> e1.comparePersonal(e2));
		System.out.println("Sortiert nach Kleidergröße:");
	}
	
	public static void main(String[] args) {
		Personalverwaltung p=new Personalverwaltung();
		p.ausgabe();
	}

	public boolean istDoppelt() {
		if(!personas.isEmpty()) {
			for(int i=0;personas.size()>i;i++) {
				for(int j=i+1;personas.size()>j;j++) {
					if(personas.get(i).toString().equals(personas.get(j).toString())) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void ausgabe() {
		if(!personas.isEmpty()) {
			for(int i=0;personas.size()>i;i++) {
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
			for(i=0;personas.size()>i;i++) {
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
			for(i=0;personas.size()>i;i++) {
				if(personas.get(index).getMoney()>personas.get(i).getMoney()) {
					index=i;
				}
			}
			return personas.get(i);
		}
	}
}
