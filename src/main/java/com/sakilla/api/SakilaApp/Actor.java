package com.sakilla.api.SakilaApp;
import javax.persistence.*;


@Entity
@Table(name = "actor")
public class Actor
{
    //attributes
    //defines the primary key
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actor_id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;

    //constructors
    public Actor(int actor_id, String firstName, String lastName)
    {
        this.actor_id = actor_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //create an empty object of itself
    public Actor(){}
    //methods

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }
}
