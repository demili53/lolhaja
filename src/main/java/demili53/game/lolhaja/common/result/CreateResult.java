package demili53.game.lolhaja.common.result;



public class CreateResult {

    public enum ResultCase{
        DUPLICATE
    }
    private boolean result;
    private ResultCase resultCase;
    private Object createdData;
    public CreateResult(boolean result,Object createdData,ResultCase resultCase) {
        this.result = result;
        this.resultCase = resultCase;
        this.createdData = createdData;
    }

    public boolean isResult() {
        return result;
    }

    public ResultCase getResultCase() {
        return resultCase;
    }

    public Object getCreatedData() {
        return createdData;
    }
}
