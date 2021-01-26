public class YahooAdpter implements ConsultaAcao{
    ConsultarYahoo yahoo;

    public YahooAdpter(ConsultarYahoo yahoo) {
        this.yahoo = yahoo;
    }

    @Override
    public void consultarAcaoTodas(String c) {
        c = c+".SA";
        yahoo.consultar(c);
    }


}
