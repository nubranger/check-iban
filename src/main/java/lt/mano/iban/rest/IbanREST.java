package lt.mano.iban.rest;
import lt.mano.iban.IBAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class IbanREST {

    @Autowired
    private IbanDaoService service;

    @GetMapping("/rest")
    public List<IBAN> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/rest/{number}")
    public IBAN restIBAN(@PathVariable String number) {
        return new IBAN(number);
    }

    @PostMapping("/rest")
    public void createIBAN(@RequestBody IBAN iban) {
        service.save(iban);
    }
}
