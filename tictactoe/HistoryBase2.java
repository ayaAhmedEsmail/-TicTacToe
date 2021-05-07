package tictactoe;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.Parent;
import javafx.scene.Scene;



import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class HistoryBase2 extends Pane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label winsLabel;
    protected final Label lossesLabel;
    protected final Button backBtn;
    protected final ListView Player1list;
    protected final ListView Player2list;
    protected final ListView Winnerlist;
    protected final ListView gamelist;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    Stage stage;
    
    Boolean gameRecorded =false;
   static String[] values;
    static ArrayList<String> arrList;
    String data;
    
    
    String nameOfFileSelected ;
    public HistoryBase2(Stage s) {
          stage =s;
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        winsLabel = new Label();
        lossesLabel = new Label();
        backBtn = new Button();
        Player1list = new ListView();
        Player2list = new ListView();
        Winnerlist = new ListView();
        gamelist = new ListView();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(224.0);
        label.setLayoutY(14.0);
        label.setText("Tic Tac Toe");
        label.setFont(new Font(31.0));

        label0.setLayoutX(75.0);
        label0.setLayoutY(75.0);
        label0.setText("Wins: ");
        label0.setFont(new Font(20.0));

        label1.setLayoutX(399.0);
        label1.setLayoutY(75.0);
        label1.setText("Losses:");
        label1.setFont(new Font(20.0));

        winsLabel.setLayoutX(128.0);
        winsLabel.setLayoutY(77.0);
        winsLabel.setText("0");
        winsLabel.setFont(new Font(17.0));

        lossesLabel.setLayoutX(467.0);
        lossesLabel.setLayoutY(77.0);
        lossesLabel.setText("0");
        lossesLabel.setFont(new Font(17.0));

        backBtn.setLayoutX(22.0);
        backBtn.setLayoutY(16.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        Player1list.setLayoutX(22.0);
        Player1list.setLayoutY(140.0);
        Player1list.setPrefHeight(249.0);
        Player1list.setPrefWidth(141.0);

        Player2list.setLayoutX(163.0);
        Player2list.setLayoutY(140.0);
        Player2list.setPrefHeight(249.0);
        Player2list.setPrefWidth(141.0);

        Winnerlist.setLayoutX(300.0);
        Winnerlist.setLayoutY(140.0);
        Winnerlist.setPrefHeight(249.0);
        Winnerlist.setPrefWidth(141.0);

        gamelist.setLayoutX(445.0);
        gamelist.setLayoutY(140.0);
        gamelist.setPrefHeight(249.0);
        gamelist.setPrefWidth(141.0);

        label2.setLayoutX(22.0);
        label2.setLayoutY(105.0);
        label2.setPrefHeight(31.0);
        label2.setPrefWidth(130.0);
        label2.setText("Player 1");

        label3.setLayoutX(163.0);
        label3.setLayoutY(110.0);
        label3.setPrefHeight(30.0);
        label3.setPrefWidth(130.0);
        label3.setText("Player 2");

        label4.setLayoutX(300.0);
        label4.setLayoutY(115.0);
        label4.setPrefHeight(21.0);
        label4.setPrefWidth(141.0);
        label4.setText("Winner");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(winsLabel);
        getChildren().add(lossesLabel);
        getChildren().add(backBtn);
        getChildren().add(Player1list);
        getChildren().add(Player2list);
        getChildren().add(Winnerlist);
        getChildren().add(gamelist);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        
                List<String> results = new ArrayList<String>();
                
                File[] files = new File("C:\\Users\\Nada\\Documents\\NetBeansProjects\\TicTacToe\\recordedgame").listFiles();
                for (File file : files) {
                    if (file.isFile())
                    {
                         
                           String []arrFileName=file.getName().split(",");
                             System.out.println(file.getName());
                            System.out.println("ana fe history if :"+file.getName());
                   
                        results.add(file.getName());
                       
                        if(arrFileName.length>=4&&!arrFileName[2].equals("null"))
                        {
                        Player1list.getItems().add(arrFileName[0]);
                            System.out.println("player 1 is : "+arrFileName[0]);
                        
                        Player2list.getItems().add(arrFileName[1]);
                        System.out.println("player 2 is : "+arrFileName[1]);
                        
                        Winnerlist.getItems().add(arrFileName[2]);
                        
                        System.out.println("winner is : "+arrFileName[2]);
                        gamelist.getItems().add(arrFileName[3]);
                        
                        System.out.println("game name is : "+arrFileName[3]);
                        
                        }
                        else
                              continue;
                    }
                    else
                    {
                        System.out.println("ana fe history else");
                    }
                }
                gamelist.setOnMouseClicked((event) -> {
                    
                 String v =gamelist.getSelectionModel().getSelectedItem().toString();
            
                    System.out.println("file selected is : "+v);
                    
                    if (!v.equals(null)) {
                        for (int i = 0; i < results.size(); i++) {
                            String[] f = results.get(i).split(",");
                            //System.out.println("f[2]: "+f[2]);
                            //System.out.println("f[3]: "+f[3]);
                            if (f[3].equals(v)) {
                                System.out.println("file name slected :" + results.get(i));
                                readFile(results.get(i));
                            }

                        }
                    }
        });
         backBtn.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
    }
    public void readFile(String fileName)
    {
        try
        {
        arrList = new ArrayList<>();
                  values=null;
                  // get selected file from user and put it in Construstor -> nameOfFileSelected
                File myObj = new File("recordedgame\\"+fileName);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                  //  System.out.println("History daata"+myReader.nextLine());
                     arrList.add(myReader.nextLine());
                    gameRecorded =true;
                }         
                   Parent newRoot = new GameBase(stage,gameRecorded);
                   Scene scene = new Scene(newRoot);
                    stage.setScene(scene);
                    myReader.close();
                    
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }
}
