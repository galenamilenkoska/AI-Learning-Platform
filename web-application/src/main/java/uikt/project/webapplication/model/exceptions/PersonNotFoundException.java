package uikt.project.webapplication.model.exceptions;

import uikt.project.webapplication.model.entities.base.Person;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(Person person)
    {
        super(String.format("Person %s was not found!", person.toString()));
    }
}

