public class SetAnswered extends Set{
    private boolean isSuccess;

    

    SetAnswered(Set set, boolean isSuccess){
        super(set.getPlayer(), set.getSet(), set.getFirstCard(), set.getSecondCard(), set.getThirdCard(), set.getFourthCard(), set.getFifthCard(), set.getSixthCard());
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}