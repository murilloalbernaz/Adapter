public class AlphaVantageAdpter implements ConsultaAcao{
    ConsultarAlphaVantage p;

    public AlphaVantageAdpter(ConsultarAlphaVantage p) {
        this.p = p;
    }

    @Override
    public void consultarAcaoTodas(String c) {
        p.Pesquisar(c);
    }
}
