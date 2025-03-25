
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;

import java.util.Scanner;


    public static void main(String[] args) {
        boolean program = true;
        System.out.println("Escriba 'help' para obtener los comandos");
        while (program) {
            Scanner comand = new Scanner(System.in);

            System.out.print("> ");
            String opcion = comand.nextLine();
            switch (opcion){
                case "help":
                    helpComand();
                    break;
                case "exit":
                    program = false;
                    comand.close();
                    break;
                case "github":
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter your username: ");
                    String username = scanner.nextLine();
                    String url = "https://api.github.com/users/" + username ;
                    Github_information(url);
            }
        }

}

public static void helpComand(){
    System.out.println("'exit' para terminar el programa");
    System.out.println("'github' para obtener la informacion de github");
}
private static void Github_information(String url){
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder().url(url).build();
    try(Response response = client.newCall(request).execute()){
        if(response.isSuccessful() && response.body() != null){
            String JSON = response.body().string();
                System.out.println(JSON);
        }else{
            System.out.println("Error: " + response.code());
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}



