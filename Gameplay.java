import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Gameplay {

    public static int userOption = 0;

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        Random r = new Random();
        String word;

        int letterTest = 0;
        int lengthTest = 0;
        int existTest = 0;

        //game prep
        intro();

        //mode 1 gameplay
        if(userOption == 1){
            int randNum = r.nextInt(20);
            char given = intToChar(randNum);

            while (true) {

                int letterNum = r.nextInt(4) + 2;
                System.out.println(letterNum + " letter: " + given + " ");
                word = scan.nextLine();

                while (true) {
                    try {
                        found = wordFinder("fullDict.txt", word);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (word.charAt(0) != given) {
                        System.out.println("야! 이걸 틀린다고? 나는 자비로우니까 너에게 3번에 기회를 주지");
                        System.out.println(letterNum + " letter: " + given + " ");
                        word = scan.nextLine();
                        letterTest = 0;
                    } else
                        letterTest = 1;

                    if (found == false) {
                        System.out.println("야! 이걸 틀린다고? 나는 자비로우니까 너에게 3번에 기회를 주지");
                        System.out.println(letterNum + " letter: " + given + " ");
                        word = scan.nextLine();
                        existTest = 0;
                    } else
                        existTest = 1;

                    if (word.length() != letterNum) {
                        System.out.println("야! 이걸 틀린다고? 나는 자비로우니까 너에게 3번에 기회를 주지");
                        System.out.println(letterNum + " letter: " + given + " ");
                        word = scan.nextLine();
                        lengthTest = 0;
                    } else
                        lengthTest = 1;


                    if (lengthTest == 1 && existTest == 1 && letterTest == 1)
                        break;

                }//while loop

            }//while loop
        }

        //mode 2 gameplay
        if(userOption == 2) {
            while (true) {

                int randNum = r.nextInt(26);
                char given = intToChar(randNum);

                int letterNum = r.nextInt(5) + 2;

                System.out.println(letterNum + " letter: " + given + " ");
                word = scan.nextLine();

                while (true) {
                    try {
                        found = wordFinder("fullDict.txt", word);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (word.charAt(0) != given) {
                        System.out.println("야! 이걸 틀린다고? 나는 자비로우니까 너에게 3번에 기회를 주지");
                        System.out.println(letterNum + " letter: " + given + " ");
                        word = scan.nextLine();
                        letterTest = 0;
                    } else
                        letterTest = 1;

                    if (found == false) {
                        System.out.println("야! 이걸 틀린다고? 나는 자비로우니까 너에게 3번에 기회를 주지");
                        System.out.println(letterNum + " letter: " + given + " ");
                        word = scan.nextLine();
                        existTest = 0;
                    } else
                        existTest = 1;

                    if (word.length() != letterNum) {
                        System.out.println("야! 이걸 틀린다고? 나는 자비로우니까 너에게 3번에 기회를 주지");
                        System.out.println(letterNum + " letter: " + given + " ");
                        word = scan.nextLine();
                        lengthTest = 0;
                    } else
                        lengthTest = 1;


                    if (lengthTest == 1 && existTest == 1 && letterTest == 1)
                        break;

                }//while loop

            }//while loop
        }

    }


    //Introduction to game 
    public static void intro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================\n=======================================\n=======================================\n");
        System.out.println("   ***꿀잼끝말잇기 세상에 오신걸 환영합니다***\n");
        System.out.println("=======================================\n=======================================\n=======================================\n");

        int loopBreaker = 0;
        while(true) {
            while (true) {
                System.out.println("1. 게임시작\n2. 게임룰");
                try {
                    userOption = scanner.nextInt();
                    if (!(userOption == 1 || userOption == 2))
                        System.out.println("낭독증 의심해봐야...");
                    else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("낭독증 의심해봐야...");
                    scanner.next();
                }
            }

            if (userOption == 2) {
                System.out.println("|||||| 룰 설명 |||||||\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\n    알아서 " +
                        "터득하세여\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\nㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\n||||||| 이상 " +
                        "||||||||\n");
            }else{
                while (true) {
                    System.out.println("모드\n1. 일\n2. 이");
                    try {
                        userOption = scanner.nextInt();
                        if (!(userOption == 1 || userOption == 2))
                            System.out.println("낭독증 의심해봐야...");
                        else {
                            loopBreaker = 1;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("낭독증 의심해봐야...");
                        scanner.next();
                    }
                }//end while loop
            }
            if(loopBreaker == 1)
                break;
        }

    }

    //Finds the word and returns a boolean value
    public static boolean wordFinder(String fileName, String word) throws Exception{
        FileReader fr = new FileReader(fileName);
        BufferedReader bfr = new BufferedReader(fr);
        String read;
        boolean found = false;

        while((read = bfr.readLine()) != null){
            if(read.equals(word)){
                found = true;
                break;
            }
        }

        fr.close();
        bfr.close();

        return found;
    }

    public static char intToChar(int randNum){
        if(randNum == 0)
            return 'a';
        else if (randNum == 1)
            return 'b';
        else if (randNum == 2)
            return 'c';
        else if (randNum == 3)
            return 'd';
        else if (randNum == 4)
            return 'e';
        else if (randNum == 5)
            return 'f';
        else if (randNum == 6)
            return 'g';
        else if (randNum == 7)
            return 'h';
        else if (randNum == 8)
            return 'i';
        else if (randNum == 9)
            return 'j';
        else if (randNum == 10)
            return  'k';
        else if (randNum == 11)
            return 'l';
        else if (randNum == 12)
            return 'm';
        else if (randNum == 13)
            return 'n';
        else if (randNum == 14)
            return 'o';
        else if (randNum == 15)
            return 'p';
        else if (randNum == 16)
            return 'q';
        else if (randNum == 17)
            return 'r';
        else if (randNum == 18)
            return 's';
        else if (randNum == 19)
            return 't';
        else if (randNum == 20)
            return 'u';
        else if (randNum == 21)
            return 'v';
        else if (randNum == 22)
            return 'w';
        else if (randNum == 23)
            return 'x';
        else if (randNum == 24)
            return 'y';
        else
            return 'z';
    }


}

