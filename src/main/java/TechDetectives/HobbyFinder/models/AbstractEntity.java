package TechDetectives.HobbyFinder.models;


//MappedSuperclass behaves similarly to the entity annotation but the class itself
//does not map anything to a table in the database but only its subclasses/classes
//that extend this class. This will be implemented once the database is set up.

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

    //Id will be used to indicate that the variable below is the primary key.

    //GeneratedValue is used to assign a value to each primary key, a number that has not
    //already been used.

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
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }
}
