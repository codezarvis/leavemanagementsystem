/**
 * 
 */
package com.lms.utils.ioc;

import org.apache.log4j.Logger;

import com.harshadura.gsm.smsdura.GsmModem;

/**
 * @author Sudarsan
 * 
 */
public class GsmWrite {

	private static Logger LOG = Logger.getLogger(GsmWrite.class);

	private static String port = "COM5"; // Modem Port.
	private static int bitRate = 115200; // this is also optional.

	// private static String modemName = "ZTE"; //this is optional.
	// private static String modemPin = "0000"; //Pin code if any have assigned
	// to the modem.
	private static String SMSC = "+919848001104"; // Message Center Number ex.
													// IDEA

	public void write(String mobileNumber, String messageText) {

		GsmModem gsmModem = new GsmModem();
		GsmModem.configModem(port, bitRate, null, null, SMSC);
		try {
			gsmModem.Sender(mobileNumber, messageText);

		} catch (Exception exception) {
			LOG.warn("GsmWrite", exception);
		}

	}
}
