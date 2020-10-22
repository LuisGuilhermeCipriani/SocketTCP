package cliente_servidor;


import java.io.*; // classes para entrada e saída de dados
import java.net.*; // classes para socket, servidorsocket e clientesocket

class TCPCliente {
    public static void main(String argv[]) throws Exception {
        String mensagem; // guarda a mensagem digitada pelo cliente
        String mensagemModificada; // guarda a mensagem modificada pelo servidor
        // cria o steam do teclado
        BufferedReader cadeiaUsuario = new BufferedReader(new InputStreamReader(System.in));
        // cria o socket de acesso ao servidor na porta 3030
        Socket clienteSocket = new Socket("localhost", 3030); // localhost = 127.0.0.1 (Endereço da máquina)
        // exibe endereço e porta na tela
        System.out.println("Conectado a: " + clienteSocket.getRemoteSocketAddress());
        // cria os streams de entrada e saída com o servidor
        DataOutputStream clienteParaServidor =
                new DataOutputStream(clienteSocket.getOutputStream());
        BufferedReader cadeiaServidor = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        // solicita um exemplo de informação ao cliente
        System.out.print("\nQual é o seu nome: ");
        // lê uma linha do teclado e coloca em mensagem
        mensagem = cadeiaUsuario.readLine();
        // envia a mensagem para o servidor
        clienteParaServidor.writeBytes(mensagem + '\n');
        // lê a resposta do servidor
        mensagemModificada = cadeiaServidor.readLine();
        // exibe a mensagem resposta do servidor na tela
        System.out.println("Resposta do servidor " + mensagemModificada);
        // fecha o cliente
        clienteSocket.close();
    }
}
