import io.github.mainstringargs.yahooFinance.YahooFinanceData;
import io.github.mainstringargs.yahooFinance.YahooFinanceModules;
import io.github.mainstringargs.yahooFinance.YahooFinanceRequest;
import io.github.mainstringargs.yahooFinance.YahooFinanceUrlBuilder;
import io.github.mainstringargs.yahooFinance.domain.FinancialData;

public class Yahoo  implements ConsultarYahoo {

    @Override
    public void consultar(String codigoEmpresa) {

        System.out.printf("Cotação da Empresa %s obtida pelo serviço Yahoo Finance: https://finance.yahoo.com%n", codigoEmpresa);
        YahooFinanceUrlBuilder builder =
                new YahooFinanceUrlBuilder().modules(YahooFinanceModules.values()).symbol(codigoEmpresa);

        YahooFinanceRequest request = new YahooFinanceRequest();
        YahooFinanceData financeData = request.getFinanceData(request.invoke(builder));

        FinancialData financials = financeData.getFinancialData();
        if (financials != null) {
            System.out.printf("Data: Preço: %s %s%n", financials.getFinancialCurrency(), financials.getCurrentPrice().getRaw());
        }

        System.out.println(builder.getURL());
        System.out.println("https://query1.finance.yahoo.com/v8/finance/chart/"+codigoEmpresa+"?period1=1546311600&period2=1556593200&interval=1d&includePrePost=False");
        System.out.println("---------------------------------------------------------------------");

    }
}
