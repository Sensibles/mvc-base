package com.geowarin.mvc.base.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
	List<Spittle> spittles;	
	
	 public SpittleRepositoryImpl() {
		 spittles = new ArrayList<Spittle>();
		 for (int i=0; i < 10000; i++) {
		      spittles.add(new Spittle("Spittle " + i, new Date(), 0.0, 0.0));
		    }
	}

	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		 
		   
		    return spittles.subList(0, count);
	}

	@Override
	public Spittle findOne(long id) {	
			return spittles.get((int)id);	
	}

}
