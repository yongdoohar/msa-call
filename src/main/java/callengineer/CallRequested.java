package callengineer;


public class CallRequested extends AbstractEvent {

    private Long id;
    private Long engineerId;
    private String address;

    public CallRequested(){
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
    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = address;
    }
}
