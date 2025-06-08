package TestngTopics;

import org.testng.annotations.Test;

public class TicketsBookings {
	private static int tickets = 1; // We assume only 1 ticket is available to simulate competition.

	//make sure that only one thread can execute the book() method at a time. This will prevent both the users from getting the same ticket.
	public static synchronized void book(String user) {
		if (tickets > 0) { //If a ticket is available, it is booked and ticket count is decreased.
			System.out.println(user + " successfully booked the ticket.");
			tickets--;
		} else {
			System.out.println(user + " failed to book No tickets left.");
		}
	}
	@Test
	public void bookTicket() {

		//It will Fetch the name of the thread running this test. Since we’re running the test in parallel, there will be multiple threads.
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " is trying to book the ticket");
		TicketsBookings.book(threadName);
	}
}