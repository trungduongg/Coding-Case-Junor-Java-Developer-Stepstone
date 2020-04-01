package com.trungduong.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.net.HttpURLConnection;

@SpringBootApplication
public class OfficialStepstoneCcApplication {
	static final String kuser = "testuser";
	static final String kpass = "testpassword";

	static class RHAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return (new PasswordAuthentication(kuser, kpass.toCharArray()));
		}
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(OfficialStepstoneCcApplication.class, args);

			// get Input from User in Console
			Scanner in = new Scanner(System.in);
			String firstName, lastName;
			System.out.println("Welcome to the simple solution for Coding Case Junior Java Developer @ Stepstone");
			System.out.print("Insert first name: ");
			firstName = in.nextLine();
			System.out.print("Insert last name: ");
			lastName = in.nextLine();
			in.close();

			Authenticator.setDefault(new RHAuthenticator());
			URL url = new URL("https://reststop.randomhouse.com/resources/authors?lastName=" + lastName + "&firstName="
					+ firstName);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			InputStream is = con.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			// this string stores the xml string from the API
			String xmlstr = "";
			String str;
			while ((str = reader.readLine()) != null) {
				xmlstr += str;
				// System.out.println(str);
			}
			reader.close();

			// I used JAXB to read a XML string to object
			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(Authors.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

				Authors authors = (Authors) jaxbUnmarshaller.unmarshal(new StringReader(xmlstr));

				// Now when we have all the data in object authors, we will print only the data
				// we need

				System.out.println(authors.toString());
				System.out.println(
						"Thank you for this excercise and opportunity. I am looking forward to hear your opinion and feedback for me about this coding case soon :).");
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}

		catch (IOException e) {
			e.printStackTrace();

		}
	}
}
