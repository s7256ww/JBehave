package com.example.jbehavedemo;

import com.example.jbehavedemo.NieudanyPsikusException;

public interface Psikus {
	Integer cyfrokrad(Integer liczba);
	Integer hultajchochla(Integer liczba) throws NieudanyPsikusException;
	Integer nieksztaltek(Integer liczba);
}
