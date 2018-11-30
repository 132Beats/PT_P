package verwaltung;

import java.util.ArrayList;

import personal.Personal;

public class Personalverwaltung {
	ArrayList<Personal> personas;
	
	Personalverwaltung(){
		personas=new ArrayList<Personal>();
	}
	
	public static void main(String[] args) {
		Personalverwaltung p=new Personalverwaltung();
	}

	public boolean istDoppelt() {
		for(int i=0;personas.get(i)!=null;i++) {
			for(int j=i+1;personas.get(j)!=null;j++) {
				if(personas.get(i).toString().equals(personas.get(j).toString())) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void ausgabe() {
		for(int i=0;personas.get(i)!=null;i++) {
			System.out.println(personas.get(i).toString());
		}
	}
	public Personal highest() {
		if(personas.isEmpty()) {
			return null;
		}
		else {
			int max=personas.get(0).getMoney();
			int index=0;
			int i=0;
			for(i=0;personas.get(i)!=null;i++) {
				if(personas.get(index).getMoney()<personas.get(i).getMoney()) {
					index=i;
					max=personas.get(i).getMoney();
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
			int min=personas.get(0).getMoney();
			int index=0;
			int i=0;
			for(i=0;personas.get(i)!=null;i++) {
				if(personas.get(index).getMoney()>personas.get(i).getMoney()) {
					index=i;
					min=personas.get(i).getMoney();
				}
			}
			return personas.get(i);
		}
	}
}
