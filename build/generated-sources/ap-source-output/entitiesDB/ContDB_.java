package entitiesDB;

import entitiesDB.ClientDB;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-14T22:54:31")
@StaticMetamodel(ContDB.class)
public class ContDB_ { 

    public static volatile SingularAttribute<ContDB, Double> sold;
    public static volatile SingularAttribute<ContDB, String> descriere;
    public static volatile SingularAttribute<ContDB, String> iban;
    public static volatile SingularAttribute<ContDB, Boolean> active;
    public static volatile SingularAttribute<ContDB, ClientDB> client;
    public static volatile SingularAttribute<ContDB, Integer> id;
    public static volatile SingularAttribute<ContDB, String> creationDate;

}