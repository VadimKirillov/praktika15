package sample;
import java.util.Scanner;
import java.util.ArrayList;


public class Drunk {
    //Два ArrayList для карт игроков
    static ArrayList<Integer> cards1 = new ArrayList<>();
    static ArrayList<Integer> cards2 = new ArrayList<>();

    static int turn = 0;

    public static void start(){
        Scanner scan = new Scanner(System.in);


        System.out.println("Введите карты игрока 1 :");
        String n = scan.nextLine();
        String [] card = n.split(" ");//используем разделители


        for (int i = 0; i < card.length ; i++) {
            int a = Integer.parseInt(card[i]);
            cards1.add(a);
        }

        System.out.println("Введите карты игрока 2 :");
        n = scan.nextLine();
        card = n.split(" ");

        for (int i = 0; i < card.length; i++) {
            int a= Integer.parseInt(card[i]);
            cards2.add(a);
        }

        System.out.println("Cтавки сделаны");
        System.out.println();

        while(cards1.size() != 0 && cards2.size() != 0){
            if(turn == 106){
                System.out.println("botva");//ограничитель ходов
                end();
                return;
            }
            turn++;
            round();
        }
        end();
    }


    public static void round(){

        //System.out.println("---------------------------");
        //System.out.println("Ход: " + turn);
        //System.out.println("Первый игрок:" + cards1.get(0) + " Второй игрок: "+ cards2.get(0));
        if(compare(cards1.get(0),cards2.get(0))){

            //System.out.println("Карты забирает игрок 1");

            cards1.add(cards1.get(0));//перемещаем в конец
            cards1.remove(0);

            cards1.add(cards2.get(0)); //забираем карту
            cards2.remove(0);

        }

        else{
            //System.out.println("Карты забирает второй игрок");
            cards2.add(cards2.get(0));//перемещаем в конец
            cards2.remove(0);

            cards2.add(cards1.get(0));
            cards1.remove(0);
        }
        //System.out.println();
    }

    //логика взаимодействия карт
    public static boolean compare(int a, int b){//True - первый игрок, иначе второй
        if(b==0 && a==9)
            return false;
        if((a==0 && b==9) || a>b)
            return true; //младшая карта тащит

        return false;
    }

    public static void end(){

        //выводим карты игроков
        /*
        System.out.println("Результат");
        System.out.print("Первый игрок: ");
        for (int a:cards1)
            System.out.print(a+" ");

        System.out.println();

        System.out.print("Второй игрок: ");
        for (int a:cards2
        ) {
            System.out.print(a+" ");

        }

         */

        if(cards1.size()==0)
            System.out.println("second win " + turn);
        if(cards2.size()==0)
            System.out.println("first win " + turn);

    }
}