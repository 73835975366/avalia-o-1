import java.util.Scanner;

public class SistemaEscolar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] notas = new double[8];

        System.out.println("--- Cálculo de Médias Escolares ---");

        
        for (int i = 0; i < 8; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        
        double media1Bimestre = (notas[0] + notas[1]) / 2;
        double media2Bimestre = (notas[2] + notas[3]) / 2;
        double media3Bimestre = (notas[4] + notas[5]) / 2;
        double media4Bimestre = (notas[6] + notas[7]) / 2;

        
        double media1Semestre = (media1Bimestre + media2Bimestre) / 2;
        double media2Semestre = (media3Bimestre + media4Bimestre) / 2;

        
        double mediaFinal = (media1Semestre + media2Semestre) / 2;

        
        System.out.println("\n--- Resultados ---");

        System.out.printf("1º Bimestre: %.1f%n", media1Bimestre);
        System.out.printf("2º Bimestre: %.1f%n", media2Bimestre);
        System.out.printf("1º Semestre: %.1f%n", media1Semestre); 
        System.out.println(); 
        System.out.printf("3º Bimestre: %.1f%n", media3Bimestre);
        System.out.printf("4º Bimestre: %.1f%n", media4Bimestre);
        System.out.printf("2º Semestre: %.1f%n", media2Semestre); 
        System.out.println(); 
        System.out.printf("Média Final: %.1f%n", mediaFinal);

        scanner.close(); 
    }
}