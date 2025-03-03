import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
public class InflationRate {
    public static void main(String[] args) {
        final BigDecimal ONE_HUNDRED = new BigDecimal("100");
        Map<String, BigDecimal> eggPrice = new LinkedHashMap<>();
        eggPrice.put("Jan", new BigDecimal("3.68"));
        eggPrice.put("Feb", new BigDecimal("4.11"));
        eggPrice.put("March", new BigDecimal("4.13"));
        eggPrice.put("April", new BigDecimal("4.65"));
        eggPrice.put("May", new BigDecimal("4.69"));
        eggPrice.put("June", new BigDecimal("4.77"));
        eggPrice.put("Aug", new BigDecimal("4.80"));
        eggPrice.put("Sep", new BigDecimal("4.95"));
        eggPrice.put("Oct", new BigDecimal("4.89"));
        eggPrice.put("Nov", new BigDecimal("5.49"));
        eggPrice.put("Dec", new BigDecimal("6.88"));
        String firstMonth = eggPrice.keySet().iterator().next();
        String lastMonth = (String) eggPrice.keySet().toArray()[eggPrice.size() - 1];
        BigDecimal firstPrice = eggPrice.get(firstMonth);
        BigDecimal lastPrice = eggPrice.get(lastMonth);
        BigDecimal inflationRate = ((lastPrice.subtract(firstPrice)).divide(firstPrice, 4, RoundingMode.HALF_UP)).multiply(ONE_HUNDRED);
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedRate = df.format(inflationRate);
        System.out.println("Initial price in January for a dozen eggs was " + firstPrice);
        System.out.println("Final price in December for a dozen eggs was " + lastPrice);
        System.out.println("The inflation rate from the year is " + formattedRate + "%");
    }
}