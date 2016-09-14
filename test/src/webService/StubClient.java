package webService;

import java.rmi.RemoteException;

public class StubClient {
	public static void main(String[] args) throws RemoteException {
		SimpleServiceStub stub = new SimpleServiceStub();
		SimpleServiceStub.GetGreeting gg = new SimpleServiceStub.GetGreeting();
		gg.setArgs0("±È¶û");
		System.out.println(stub.getGreeting(gg).get_return());
		SimpleServiceStub.GetPrice getPrice = new SimpleServiceStub.GetPrice();
		System.out.println(stub.getPrice(getPrice).get_return());
	}
}
