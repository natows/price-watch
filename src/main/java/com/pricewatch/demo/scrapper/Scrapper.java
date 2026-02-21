package com.pricewatch.demo.scrapper;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service 
public class Scrapper { //works for sites with metadata

    public double scrapPrice(String httpLink){
        try{
            Document doc = Jsoup.connect(httpLink)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Language", "pl-PL,pl;q=0.9,en-US;q=0.8,en;q=0.7")
                .referrer("https://www.google.com")
                .timeout(10000)
                .followRedirects(true)
                .get();

            String priceText = doc.select("meta[property=product:price:amount]").attr("content");
            if (priceText.isEmpty()) {
                throw new RuntimeException("Price elem not found on site");
            }

            double price = Double.parseDouble(priceText);
            return price;
        }
        catch (IOException e) {
            throw new RuntimeException("Connection error");
        }
        catch (NumberFormatException e){
            throw new RuntimeException("error parsing price prolly wrong format");
        }

        
    }
    
}

