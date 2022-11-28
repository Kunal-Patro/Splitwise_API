package org.iiitb.splitwise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iiitb.splitwise.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
@RequiredArgsConstructor
class SplitwiseApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("");
	}
	@Test
	void validLogin() {
		String loginURL = "http://localhost:8080/login";
		User request = new User();
		request.setEmail("aman@gmail.com");
		request.setPassword("password");
		log.info("Valid input : " + request);
		User response = restTemplate.postForObject(loginURL, request, User.class);
		log.info("Valid output : " + response);
		Assert.assertNotNull(response);
	}
	@Test
	void invalidLoginByPassword() {
		String loginURL = "http://localhost:8080/login";
		User request = new User();
		String randomPassword = UUID.randomUUID().toString().substring(0,7);
		System.out.println(randomPassword);
		request.setEmail("kunal@gmail.com");
		request.setPassword(randomPassword);

		log.info("invalid input : " + request);
		User response = restTemplate.postForObject(loginURL, request, User.class);
		log.info("invalid output : " + response);
		Assert.assertNull(response);
	}
	@Test
	void invalidLoginByEmail() {
		String loginURL = "http://localhost:8080/login";
		User request = new User();
		String randomEmail = UUID.randomUUID().toString().substring(0,7) + "@gmail.com";

		System.out.println(randomEmail);
		request.setEmail(randomEmail);
		request.setPassword("password");

		log.info("invalid input : " + request);
		User response = restTemplate.postForObject(loginURL, request, User.class);
		log.info("invalid output : " + response);
		Assert.assertNull(response);
	}
	@Test
	void validRegistration(){
			String registrationURL = "http://localhost:8080/register";
		String randomEmail = UUID.randomUUID().toString().substring(0,7) + "@gmail.com";
		User request = new User();
		request.setUsername(UUID.randomUUID().toString().substring(0,7));
		request.setPassword("sample5");
		request.setName("sample");
		request.setEmail(randomEmail);
		log.info("Valid input : " + request);
		User response = restTemplate.postForObject(registrationURL, request, User.class);
		log.info("Valid output : " + response);
		Assert.assertNotNull(response);
	}
	@Test
	void invalidRegistrationByEmail(){
		String registrationURL = "http://localhost:8080/register";
		String randomEmail = UUID.randomUUID().toString().substring(0,7) + "@gmail.";
		User request = new User();
		request.setUsername(UUID.randomUUID().toString().substring(0,7));
		request.setPassword("sample5");
		request.setName("sample");
		request.setEmail(randomEmail);
		log.info("invalid input : " + request);
		User response = restTemplate.postForObject(registrationURL, request, User.class);
		log.info("invalid output : " + response);
		Assert.assertNull(response);
	}
	@Test
	void invalidRegistrationByPassword(){
		String registrationURL = "http://localhost:8080/register";
		String randomEmail = UUID.randomUUID().toString().substring(0,7) + "@gmail.com";
		User request = new User();
		request.setUsername(UUID.randomUUID().toString().substring(0,7));
		request.setPassword("sample56789");
		request.setName("sample");
		request.setEmail(randomEmail);
		log.info("invalid input : " + request);
		User response = restTemplate.postForObject(registrationURL, request, User.class);
		log.info("invalid output : " + response);
		Assert.assertNull(response);
	}


}
