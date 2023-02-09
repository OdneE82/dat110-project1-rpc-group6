package no.hvl.dat110.messaging;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[128];
		byte[] data;

		data = message.getData();
		int length = data.length;
		segment[0] = (byte) length;
		for(int i = 0; i < length; i++) {
			segment[i+1] = data[i];
		}

		return segment;
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		int length = segment[0];

		byte[] decapsulated = new byte[length];

		for(int i = 0; i < length; i++) {
			decapsulated[i] = segment[i+1];
		}
		message = new Message(decapsulated);

		return message;
	}
	
}
