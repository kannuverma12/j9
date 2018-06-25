package com.j9.reactive;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;;

public class TestTransformer {

	public static void main(String... args) {
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
		MyTransformer<String, Integer> transformProcessor = new MyTransformer<>(Integer::parseInt);
		
		TestSubscriber<Integer> subscriber = new TestSubscriber<>();
	    List<String> items = List.of("1", "2", "3");
	    
	    List<Integer> expectedResult = List.of(1, 2, 3);
	    
	    publisher.subscribe(transformProcessor);
	    transformProcessor.subscribe(subscriber);
	    items.forEach(publisher::submit);
	    publisher.close();
	    
	}
}
