/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Nada
 */
public class ClientController {

    Socket mysocket;
    DataInputStream dis = null;
    PrintStream ps = null;
    private static final ClientController clientcontroller = new ClientController();
    public String name;

    //private constructor to avoid client applications to use constructor
    private ClientController() {
        try {
            mysocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mysocket.getInputStream());
            ps = new PrintStream(mysocket.getOutputStream());

        } catch (IOException ex) {
            Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                    () -> {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Sorry Server is down ! Try again Later !", ButtonType.OK);
                        alert.show();
                    }
            );
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        String str = dis.readLine();
                        if (str.charAt(0) == '[') {
                            str = str.substring(1);
                            str = str.substring(0, str.length() - 1);
                            str = str.replaceAll("\\s+", "");
                            OnlineUsersBase.recievelistofname(str);
                        } else {
                            String[] values = str.split(",");
                            if (values[0].equals("winner")) {
                                if (values[1].equals("not a tie")) {
                                    GameBaseOnline.RecieveWinner(values[1] + "," + values[2] + "," + values[3]);
                                } else {
                                    GameBaseOnline.RecieveWinner(values[1]);
                                }
                            } else if ((values[0].equals("player1")) || (values[0].equals("player2"))) {
                                GameBaseOnline.Recievetheplay(str);
                            } else if (values[0].equals("register")) {
                                RegisterationOnlineBase.Registerrecieved(values[1]);
                            } else if (values[0].equals("login")) {
                                System.out.println(values[1]);
                                MultiOnlineLoginBase.Loginrecieved(values[1]);
                            } else if (values[0].equals("PlayRequest")) {
                                OnlineUsersBase.recieveplayrequest(values[1]);
                            } else if (values[0].equals("Confirm")) {
                                OnlineUsersBase.StartTheGame();
                            } else if (values[0].equals("deny")) {
                                OnlineUsersBase.RequestDenied(values[1]);
                            } else if (values[0].equals("closed")) {//client closed message ex: closed,name
                                GameBaseOnline.ClientClosed(values[1]);
                            }

                        }
                    } catch (SocketException s) {
                        try {
                            dis.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        }.start();
    }

    public static ClientController getInstance() {
        return clientcontroller;
    }

    public void sendloginnames(String name) {
        ps.println("login," + name);
        ps.flush();
    }

    public void sendwin(String winner) {
        ps.println("winner," + winner);//winner,player1/2,name
        ps.flush();
    }

    public void sendlogoutnames(String name) {
        ps.println("logout," + name);
        ps.flush();
    }

    public void sendplayer(String game) {
        ps.println(game);
        ps.flush();
    }

    public void registerPlayer(String name, String password, String email) {
        ps.println("register" + "," + name + "," + password + "," + email);
        ps.flush();

    }

    public void loginPlayer(String name, String password) {
        //Reconnet();
        ps.println("loginplayer" + "," + name + "," + password);
        ps.flush();
    }

    public void SendPlayRequest(String name, String player1) {
        ps.println("PlayRequest," + name + "," + player1);
        ps.flush();
    }

    public void RecievePlayConfirmation(String name, String player1) {
        ps.println("Confirm," + name + "," + player1);
        ps.flush();
    }

    public void RecieveDenial(String name, String player1) {
        ps.println("deny," + name + "," + player1);
        ps.flush();
    }

    public void SuddenlyClosed(String playerpos, String name) {
        ps.println("closed" + ",client," + name + "," + playerpos);//Message to server ex Closed  closed,client,nada,player1
        ps.flush();
    }

   
}
