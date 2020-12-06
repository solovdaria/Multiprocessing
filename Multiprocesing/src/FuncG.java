//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FuncG {
    public FuncG() {
    }

    public static void main(String[] args) {
        Socket clientG = null;
        DataOutputStream output = null;
        DataInputStream input = null;

        try {
            clientG = new Socket("localhost", 2323);
            output = new DataOutputStream(clientG.getOutputStream());
            input = new DataInputStream(clientG.getInputStream());
            int testNumber = Integer.parseInt(input.readUTF());
            switch(testNumber) {
                case 1:
                    Thread.sleep(3000L);
                    output.writeByte(1);
                    break;
                case 2:
                    Thread.sleep(1000L);
                    output.writeByte(1);
                    break;
                case 3:
                    Thread.sleep(1000L);
                case 4:
                    Thread.sleep(3000L);
                    output.writeByte(0);
                    break;
                case 5:
                    while(true) {
                        Thread.sleep(1000L);
                    }
                case 6:
                    Thread.sleep(1000L);
                    output.writeByte(1);
            }

            output.close();
            clientG.close();
        } catch (IOException var5) {
            System.out.println(var5);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }
}
