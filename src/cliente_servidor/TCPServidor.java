package cliente_servidor;


import java.io.*; // classes para entrada e saída de dados
import java.net.*; // classes para socket, servidorsocket e clientesocket

class TCPServidor {
    public static void main(String argv[]) throws Exception {
        String mensagemCliente; // guarda a mensagem recebida do cliente
        String mensagemAlterada; // mensagem que será alterada para retornar ao cliente
        // cria socket de comunicação com os clientes na porta 3030
        ServerSocket socket = new ServerSocket(3030);
        // espera mensagem de algum cliente e trata
        System.out.println("- Esperando Cliente -");
        while(true){
            // espera a conexão de algum cliente
            Socket conexaoSocket = socket.accept();
            // cria streams de entrada e saída com o cliente que chegou
            BufferedReader cadeiaCliente = 
                    new BufferedReader (new InputStreamReader(conexaoSocket.getInputStream()));
            DataOutputStream servidorparaCliente =
                    new DataOutputStream(conexaoSocket.getOutputStream());
            // lê uma linha do cliente
            mensagemCliente = cadeiaCliente.readLine();
            // transforma a linha em maiúsculas
            mensagemAlterada = mensagemCliente.toUpperCase() + '\n';
            // exibe menssagem informada pelo cliente
            System.out.println("Mensagem do cliente :"+ mensagemCliente);
            // envia a mensagem maisúscula para o cliente
            servidorparaCliente.writeBytes(mensagemAlterada);
            // exibe mensagem de confirmação de envio para o cliente
            System.out.println("Resposta enviada ao cliente com sucesso! :");
        }
    }
}
