/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.testes.sistema;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vmvini
 */

public class ChromeTest {
    protected WebDriver driver;

    private String baseUrl;
    
    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        baseUrl = "http://localhost:8080/web/";
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        assertEquals("O titulo deve ser SrEstoque", "SrEstoque", driver.getTitle());
        
    }

}
