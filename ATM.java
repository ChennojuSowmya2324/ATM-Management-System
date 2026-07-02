import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome To ATM Machine");
        int password=2324;
        int balance=7000;
        int attempts=3;
        ArrayList<String> transactions=new ArrayList<>();
        //PIN verification 
        while (attempts>0){
            System.out.println("Enter your four digit PIN");
            int pin;
            try{
                pin=sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Invalid Input!");
                sc.nextInt();
                continue;
            }
            if (pin==password){
                System.out.println("PIN Accepted");
                while(true){
                    System.out.println("-----ATM MENU-----");
                    System.out.println("1.Check Blance");
                    System.out.println("2.Deposit Money");
                    System.out.println("3.WithDraw Money");
                    System.out.println("4.Mini Statement");
                    System.out.println("5.Exit");
                    System.out.println("---------------------");
                    System.out.println("Enter your choice 1 to 5");
                    
                    int choice;
                    try {
                        choice=sc.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Invalid input! Please Enter Number");
                        sc.next();
                        continue;
                    }
                    //Check balance
                    if (choice==1){
                        System.out.println("Your Balance:"+balance);
                    }
                    //Deposit Money
                    else if (choice==2){
                        System.out.println("Enter Amount To Deposit in rupees:");
                        int deposit=sc.nextInt();
                        if (deposit<=0){
                            System.out.println("Amount Must be Greater than zero");
                            
                        }
                        else{
                            balance+=deposit;
                            transactions.add("Depsited rupees"+deposit);
                            System.out.println("Deposited  Rupeer"+deposit+".New balance:Rs"+balance);
                        }
                    }
                    //Withdraw Money
                    else if(choice==3){
                        System.out.println("Enter Amount To withdraw: Rs");
                        int withdraw=sc.nextInt();
                        if(withdraw<=0){
                            System.out.println("Amount Must be Greater than 0");
                        }
                        else{
                            balance-=withdraw;
                            transactions.add("withdraw rupees"+withdraw);
                            System.out.println("Deposited  Rupeer"+withdraw+".Remaining balance:Rs"+balance);
                        }
                    }
                    //mini Statement
                    else if(choice==4){
                        System.out.println("\n Mini Statement");
                        if (transactions.isEmpty()){
                            System.out.println("No recent transactions");
                            
                        }
                        else{
                            int start=Math.max(transactions.size()-5,0);
                            for (int i=start; i<transactions.size();i++){
                                System.out.println("-"+transactions.get(i));
                            }
                        }
                        System.out.println("-----------------------------");
                        
                    }
                    else if (choice==5){
                        System.out.println("Thank you using ATM,Please Visit Again! ");
                        break;
                    }
                    else{
                        System.out.println("Please Enter number 1 to 5");
                    }
                }
                break;
            }
            //Wrong PIN
            else{
                attempts--;
                System.out.println("Incorrect PIN"+attempts+"Attempt(s) left");
                if (attempts==0){
                    System.out.println("Too Many attempts");
                }
            }
        }
        sc.close();
        
    }
}