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
public class Score {
    int id;
    String player1;
    String player2;
    String winner;
    Score(String p1,String p2,String Winner){
         player1=p1;
         player2=p2;
         winner=Winner;
    }
            
}
