package com.comparethemarket.creditcards.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void validVISACreditCard() {
        String url = "http://localhost:" + port + "/creditcard/4111111111111111";
        String expected = "VISA: 4111111111111111 (valid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }

    @Test
    public void inValidVISACreditCard() {
        String url = "http://localhost:" + port + "/creditcard/4111111111111";
        String expected = "VISA: 4111111111111 (invalid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }

    @Test
    public void validVISACreditCard2() {
        String url = "http://localhost:" + port + "/creditcard/4012888888881881";
        String expected = "VISA: 4012888888881881 (valid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }

    @Test
    public void validAMEXCreditCard() {
        String url = "http://localhost:" + port + "/creditcard/378282246310005";
        String expected = "AMEX: 378282246310005 (valid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }

    @Test
    public void validDiscoverCreditCard() {
        String url = "http://localhost:" + port + "/creditcard/6011111111111117";
        String expected = "Discover: 6011111111111117 (valid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }

    @Test
    public void validMasterCardCreditCard() {
        String url = "http://localhost:" + port + "/creditcard/5105105105105100";
        String expected = "MasterCard: 5105105105105100 (valid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }

    @Test
    public void inValidMasterCardCreditCard() {
        String url = "http://localhost:" + port + "/creditcard/5105 1051 0510 5106";
        String expected = "MasterCard: 5105 1051 0510 5106 (invalid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }

    @Test
    public void inValidUnknownCreditCard() {
        String url = "http://localhost:" + port + "/creditcard/9111111111111111";
        String expected = "Unknown: 9111111111111111 (invalid)";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains(expected);
    }
}