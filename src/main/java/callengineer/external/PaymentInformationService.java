package callengineer.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

// @FeignClient(name="payment", url="http://user12-payment:8080")
@FeignClient(name="payment", url="http://localhost:8083")
public interface PaymentInformationService {
    @RequestMapping(method= RequestMethod.GET, path="/paymentInformations")
    public void paymentRequest(@RequestBody PaymentInformation paymentInformation);

}

