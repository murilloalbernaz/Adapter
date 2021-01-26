public class QuandlAdpter implements ConsultaAcao{
    ConsutarQuandl quand;

    public QuandlAdpter(ConsutarQuandl c) {
        this.quand = c;
    }

    @Override
    public void consultarAcaoTodas(String c) {
        c = "WIKI/"+c;
        quand.Pesquisar(c);
    }
}
