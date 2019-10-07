//10/6/2019
//prints calander given input form command line
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Exercise13_04 {
    public static void main(String [] args){
        //check proper input
        if(args.length != 2){
            System.out.println("correct usage: java Exercise13_04.java month year");
            System.exit(1);
        }

        //creates new calander object
        Calendar myCalendar = new GregorianCalendar(Integer.valueOf(args[1]), Integer.valueOf(args[0]) - 1, 1);
        //displays calander
        dispCalander(myCalendar);


    }
    public static void dispCalander(Calendar myCalander){
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        //prints header
        System.out.println(months[myCalander.MONTH] + ", " + myCalander.get(myCalander.YEAR));

        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        System.out.println(String.format("%27s","-").replace(' ', '-'));
        for(int i=0; i<weekDays.length; i++){
            System.out.printf("%s ",weekDays[i]);
        }

        System.out.println();
        int j=1;
        //skips days until reaching first day of month
        while(myCalander.get(myCalander.DAY_OF_WEEK) != j){
            System.out.printf("%4s", " ");
            j++;
        }
        for(int i=0; i<myCalander.getActualMaximum(myCalander.DAY_OF_MONTH); i++){
            System.out.printf("%3s ", myCalander.get(myCalander.DAY_OF_MONTH));
            if(myCalander.get(myCalander.DAY_OF_WEEK) == 7){
                System.out.println();
            }
            myCalander.add(Calendar.DAY_OF_MONTH,1);

        }
    }
}


