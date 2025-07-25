package pgrm;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverterAPI 
{
    private static final String API_KEY = "26453197c96a0d37f876b833";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.println("Real-Time Currency Converter");

            System.out.print("Enter base currency (e.g. USD, INR, EUR): ");
            String baseCurrency = sc.next().toUpperCase();

            System.out.print("Enter target currency (e.g. USD, INR, EUR): ");
            String targetCurrency = sc.next().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = sc.nextDouble();

            String url = API_URL + baseCurrency;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            if (jsonResponse.get("result").getAsString().equals("success")) 
            {
                double rate = jsonResponse.getAsJsonObject("conversion_rates").get(targetCurrency).getAsDouble();
                double convertedAmount = amount * rate;

                System.out.printf("\n%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
            } 
            else 
            {
                System.out.println("Error fetching currency data.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
