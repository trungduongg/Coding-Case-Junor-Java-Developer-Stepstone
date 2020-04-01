package com.trungduong.demo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.HttpURLConnection;;

@RestController
public class AuthorController {
	static final String kuser = "testuser";
	static final String kpass = "testpassword";

	static class RHAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return (new PasswordAuthentication(kuser, kpass.toCharArray()));
		}
	}

	//use the GET method to push the data received to localhost.
	@GetMapping
	public String method() {
		Authors authors = new Authors();
		try {
			Authenticator.setDefault(new RHAuthenticator());
			URL url = new URL("https://reststop.randomhouse.com/resources/authors?lastName="
					+ StepstoneCcApplication.lastName + "&firstName=" + StepstoneCcApplication.firstName);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			InputStream is = con.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String str;
			String xmlString = "";
			while ((str = reader.readLine()) != null) {
				xmlString += str;
			}
			reader.close();

			//Using JAXB to convert the string xml into object
			JAXBContext jaxbContext;
			
			try {
				jaxbContext = JAXBContext.newInstance(Authors.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

				authors = (Authors) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));

			} catch (JAXBException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			System.out.print("Error");
		}
		System.out.print(authors.toString());
		System.out.print("Please go to 'http://localhost:8080' with your brower or Postman to see the result.");
		//Send the data to localhost:8080
		return authors.toString();
	}

}
