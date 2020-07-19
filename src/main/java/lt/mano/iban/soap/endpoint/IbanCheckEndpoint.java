package lt.mano.iban.soap.endpoint;

import lt.mano.iban.soap.GetIbanCheckRequest;
import lt.mano.iban.soap.GetIbanCheckResponse;
import lt.mano.iban.soap.IbanCheck;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint

public class IbanCheckEndpoint {

    @PayloadRoot(namespace = "http://iban.mano.lt/soap", localPart = "GetIbanCheckRequest")

    @ResponsePayload

    public GetIbanCheckResponse processIbanCheckRequest(@RequestPayload GetIbanCheckRequest request) {

        GetIbanCheckResponse response = new GetIbanCheckResponse();

        IbanCheck ibanCheck = new IbanCheck();

        ibanCheck.setNumberIBAN(request.getNumberIBAN());

        ibanCheck.isStatusIBAN();

        response.setIbanCheck(ibanCheck);

        return response;

    }

}
