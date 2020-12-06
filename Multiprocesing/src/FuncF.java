//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FuncF {
    public FuncF() {
    }

    public static void main(String[] args) {
        Socket clientF = null;
        DataOutputStream output = null;
        DataInputStream input = null;

        try {
            clientF = new Socket("localhost", 2323);
            output = new DataOutputStream(clientF.getOutputStream());
            input = new DataInputStream(clientF.getInputStream());
            int testNumber = Integer.parseInt(input.readUTF());
            switch(testNumber) {
                case 1:
                    Thread.sleep(1000L);
                    output.writeByte(1);
                    break;
                case 2:
                    Thread.sleep(3000L);
                    output.writeByte(1);
                    break;
                case 3:
                    Thread.sleep(3000L);
                    output.writeByte(0);
                    break;
                case 4:
                    Thread.sleep(1000L);
                case 5:
                    Thread.sleep(1000L);
                    output.writeByte(1);
                    break;
                case 6:
                    while(true) {
                        Thread.sleep(1000L);
                    }
            }

            output.close();
            clientF.close();
        } catch (IOException var5) {
            System.out.println(var5);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }
}
