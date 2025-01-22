package disc;
import java.awt.Desktop;
import java.net.URI;

public class discgen {
    public static void main(String[] args) {
        try {
            for (int i = 1; i <= 10; i++) {
                String codigoGenerado = "eKtKbzrz7p94Jr" + i;
                String urlGift = "https://discord.com/gifts/" + codigoGenerado;

                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI(urlGift);
                    desktop.browse(uri);
                    System.out.println("Abriendo: " + urlGift);
                    Thread.sleep(2000);
                } else {
                    System.out.println("El escritorio no está soportado en este sistema.");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
