/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class discgen {

    public static void main(String[] args) {
        String codigoGenerado = "eKtKbzrz7p94Jr95";
        String urlGift = "https://discord.com/gifts/" + codigoGenerado;
        
        if (esCanjeable(urlGift)) {
            System.out.println("El enlace es válido y puede canjearse.");
        } else {
            System.out.println("El enlace ya ha sido usado o es inválido.");
        }
    }

    public static boolean esCanjeable(String urlGift) {
        
        /*
        Asegúrate de que la ruta especificada en:
            System.setProperty("webdriver.chrome.driver", "ruta/a/tu/chromedriver.exe");
        sea correcta. Si chromedriver.exe está en la misma carpeta que tu archivo Java, puedes usar una ruta relativa, como:
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        O puedes especificar la ruta completa, por ejemplo:
            System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        */
        
        System.setProperty("webdriver.chrome.driver", "ruta/a/tu/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(urlGift);

            if (driver.getPageSource().contains("This gift has already been claimed")) {
                return false;
            }
            if (driver.getPageSource().contains("gift is invalid")) {
                return false;
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            driver.quit();
        }
    }
}
