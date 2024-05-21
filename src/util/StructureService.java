package util;
import java.util.Scanner;
import java.lang.*;

public class StructureService {
    static Scanner scanner = new Scanner(System.in);

    public static int readChoice(String prompt,int playerChoice){
        int input;
        do{
            System.out.print(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                //abnormal input handling
                input = -1;
                System.out.println(ColorText.colorText("Please Enter Valid Choice.",ColorText.RED));
            }
        }while(input > playerChoice || input < 1);
        return input;
    }

    public static String readChoice(String prompt, String[] playerChoice){
        String input;
        boolean validChoice = false;
        do{
            System.out.print(prompt);
            try{
                input = scanner.next();
                for(String choice: playerChoice){
                    if(input.equalsIgnoreCase(choice))
                        validChoice = true;
                }
                if(!validChoice)
                    System.out.println(ColorText.colorText("Please Enter Valid Choice.", ColorText.RED));
            }catch(Exception e){
                //abnormal input handling
                input = null;
            }
        }while(!validChoice);
        return input;
    }

    public static void clearScreen(){
        for(int i = 0; i < 20; i++){
            System.out.println();
        }
    }

    public static void lineSeperator(){
        System.out.print("+");
        for(int i = 0; i < 20; i++){
            System.out.print(ColorText.colorText("-",ColorText.BLUE));
        }
        System.out.print("+\n");
    }

    public static void continueGame(){
        System.out.println(ColorText.colorText("Press Any Key to Continue...",ColorText.BLUE));
        scanner.next();
    }

    public static void printHeading(String str){
        lineSeperator();
        System.out.println(ColorText.colorText(str,ColorText.CYAN));
        lineSeperator();
    }

}
