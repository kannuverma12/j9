package com.j9.reactive;

import java.util.concurrent.SubmissionPublisher;

import com.sun.tools.javac.util.List;

public class TestReactiveStreams {
	
	public static void main(String...strings ) {
		SubmissionPublisher<String> publisher = new SubmissionPublisher();
		TestSubscriber<String> subscriber = new TestSubscriber<String>();
		publisher.subscribe(subscriber);
		
		List<String> items = List.of("1","x","2","x","3","x");
		
		System.out.println("Subscribers = "+publisher.getNumberOfSubscribers());
		
		if(publisher.getNumberOfSubscribers() > 0) {
			items.stream().forEach(p -> publisher.submit(p));
		}
		
		publisher.close();
		
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Consumed Elements = "+subscriber.consumed);
		
	}
	

}


