
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 * Cliente socket.
 *
 * @author osmar
 */
public class ClienteSocket {

    /**
     * Realiza a comunicação com o servidor
     */
    public void comunicarComServidor() {
        try {
            //Leitura dos dados    
            String textoRequisicao = lerInformacaoPassagem();

            while (!textoRequisicao.trim().equalsIgnoreCase("fim")) {

                //Cria o socket com o servidor
                Socket socket = new Socket("localhost", 4444);
                //Cria o fluxo de saida para o socket
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                //Cria o fluxo de entrada para o socket
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Enviar mensagem para o servidor
                out.println(textoRequisicao);
                out.flush();

                // Receber mensagem do servidor
                String respostaServidor = in.readLine();
                System.out.println("respostaServer:" + respostaServidor);

                //Resposta a ser processada
                if (respostaServidor != null && !respostaServidor.equalsIgnoreCase("")) {
                    int codigoResposta = Integer.parseInt(respostaServidor.trim());
                    mostrarResultado(codigoResposta);
                }
                //Leitura dos próximos dados
                textoRequisicao = lerInformacaoPassagem();

            }
        } catch (IOException e) {
            System.out.println("Exceção:" + e);
        }

        System.out.println("Fim cliente socket!");
    }

    /**
     * Realiza a leitura das informações da passagem.
     *
     * @return
     */
    public String lerInformacaoPassagem() {
        int processo = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção: \n1 - Consulta voo \n2 - Marcação voo \n9 - Sair do cliente"));
        //Leitura dos dados da consulta do voo
        if (processo == 1) {
            String voo = JOptionPane.showInputDialog("Consulta:\nDigite o codigo do voo");
            String assento = JOptionPane.showInputDialog("Digite o assento:");
            //"C" é o prefixo de consulta de voo e assento
            return "C;" + voo + ";" + assento;
        } else {
            //Leitura dos dados marcação do voo
            if (processo == 2) {
                String voo = JOptionPane.showInputDialog("Marcação:\nDigite o codigo do ");
                String assento = JOptionPane.showInputDialog("Digite o assento:");
                //"M" é o prefixo de marcação de voo e assento
                return "M;" + voo + ";" + assento;
            } else {
                //Finaliza o servidor
                if (processo == 99) {
                    return "quit";
                } else {
                    //Finaliza o cliente
                    return "fim";
                }
            }
        }
    }

    /**
     * Mostra a reposta do servidor.
     *
     * @param respostaServidor
     */
    public void mostrarResultado(int respostaServidor) {
        switch (respostaServidor) {
            case 0:
                System.out.println("Voo e assento disponível");
                break;
            case 1:
                System.out.println("Assento indisponível");
                break;
            case 2:
                System.out.println("Assento inexistente");
                break;
            case 3:
                System.out.println("Voo inexistente");
                break;
            case 4:
                System.out.println("Assento marcado");
                break;
            default:
                System.out.println("Voo inexistente");
                break;
        }
    }
}
