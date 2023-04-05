/**
 * Programa principal.
 * 
 * @author osmar
 */
public class Principal {

    public static void main(String[] args) {
        try {
            ClienteSocket cliente = new ClienteSocket();
            cliente.comunicarComServidor();
        } catch (Exception e) {
            System.out.println("Exceção:" + e);
        }
    }
}
