package Clients;

import java.util.Date;

public class ClientBuilder extends Builder{
    Client owner = new Client();

    @Override
    public void SetFullName(Name fullName){
        owner.FullName = fullName;
    }

    @Override
    public void SetPassport(Passport passport){
        owner.Passport = passport;
    }
    @Override
    public void SetBirthDay(Date birth){
        owner.BirthDay = birth;
    }
    @Override
    public Client GetResult(){
        return owner;
    }
}
