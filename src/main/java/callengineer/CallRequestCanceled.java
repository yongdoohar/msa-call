package callengineer;


public class CallRequestCanceled extends AbstractEvent {

    private Long id;
    private Long engineerId;

    public CallRequestCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }
    public Long getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(Long EngineerId) {
        this.engineerId = engineerId;
    }
}
