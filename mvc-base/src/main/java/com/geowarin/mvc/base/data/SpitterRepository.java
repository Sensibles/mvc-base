package com.geowarin.mvc.base.data;

public interface SpitterRepository {

	void save(Spitter spitter);
	Spitter findByUsername(final String username);
}
