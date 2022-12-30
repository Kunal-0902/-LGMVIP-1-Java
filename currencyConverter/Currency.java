package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {
	private String name;
	private String shortName;
	private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();

	public Currency(String nameValue, String shortNameValue) {
		this.name = nameValue;
		this.shortName = shortNameValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public HashMap<String, Double> getExchangeValues() {
		return this.exchangeValues;
	}

	public void setExchangeValues(String key, Double value) {
		this.exchangeValues.put(key, value);
	}

	public void defaultValues() {
		String currency = this.name;

		switch (currency) {
			case "Indian Rupee":
				this.exchangeValues.put("INR", 1.00);
				this.exchangeValues.put("USD", 0.012);
				this.exchangeValues.put("EUR", 0.011);
				this.exchangeValues.put("GBP", 0.010);
				break;
			case "US Dollar":
				this.exchangeValues.put("INR", 82.60);
				this.exchangeValues.put("USD", 1.00);
				this.exchangeValues.put("EUR", 0.94);
				this.exchangeValues.put("GBP", 0.83);
				break;
			case "Euro":
				this.exchangeValues.put("INR", 88.11);
				this.exchangeValues.put("USD", 1.07);
				this.exchangeValues.put("EUR", 1.00);
				this.exchangeValues.put("GBP", 0.88);
				break;
			case "British Pound Sterling":
				this.exchangeValues.put("INR", 99.56);
				this.exchangeValues.put("USD", 1.21);
				this.exchangeValues.put("EUR", 1.13);
				this.exchangeValues.put("GBP", 1.00);
				break;
		}
	}

	public static ArrayList<Currency> init() {
		ArrayList<Currency> currencies = new ArrayList<Currency>();

		currencies.add(new Currency("Indian Rupee", "INR"));
		currencies.add(new Currency("US Dollar", "USD"));
		currencies.add(new Currency("Euro", "EUR"));
		currencies.add(new Currency("British Pound", "GBP"));

		for (Integer i = 0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}

		return currencies;
	}

	public static Double convert(Double amount, Double exchangeValue) {
		Double price;
		price = amount * exchangeValue;
		price = Math.round(price * 100d) / 100d;

		return price;
	}
}