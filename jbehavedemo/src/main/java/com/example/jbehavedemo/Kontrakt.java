package com.example.jbehavedemo;

import java.util.ArrayList;

import com.example.jbehavedemo.NieudanyPsikusException;
import com.example.jbehavedemo.Psikus;

public class Kontrakt implements Psikus{

	public Integer cyfrokrad(Integer liczba) {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		while(liczba % 10 > 0){
			lista.add(liczba % 10);
			liczba /= 10;
		}
		
		if(lista.size() == 1){
			return null;
		}
		else{
			int zwracanaLiczba = 0;
			int losowaLiczba = (int) (Math.random() * lista.size());
			lista.remove(losowaLiczba);	
			
			for(int x = 0; x < lista.size(); x++){
				zwracanaLiczba += lista.get(x) * Math.pow(10, x);
			}
			return zwracanaLiczba;
		}
	}

	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
				
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		while(liczba % 10 > 0){
			lista.add(liczba % 10);
			liczba /= 10;
		}
		
		if(lista.size() == 1){
			throw new NieudanyPsikusException();
		}
		else{
			int zwracanaLiczba = 0;
			int losowaLiczba = (int) (Math.random() * lista.size());
			int losowaLiczba2 = 0;
			do{
				losowaLiczba2 = (int) (Math.random() * lista.size());
			}while(losowaLiczba == losowaLiczba2);
			
			int tmp = lista.get(losowaLiczba);
			lista.set(losowaLiczba, lista.get(losowaLiczba2));
			lista.set(losowaLiczba2, tmp);
			
			for(int x = 0; x < lista.size(); x++){
				zwracanaLiczba += lista.get(x) * Math.pow(10, x);
			}
			return zwracanaLiczba;
		}
	}

	public Integer nieksztaltek(Integer liczba) {
		
		int zwracanaLiczba = 0;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listaIndexowDoZmiany = new ArrayList<Integer>();
		
		
		while(liczba % 10 > 0){
			lista.add(liczba % 10);
			liczba /= 10;
		}
		for(int x = 0; x < lista.size(); x++){
			if(lista.get(x) == 3 || lista.get(x) == 7 || lista.get(x) == 6){
				listaIndexowDoZmiany.add(x);
			}
		}
		if(listaIndexowDoZmiany.isEmpty()){
			for(int x = 0; x < lista.size(); x++){
				zwracanaLiczba += lista.get(x) * Math.pow(10, x);
			}
			return zwracanaLiczba;
		}
		else{
			int losowaLiczba = (int) (Math.random() * listaIndexowDoZmiany.size());
			int indexDoZmiany = listaIndexowDoZmiany.get(losowaLiczba);
			int liczbaDoZmiany = lista.get(indexDoZmiany);
			switch(liczbaDoZmiany){
			case 3:
				lista.set(indexDoZmiany, 8);
				break;
			case 6:
				lista.set(indexDoZmiany, 9);
				break;
			
			case 7:
				lista.set(indexDoZmiany, 1);
				break;
			}
			for(int x = 0; x < lista.size(); x++){
				zwracanaLiczba += lista.get(x) * Math.pow(10, x);
			}
			return zwracanaLiczba;
		}
	}
}
