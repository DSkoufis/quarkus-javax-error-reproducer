package org.acme.getting.started;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.math.BigDecimal;

import javax.money.Monetary;

import org.javamoney.moneta.Money;

import jakarta.inject.Named;

@Named("priceInjectionFailureNotifier")
public class MoneyResource implements RequestHandler<String, String> {

  @Override
  public String handleRequest(String input, Context context) {
    Money.of(new BigDecimal(1).movePointLeft(2), Monetary.getCurrency("USD"));
    return "ok";
  }
}
