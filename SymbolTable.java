import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class SymbolTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("The letter options for your GPA are A+, A, A-, B+, B, B-, C+, C, C-, D, F");
        ArrayList<String> grades = new ArrayList<>();
        while(true){
            System.out.println("Enter a letter grade(type 'stop' when finished): ");
            String grade = input.nextLine().toUpperCase();
            if (grade.equals("STOP")) {
                break;
            }
            grades.add(grade);
        }
        calcGPA(grades.toArray(new String[0]));
    }
    private static void calcGPA(String... grades){
        Map<String, BigDecimal> GPA = new LinkedHashMap<>();
        GPA.put("A+", new BigDecimal("4.33"));
        GPA.put("A", new BigDecimal("4.00"));
        GPA.put("A-", new BigDecimal("3.67"));
        GPA.put("B+", new BigDecimal("3.33"));
        GPA.put("B", new BigDecimal("3.00"));
        GPA.put("B-", new BigDecimal("2.67"));
        GPA.put("C+", new BigDecimal("2.33"));
        GPA.put("C", new BigDecimal("2.00"));
        GPA.put("C-", new BigDecimal("1.67"));
        GPA.put("D", new BigDecimal("1.00"));
        GPA.put("F", new BigDecimal("0.00"));
        BigDecimal total = new BigDecimal("0");
        for(String grade: grades) {
            if (GPA.containsKey(grade)) {
                total = total.add(GPA.get(grade));
            } else {
                System.out.println("Invalid grade: " + grade);
            }
        }
        BigDecimal userGPA = total.divide(BigDecimal.valueOf(grades.length), 4, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#.##");
        String formatGPA = df.format(userGPA);
        System.out.println("Your GPA is: " + formatGPA);
    }
}