package verwaltung;

import java.util.HashMap;
import java.util.Map.Entry;

import personal.Manager;
import personal.Mitarbeiter;
import personal.Personal;

public class Personalverwaltung {
	HashMap<Integer, Personal> personas;
	
	Personalverwaltung(){
		personas=new HashMap<Integer,Personal>();
		personas.putIfAbsent(0,new Mitarbeiter("Schmeink",650,"1.1.2000",168,0));
		personas.putIfAbsent(1,new Manager("Graffe",850,"1.1.2008",170,1));
		personas.putIfAbsent(2,new Mitarbeiter("Schmitz",600,"1.1.2001",166,2));
		personas.putIfAbsent(3,new Manager("Hans",800,"1.1.2007",180,3));
		ausgabe();
	}
	
	public static void main(String[] args) {
		Personalverwaltung p=new Personalverwaltung();
		p.ausgabe();
		System.out.println(p.givePair().toString());
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
	public Pair<Personal> givePair() {
		Personal klein = null, groﬂ = null;
		if(!personas.isEmpty()) {
			klein = personas.get(0);
			groﬂ = personas.get(0);
			for(int i=0;personas.size()<i;i++) {
				if(personas.get(i).getMoney()>groﬂ.getMoney()) {
					groﬂ=personas.get(i);
				}
				else if(personas.get(i).getMoney()<klein.getMoney()) {
					klein=personas.get(i);
				}
			}
		}
		return new Pair<Personal>(klein,groﬂ);
	}
	
	public void ausgabe() {
		for(Entry<Integer, Personal> entry : personas.entrySet()) {
			System.out.println(entry.getValue().toString());
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
