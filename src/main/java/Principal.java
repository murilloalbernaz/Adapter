//Quandl

//YahooFinance

//AlphaVantage


/**
 * Classe principal que mostra como obter a cotação de empresas da bolsa de valores
 * utilizando 3 serviços diferentes: Yahoo Finance, AlphaVantage e Quandl.
 * Os métodos implementados tem todo o código para utilizar as bibliotecas
 * que implementam o acesso a tais serviços.
 * Mas como podem ver, o código dos 3 métodos é totalmente diferente um do outro.
 * Ou seja, a forma de usar cada uma das bibliotecas é diferente.
 * Por isso, é preciso criar um adapter para padronizar a utilização das bibliotecas
 * e permitir trocar uma pela outra sem alterar o código do projeto.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {

    public static void main(String[] args) {
        System.out.println();
        consultaDefinida("AAPL", "Alpha");

        //No Yahoo Finance, as empresas brasileiras terminam com ".sa"
        //cotacaoUsandoYahooFinance("MGLU3.SA"); //MGLU3 = Magazine Luiza

        //cotacaoUsandoAlphaVantage("INTL"); //INTL = Intel
        //cotacaoUsandoQuandl("WIKI/AAPL"); //AAPL = Apple
    }

    private static void consultaDefinida(String consulta, String empresaUsar){
        if(empresaUsar == "yahoo") {
            Yahoo y = new Yahoo();
            ConsultaAcao yahooadpter = new YahooAdpter(y);
            consultarAcao(yahooadpter, consulta);
        }else {
            if (empresaUsar == "Alpha"){
                AlphaVantage p = new AlphaVantage();
                ConsultaAcao alphaVantage = new AlphaVantageAdpter(p);
                consultarAcao(alphaVantage, consulta);
            }else{
                Quandl q = new Quandl();
                ConsultaAcao quandl = new QuandlAdpter(q);
                consultarAcao(quandl, consulta);
            }

        }

    }
    private static void consultarAcao(ConsultaAcao c, String consulta){
        c.consultarAcaoTodas(consulta);
    }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://finance.yahoo.com">Yahoo Finance</a>
     * por meio da biblioteca <a href="https://github.com/mainstringargs/yahoo-finance-scraper">Yahoo Finance Scrapper</a>.
     * @param codigoEmpresa
     * @see <a href="http://meumobi.github.io/stocks%20apis/2016/03/13/get-realtime-stock-quotes-yahoo-finance-api.html">Get realtime stock quotes yahoo finance API</a>
     */
    private static void cotacaoUsandoYahooFinance(String codigoEmpresa) {}

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://www.alphavantage.co">AlphaVantage</a>
     * por meio da biblioteca <a href="https://github.com/mainstringargs/alpha-vantage-scraper">AlphaVantage Scrapper</a>.
     * @param codigoEmpresa
     */
    private static void cotacaoUsandoAlphaVantage(String codigoEmpresa) { }

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://www.quandl.com">Quandl</a>
     * por meio da biblioteca <a href="http://quandl4j.org">quandl4j</a>.
     * @param codigoEmpresa
     */
    private static void cotacaoUsandoQuandl(String codigoEmpresa) {}
}
