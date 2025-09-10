import java.util.Scanner;public class ConversorTemperature {



public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);



System.out.print("Digite a temperatura em graus Celsius (°C): ");

double celsius = scanner.nextDouble();



double fahrenheit = (celsius * 9/5) + 32;



double kelvin = celsius + 273.15;



System.out.println("\n--- Resultados da Conversão ---");

System.out.printf("Temperatura em Celsius: %.1f °C%n", celsius);

System.out.printf("Temperatura em Fahrenheit: %.1f °F%n", fahrenheit);

System.out.printf("Temperatura em Kelvin: %.2f K%n", kelvin);



scanner.close();

}

}
