package demili53.game.lolhaja.Exception;

public class ExceptionResult {
    public final String url;
    public final String ex;

    public ExceptionResult(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }
}


