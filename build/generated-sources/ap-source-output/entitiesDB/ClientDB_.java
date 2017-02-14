package entitiesDB;

import entitiesDB.ContDB;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-14T22:54:31")
@StaticMetamodel(ClientDB.class)
public class ClientDB_ { 

    public static volatile SingularAttribute<ClientDB, String> cnp;
    public static volatile SingularAttribute<ClientDB, String> prenume;
    public static volatile SingularAttribute<ClientDB, Integer> id;
    public static volatile CollectionAttribute<ClientDB, ContDB> contDBCollection;
    public static volatile SingularAttribute<ClientDB, String> nume;

}