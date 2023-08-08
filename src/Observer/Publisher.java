package Observer;

import java.util.LinkedList;
import java.util.List;


public interface Publisher {
   // List<Subscriber> subscribers = new LinkedList<Subscriber>();
	public void subscribe(Subscriber s) ;
	public void unsubscribe(Subscriber s) ;
	public void notifySubscribers() ;
}
