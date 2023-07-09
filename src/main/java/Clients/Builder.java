package Clients;

import java.util.Date;

abstract class Builder {
    public abstract void SetFullName(Name fullName);
    public abstract void SetPassport(Passport passport);
    public abstract void SetBirthDay(Date birth);
    public abstract Client GetResult();
}
