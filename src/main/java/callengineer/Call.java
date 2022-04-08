package callengineer;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Entity
@Table(name = "Call_table")
public class Call  {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long engineerId;

    private String address;

    private String engineerStatus;


    @PostPersist
    public void onPostPersist(){
        CallRequested callRequested = new CallRequested();
        BeanUtils.copyProperties(this, callRequested);
        System.out.println("\n\n##### callRequested.toJson() : " + callRequested.toJson() + "\n\n");
        callRequested.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        callengineer.external.PaymentInformation paymentInformation = new callengineer.external.PaymentInformation();

        paymentInformation.setCallId(this.getId());
        paymentInformation.setStatus("1");
        // mappings goes here
        CallApplication.applicationContext.getBean(callengineer.external.PaymentInformationService.class)
            .paymentRequest(paymentInformation);

    }

    @PostUpdate
    public void onPostUpdate(){
        CallRequestCanceled callRequestCanceled = new CallRequestCanceled();

        callRequestCanceled.setEngineerId(this.getEngineerId());
        BeanUtils.copyProperties(this, callRequestCanceled);
        callRequestCanceled.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(Long engineerId) {
        this.engineerId = engineerId;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getEngineerStatus() {
        return engineerStatus;
    }

    public void setEngineerStatus(String engineerStatus) {
        this.engineerStatus = engineerStatus;
    }
    



}
