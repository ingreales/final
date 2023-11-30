package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.service.CarService;
import co.edu.cue.finalproyect.service.LoanService;
import co.edu.cue.finalproyect.service.LoginService;
import co.edu.cue.finalproyect.service.PersonService;

public class RentCarServiceImpl {
    private final CarService carService;
    private final LoginService loginService;
    private final PersonService personService;
    private  final LoanService loanService;



    public RentCarServiceImpl() {
        this.loanService = new LoanServiceImpl();
        this.carService = new CarServiceImpl();
        this.loginService = (LoginService) new LoginServiceImpl();
        this.personService = new PersonServiceImpl();
    }

    public LoanService getLoanService() {
        return loanService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public CarService getCarService() {
        return carService;
    }

}
