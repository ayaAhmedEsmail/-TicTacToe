/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Nada
 */
public class Player {

    String username;
    String password;
    String email;
    int win;
    int lose;

    Player(String name, String pass, String Email, int wines, int loses) {
        username = name;
        password = pass;
        email = Email;
        win = wines;
        lose = loses;
    }

}
