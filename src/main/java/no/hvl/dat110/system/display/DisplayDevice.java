package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;

import java.io.IOException;


public class DisplayDevice {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Display server starting ...");
		
		RPCServer displayServer = new RPCServer(Common.DISPLAYPORT);
		new DisplayImpl((byte)Common.WRITE_RPCID,displayServer);

		displayServer.run();
		displayServer.stop();
		
		System.out.println("Display server stopping ...");
		
	}
}
