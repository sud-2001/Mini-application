import java.util.*;



class Atm1 {
    private static final String At = null;

    private static Scanner sc;

    static int den[] = {1000,900,500,300,100,50};
    static int Adminlocker[] = {500,300,2,3,67,89};
    static int userlocker[]={0,0,0,0};
    static String username[]={"Sudharsana","jeyanthi","Haripriya"};
    static int userid[]={123,456,789};
    
    static int useramount[]={3000,4000,5000,6000};  
    static   String name;
    static int ch,ind,n,pin,amt,attempt=0;
    static void Firstpage(){
        sc=new Scanner(System.in);

       
        do {
            
            System.out.println("Welcome to ATM" + "\n" + "\n" + "1.Admin Login" + "\n" + "2.User Login" + "\n" + "3.Exit"+"\n"+"Enter your choice");
            
                ch = sc.nextInt();        
            switch (ch) {
                case 1:
                    Admin();
                    break;
                case 2:
                    Userpage();
                  
                    break;
                case 3:
                    System.exit(0);

            }

        }

        while (ch<=4);
    }

    

    static void Userpage(){
        System.out.println();
        System.out.println("Welcome to user login"+"\n"+"Enter Your User Name :");
        String username1=sc.next();
        System.out.println("Enter Your Pin Code ");
        int pin=sc.nextInt();
        
        
        for(int i=0;i<userid.length;i++){
            if(username1.equals(username[i])){
                ind=i;
            }
        }
        if (username1.equals(username[ind]) && pin == userid[ind]) {
            System.out.println("\033[H\033[2J");
            System.out.println("1. Withdrawal" + "\n" + "2. Balance enquiry"+"\n"+"3 Deposite"+"\n"+"4 Pin Change"+"\n"+"Enter your choice here:");
            int b = sc.nextInt();
            if (b == 1) {
                Userwithdraw();
            }    
            
             else if (b == 2) {
                System.out.println("\033[H\033[2J");
                System.out.println("your balance amount"+useramount[ind]);
                Userpage();
            }
            else if(b==3){
                Deposite();
                

            }
            else if(b==4){
                useridchange();


            }
            
            }
            else {
                System.out.println("Invalid Input");
                attempt++;
                
                if(attempt!=3){
                    
                       Userpage();

                }
                else{
                    System.out.println("Try again Later");
                    Firstpage();
                }
            }
            
        }
    

    
    static void Admin(){
        System.out.println("\033[H\033[2J");
        System.out.println("Welcome to Admin login"+"\n"+"Enter Your User Name");
                    name = sc.next();
                    System.out.println("Enter Your Pin Code");
                    pin = sc.nextInt();

                    if (name.equals("admin") && pin == 123){
                        System.out.println("\033[H\033[2J");
                        System.out.println("1 Add Money" + "\n" + "2 Show Balance"+"\n"+"Enter your choice ");
                    }
                    else{
                        System.out.println("\033[H\033[2J");
                        System.out.println("user name or user id is incorrect try again");
                        Admin();
                        
                    }    
                    int a = sc.nextInt();
                    if (a == 1) {
                        
                        addMoney();
                        
                    }
                    else if(a==2){
                        System.out.println("\033[H\033[2J");
                        System.out.println("Your balance amount:");
                        AdminViewbalance();
                    }

}
    static void Userwithdraw(){
        System.out.println("\033[H\033[2J");
                System.out.println("Enter your amount ");
                 amt=sc.nextInt();
                if(amt<=useramount[ind]){
                    System.out.println("\033[H\033[2J");
                System.out.println("please collect your cash");
                System.out.println("Are you want to check your balance "+"\n"+"if yes type 1 else 2:");
            
                int a=sc.nextInt();
                if(a==1){
                    System.out.println("your balance amount is:"+(useramount[ind]-amt));
                    Firstpage();
                    
                }
                else{
                    Firstpage();
                }
                Atmwithdraw();
                   
                }
                else{
                    System.out.println("Insufficient balance");
                    Userpage();
                
            }
        }
        static void Atmwithdraw(){
            while(amt!=0){
                    
                if(amt>2000){
                   n=amt/2000;
                    amt=amt-(n*2000);
                    Adminlocker[0]=Adminlocker[0]-n;

                }
                else if(amt>500){
                   n=(amt/500);
                    amt=amt-(n*500);
                    Adminlocker[1]=Adminlocker[1]-n;
                }
                else if(amt>200){
                    n=(amt/200);
                    amt=amt-(n*200);
                    Adminlocker[2]=Adminlocker[2]-n;
                }
                else if(amt>100){
                    n=(amt/100);
                    amt=amt-(n*100);
                    Adminlocker[3]=Adminlocker[3]-n;
                }
                else if(amt>50){
                    n=(amt/50);
                    amt=amt-(n*50);
                    Adminlocker[4]=Adminlocker[4]-n;
                  }
                  else if(amt>20){
                      n=(amt/20);
                      amt=amt-(n*20);
                      Adminlocker[5]=Adminlocker[5]-n;
                  }
                  else if(amt>10){

                    n=(amt/10);
                    amt=amt-(n*10);
                    Adminlocker[6]=Adminlocker[6]-n;
                  }
                }

        }
    

    static void Deposite(){
        System.out.println("\033[H\033[2J");
        System.out.println("Enter Denominations");

        for (int i = 0; i < 4; i++) {
            
            System.out.print("Enter No of  " + den[i]+" =");
            userlocker[i] = userlocker[i] + sc.nextInt();
            System.out.println(i);
        }
        System.out.println("\033[H\033[2J");
        System.out.println("Amount Added Successfully");
        System.out.println("Do you want to view you current balance : ");
        System.out.println("if yes enter 1 else enter 2");
        int f=sc.nextInt();
        if(f==1){
            Userbalance();

        }
        

    }
    static void Userbalance(){
        int sum=0;
        for(int i=0;i<userlocker.length;i++){
            System.out.println(den[i]+" = "+(userlocker[i]));
            sum=sum+(den[i]*(userlocker[i]));
        }
        sum=sum+useramount[ind];
        System.out.println("Your current balance is");
        System.out.println(sum);

}
    static void useridchange(){
        System.out.println("Enter your current pin");
                int chpin=sc.nextInt();
                if(chpin==userid[ind]){
                    System.out.println("Enter your new pin");
                    int npin=sc.nextInt();
                    System.out.println("Renter your new pin");
                    int npin1=sc.nextInt();
                    if(npin==npin1){
                        userid[ind]=npin;
                        System.out.println("your User id changed sucessfully");
                        
                    }
                    
                    
                }
                else{
                    System.out.println("User id not matched ");
                    
                }
    }

    
    static void AdminViewbalance(){
        int sum=0;
        for(int i=0;i<Adminlocker.length;i++){
            System.out.println(den[i]+" = "+(Adminlocker[i]));
            sum=sum+(den[i]*(Adminlocker[i]));
           


        }
        
        System.out.println("Over All Amount");
        System.out.println(sum);
        System.out.println("If you want to go back"+"\n"+" 1. admin page "+"\n"+"or"+"\n"+"2. exit"+"\n"+"enter your choice");
        int q=sc.nextInt();
        if(q==1){
            Admin();
        }
        else if(q==2){
            System.exit(0);
        }

        
        
        
        

    }

    static void addMoney() {
        System.out.println("\033[H\033[2J");
        System.out.println("Enter Denominations");

        for (int i = 0; i <Adminlocker.length; i++) {
            
            System.out.print("Enter No of  " + den[i]+" =");
            Adminlocker[i] = Adminlocker[i] + sc.nextInt();
            System.out.println(i);
        }
        System.out.println("\033[H\033[2J");
        System.out.println("Amount Added Successfully");
        System.out.println("Do you want to view you current balance : ");
        System.out.println("if yes enter yes else enter no");
        String opt = sc.next().charAt(0) + "";
        if (opt.equals("y")) {
            
            AdminViewbalance();
            

        }
        else{
            Admin();
        }
        
        
    }

    public static void main(String args[]) {
        Firstpage();

       
    
}
}
