package TechDetectives.HobbyFinder.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class UserAbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId(){
        return id;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAbstractEntity entity = (UserAbstractEntity) o;
        return id == entity.id;
    }
}
