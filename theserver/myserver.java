/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.DataAccessLayer;

/**
 *
 * @author Nada
 */
class AcceptUsers extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static LinkedHashMap<String, AcceptUsers> ClientsMap = new LinkedHashMap<String, AcceptUsers>();
    static LinkedHashMap<String, String> openSessions = new LinkedHashMap<String, String>();//has opened sessions with player 1 as Key

    public AcceptUsers(Socket s) {
        try {
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            start();
        } catch (IOException ex) {
            Logger.getLogger(AcceptUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            String clientmessage = null;
            String[] values = null;
            try {
                while (ServerGUIBase.exit){
                clientmessage = dis.readLine();
                values = clientmessage.split(",");
                if (values[0].equals("login")) {
                    Set<String> onlineusersnames = ClientsMap.keySet();
                    Iterator<Map.Entry<String, AcceptUsers>> myiterator = ClientsMap.entrySet().iterator();
                    while (myiterator.hasNext()) {
                        Map.Entry<String, AcceptUsers> entry = myiterator.next();
                        AcceptUsers t = entry.getValue();
                        ServerGUIBase.UpdateOnlineUsers(onlineusersnames.toString());
                        t.ps.println(onlineusersnames.toString());
                        ps.flush();
                    }
                } else if (values[0].equals("logout")) {
                    AcceptUsers.ClientsMap.remove(values[1]);
                    Set<String> onlineusersnames = ClientsMap.keySet();
                    Iterator<Map.Entry<String, AcceptUsers>> myiterator = ClientsMap.entrySet().iterator();
                        ServerGUIBase.UpdateOnlineUsers(onlineusersnames.toString());
                    while (myiterator.hasNext()) {
                        Map.Entry<String, AcceptUsers> entry = myiterator.next();
                        AcceptUsers t = entry.getValue();
                        t.ps.println(onlineusersnames.toString());
                        ps.flush();
                    }
                } else if (values[0].equals("player1")) {
                    String player2 = AcceptUsers.openSessions.get(values[1]);
                    AcceptUsers t = AcceptUsers.ClientsMap.get(player2);
                    t.ps.println(values[0] + "," + values[2]);
                    ps.flush();
                } else if (values[0].equals("player2")) {
                    String player1 = "";
                    Iterator<Map.Entry<String, String>> myiterator = openSessions.entrySet().iterator();
                    while (myiterator.hasNext()) {
                        Map.Entry<String, String> entry = myiterator.next();
                        if (entry.getValue().equals(values[1])) {
                            player1 = entry.getKey();

                            break;
                        }
                    }
                    AcceptUsers t = AcceptUsers.ClientsMap.get(player1);
                    t.ps.println(values[0] + "," + values[2]);
                    ps.flush();
                } else if (values[0].equals("winner")) {//winner,player1/2,name
                    DataAccessLayer.SaveScore(values[2], AcceptUsers.openSessions.get(values[2]), values[2]);
                    DataAccessLayer.updateRecords(values[2], AcceptUsers.openSessions.get(values[2]));
                    if (values[1].equals("player1")) {
                        AcceptUsers t = AcceptUsers.ClientsMap.get(values[2]);//the player 1 itself
                        t.ps.println(values[0] + ",not a tie," + "You Won !!!" + "," + values[3]);
                        ps.flush();
                        t = AcceptUsers.ClientsMap.get(AcceptUsers.openSessions.get(values[2]));//get player 2 
                        t.ps.println(values[0] + ",not a tie" + "," + values[2] + " WON !!!" + "," + values[3]);
                        ps.flush();
                        AcceptUsers.openSessions.remove(values[2]);
                        ServerGUIBase.UpdateSessions(openSessions);
                    } else if (values[1].equals("noone")) {
                        if (AcceptUsers.openSessions.containsKey(values[2])) {
                            AcceptUsers t = AcceptUsers.ClientsMap.get(values[2]);
                            t.ps.println(values[0] + ",Its a Tie !");
                            ps.flush();
                            t = AcceptUsers.ClientsMap.get(AcceptUsers.openSessions.get(values[2]));//get player 2 
                            AcceptUsers.openSessions.remove(values[2]);
                            ServerGUIBase.UpdateSessions(openSessions);
                            t.ps.println(values[0] + ",Its a Tie !");
                            ps.flush();
                        } else {
                            AcceptUsers t = AcceptUsers.ClientsMap.get(values[2]);
                            t.ps.println(values[0] + ",Its a Tie !");
                            ps.flush();
                            Iterator<Map.Entry<String, String>> myiterator = openSessions.entrySet().iterator();
                            while (myiterator.hasNext()) {
                                Map.Entry<String, String> entry = myiterator.next();
                                if (entry.getValue().equals(values[2])) {
                                    t = AcceptUsers.ClientsMap.get(entry.getKey());//get player 2
                                    AcceptUsers.openSessions.remove(entry.getKey());
                                    ServerGUIBase.UpdateSessions(openSessions);
                                    t.ps.println(values[0] + ",Its a Tie !");
                                    ps.flush();
                                    break;
                                }
                            }

                        }
                    } else {
                        String player1 = "";
                        Iterator<Map.Entry<String, String>> myiterator = openSessions.entrySet().iterator();
                        while (myiterator.hasNext()) {
                            Map.Entry<String, String> entry = myiterator.next();
                            if (entry.getValue().equals(values[2])) {
                                player1 = entry.getKey();
                                break;
                            }
                        }
                        AcceptUsers t = AcceptUsers.ClientsMap.get(player1);
                        t.ps.println(values[0] + ",not a tie" + "," + values[2] + " Won !!!" + "," + values[3]);
                        ps.flush();
                        t = AcceptUsers.ClientsMap.get(values[2]);
                        t.ps.println(values[0] + ",not a tie" + "," + "You Won !!!" + "," + values[3]);
                        ps.flush();
                    }

                } else if (values[0].equals("register")) {
                    boolean found = DataAccessLayer.Register(values[1], values[2], values[3]);
                    if (found) {
                        AcceptUsers.ClientsMap.put(values[1], this);
                        AcceptUsers t = AcceptUsers.ClientsMap.get(values[1]);
                        t.ps.println("register,true");
                        ps.flush();
                    } else {
                        ps.println("register,false");
                        ps.flush();
                    }
                } else if (values[0].equals("loginplayer")) {
                    boolean found = DataAccessLayer.login(values[1], values[2]);
                    if (found) {
                        AcceptUsers.ClientsMap.put(values[1], this);
                        AcceptUsers t = AcceptUsers.ClientsMap.get(values[1]);
                        t.ps.println("login,true");
                        ps.flush();
                    } else {
                        ps.println("login,false");
                        ps.flush();
                    }
                } else if (values[0].equals("PlayRequest")) {
                    AcceptUsers t = AcceptUsers.ClientsMap.get(values[1]);
                    t.ps.println("PlayRequest," + values[2]);
                    ps.flush();
                } else if (values[0].equals("Confirm")) {
                    AcceptUsers.openSessions.put(values[2], values[1]);
                    ServerGUIBase.UpdateSessions(openSessions);
                    AcceptUsers t = AcceptUsers.ClientsMap.get(values[2]);
                    t.ps.println("Confirm," + values[2]);
                    ps.flush();
                } else if (values[0].equals("deny")) {
                    AcceptUsers t = AcceptUsers.ClientsMap.get(values[2]);
                    t.ps.println("deny," + values[1]);
                    ps.flush();
                } else if (values[0].equals("closed")) {//client suddenly closed ex: closed,client,nada,player1
                    if (values[3].equals("player1")) {
                        AcceptUsers t = AcceptUsers.ClientsMap.get(AcceptUsers.openSessions.get(values[2]));
                        AcceptUsers.openSessions.remove(values[2]);
                        ServerGUIBase.UpdateSessions(openSessions);
                        t.ps.println(values[0] + "," + values[2]);//send to client ex: closed,nada
                        ps.flush();
                    } else {
                        String player1 = "";
                        Iterator<Map.Entry<String, String>> myiterator = openSessions.entrySet().iterator();
                        while (myiterator.hasNext()) {
                            Map.Entry<String, String> entry = myiterator.next();
                            if (entry.getValue().equals(values[2])) {
                                player1 = entry.getKey();
                                break;
                            }
                        }
                        AcceptUsers t = AcceptUsers.ClientsMap.get(player1);
                        AcceptUsers.openSessions.remove(player1);
                        ServerGUIBase.UpdateSessions(openSessions);
                        t.ps.println(values[0] + "," + values[2]);//send to client ex: closed,nada
                        ps.flush();
                    }

                }
                }
            } catch (SocketException cs) {
                try {
                    dis.close();
                } catch (IOException ex) {
                    Logger.getLogger(AcceptUsers.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(AcceptUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

}

public class myserver {

    ServerSocket socketserver;

    public myserver() {
        try {
            socketserver = new ServerSocket(5005);
            while (true) {
                Socket s = socketserver.accept();
                new AcceptUsers(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(myserver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*  public static void main() {
        // TODO code application logic here
        new myserver();
    }*/
}
