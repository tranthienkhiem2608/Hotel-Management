package com.hotelManagementSystem.ChatSys.Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServerThread implements Runnable {

    private Socket socketOfServer;
    private int clientNumber;
    private String clientName;
    private BufferedReader is;
    private BufferedWriter os;
    private boolean isClosed;

    public BufferedReader getIs() {
        return is;
    }

    public BufferedWriter getOs() {
        return os;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public ServerThread(Socket socketOfServer, int clientNumber, String clientName) {
        this.socketOfServer = socketOfServer;
        this.clientNumber = clientNumber;
        this.clientName = clientName;
        System.out.println("Server thread number " + clientNumber + " " + clientName + " Started");
        isClosed = false;
    }

    @Override
    public void run() {
        try {
            // Mở luồng vào ra trên Socket tại Server.
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            System.out.println("Khời động luông mới thành công, ID là: " + clientNumber + " với tên là: " + clientName);
            write("get-id" + "," + this.clientNumber + "," + this.clientName);
            Server.serverThreadBus.sendOnlineList();
            Server.serverThreadBus.mutilCastSend("global-message"+","+this.clientName+" đã đăng nhập---");
            String message;
            while (!isClosed) {
                message = is.readLine();
                if (message == null) {
                    break;
                }
                String[] messageSplit = message.split(",");
                if(messageSplit[0].equals("send-to-global")){
                    Server.serverThreadBus.boardCast(this.getClientName(),"global-message"+","+messageSplit[3]+"(" + messageSplit[2]+"): "+messageSplit[1]);
                }
                if(messageSplit[0].equals("send-to-person")){// clientNumber, message, clientName, clientNumber loi co the o day
                    Server.serverThreadBus.sendMessageToPersion(messageSplit[4],messageSplit[3] +"(tới bạn): "+messageSplit[1]);
                }
            }
        } catch (IOException e) {
            isClosed = true;
            Server.serverThreadBus.remove(clientName);
            System.out.println(this.clientName+" đã thoát");
            Server.serverThreadBus.sendOnlineList();
            Server.serverThreadBus.mutilCastSend("global-message"+","+"---"+this.clientName+" đã thoát---");
        }
    }
    public void write(String message) throws IOException{
        os.write(message);
        os.newLine();
        os.flush();
    }
}