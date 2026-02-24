package src.hw_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class KWICServer {
   private static final int PORT = 5000;
   private boolean running = true;
   public LineStorage originalLines;

   public KWICServer(LineStorage var1) {
      this.originalLines = var1;
   }

   public void startServer() {
      System.out.println("KWIC Server starting on port 5000...");

      try {
         ServerSocket var1 = new ServerSocket(5000);

         try {
            while(this.running) {
               Socket var2 = var1.accept();
               System.out.println("Client connected: " + String.valueOf(var2.getInetAddress()));
               ClientHandler var3 = new ClientHandler(var2, this.originalLines);
               (new Thread(var3)).start();
            }
         } catch (Throwable var5) {
            try {
               var1.close();
            } catch (Throwable var4) {
               var5.addSuppressed(var4);
            }

            throw var5;
         }

         var1.close();
      } catch (IOException var6) {
         System.out.println("Server error: " + var6.getMessage());
         var6.printStackTrace();
      }

   }

   public void stopServer() {
      this.running = false;
      System.out.println("KWIC Server stopped.");
   }
}