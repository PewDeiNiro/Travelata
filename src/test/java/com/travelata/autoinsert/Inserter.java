package com.travelata.autoinsert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Inserter {

    public final String URL = "https://payment.travelata.ru/order/checkoutRaffle/raffle-cuba/1c457b1f-b71f-4852-92de-2e0247ec3c41";
    public final String PAYMENT = "https://payment.travelata.ru/order/checkoutRaffle/raffle-cuba/1c457b1f-b71f-4852-92de-2e0247ec3c41";
    int countTickets = 80;

    @Test
    public void insert(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");


        for (int i = 0; i < countTickets; i++) {
            ChromeDriver site = new ChromeDriver();
            site.get(URL);
            WebElement cardDataPan = site.findElement(By.id("cardDataPan")); //number of card
            WebElement cardDataMonth = site.findElement(By.id("cardDataMonth")); //08
            WebElement cardDataYear = site.findElement(By.id("cardDataYear")); //24
            WebElement cardDataCardholder = site.findElement(By.id("cardDataCardholder")); //FIO
            WebElement email = site.findElement(By.id("email")); //email
            WebElement phoneNumber = site.findElement(By.id("phoneNumber")); //phone number
            WebElement cardDataCvv = site.findElement(By.id("cardDataCvv")); //cvv
            WebElement button = site.findElement(By.className("lottery-pay-bottom-block__btn"));

            String startedTitle = "Травелата - интернет магазин туров - купить горящий тур!";
            try {
                Assert.assertTrue(startedTitle == site.getTitle());
            } catch (AssertionError e) {
            }
            try {
                Thread.sleep(8000);
            } catch (Exception e) {
            }

            cardDataPan.sendKeys("2200 0202 0957 1563");
            cardDataMonth.sendKeys("08");
            cardDataYear.sendKeys("24");
            cardDataCardholder.sendKeys("TATYANA SVETLITSKAYA");
            email.sendKeys("alfamuse@gmail.com");
            phoneNumber.sendKeys("9782048552");
            cardDataCvv.sendKeys("497");
            button.click();

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) { }
            site.close();
        }


    }

    public static void main(String[] args) {

    }

}
