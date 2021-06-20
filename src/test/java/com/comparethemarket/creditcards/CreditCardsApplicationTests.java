package com.comparethemarket.creditcards;

import com.comparethemarket.creditcards.controller.CreditCardController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class CreditCardsApplicationTests {

	@Autowired
	private CreditCardController creditCardController;

	@Test
	void contextLoads() {
		Assertions.assertThat(creditCardController).isNotNull();
	}
}
