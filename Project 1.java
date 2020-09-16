import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
    
    Scanner reader = new Scanner(System.in);
    
    System.out.println("Enter the mass of the water, in grams");
    double mass = reader.nextDouble();
    System.out.println("Enter the intial temperature, in Celsius");
    double initialTemp = reader.nextDouble();
    if(initialTemp < -273.14)
        initialTemp = -273.14;
    System.out.println("Enter the final temperature, in Celsius");
    double finalTemp = reader.nextDouble();
    if(finalTemp < -273.14)
        finalTemp = -273.14;
        
        String initialphase= "liquid";
        if(initialTemp < 0)
            initialphase ="Solid";
        if(initialTemp > 100)
            initialphase = "Vapor";
       
        String finalphase= "liquid";
        if(finalTemp < 0)
            finalphase ="Solid";
        if(finalTemp > 100)
            finalphase = "Vapor";
        
        System.out.println("Mass:" + mass + "g");
        System.out.println("Initial temperature: " + initialTemp + "c " + initialphase);
        System.out.println("Final temperature: " + finalTemp + "c " + finalphase);
        
        boolean endothermic = false;
        if (finalTemp > initialTemp)
        endothermic = true;
    }
    
    public static double tempChangeSolid(double mass, double startTemp, double endTemp, String endPhase,boolean endothermic){
        if(!endPhase.equals("solid"))
        endTemp = 0;
        double energyChange = round(mass*0.002108*(endTemp - startTemp));
        if(endothermic)
        System.out.println("Heading(Solid):" + energyChange + "kj");
        else
        System.out.println("Cooling(Solid):" + energyChange + "kj");
        return energyChange;
    }
    public static double tempChangeliquid(double mass, double startTemp, double endTemp, String endPhase,boolean endothermic){
        if(endPhase.equals("solid"))
        endTemp = 0;
        if(endPhase.equals("vapor"))
            endTemp = 100;
        double energyChange = round(mass*0.004184*(endTemp - startTemp));
        if(endothermic)
        System.out.println("Heading(liquid):" + energyChange + "kj");
        else
        System.out.println("Cooling(liquid):" + energyChange + "kj");
        return energyChange;
    }
    public static double tempChangevapor(double mass, double startTemp, double endTemp, String endPhase,boolean endothermic){
        if(endPhase.equals("vapor"))
        endTemp = 100;
        double energyChange = round(mass*0.001996*(endTemp - startTemp));
        if(endothermic)
        System.out.println("Heading(vapor):" + energyChange + "kj");
        else
        System.out.println("Cooling(vapor):" + energyChange + "kj");
        return energyChange;
    }
    
    public static double fusion(double mass, boolean endothermic){
        double energyChange;
        if(endothermic){
            energyChange = round(mass*0.333);
            System.out.println("Melting: " + energyChange + "kj");
        }
        else{
            energyChange = round(mass*-0.333);
            System.out.println("Freezing: " + energyChange + "kj");
        }
         return energyChange;
    }
    public static double vaporization(double mass, boolean endothermic){
        double energyChange;
        if(endothermic){
            energyChange = round(mass*2.257);
            System.out.println("Evaporating: " + energyChange + "kj");
        }
        else{
            energyChange = round(mass*-2.257);
            System.out.println("Condensation: " + energyChange + "kj");
        }
        return energyChange;
        
    }
    public static double round(double x){
        x *=1000;
        if (x>0)
            return(int)(x + 0.5)/1000.0;
        else
            return (int) (x-0.5) /1000.0;
    }
}
    
    

    
    
    
    
    
    