package com.geowarin.mvc.base.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.mockito.internal.configuration.injection.filter.FinalMockCandidateFilter;
import org.springframework.stereotype.Component;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
	
	private List<Spitter> spitters;
	
	public SpitterRepositoryImpl() {
		spitters = new ArrayList<>();
	}

	@Override
	public void save(Spitter spitter) {
		if(spitter != null)
			spitters.add(spitter);
		
	}

	@Override
	public Spitter findByUsername(final String username) {
		// TODO Auto-generated method stub
		spitters.forEach(s -> System.out.println(s.getUsername()));
		Spitter filtered =  spitters.stream()
				.filter(spitter -> spitter.getUsername().equals(username))
				.collect(Collectors.toList())
				.get(0);
		System.out.println("filtered: " + filtered.getUsername());
		return filtered;
	}

}
