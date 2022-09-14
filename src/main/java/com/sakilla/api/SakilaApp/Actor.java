package com.sakilla.api.SakilaApp;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "actor")
public class Actor
{
    //attributes
    //defines the primary key
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;

    //constructors
    public Actor(int actorId, String firstName, String lastName)
    {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //create an empty object of itself
    public Actor(){}
    //methods

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorId == actor.actorId && Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName);
    }
}
