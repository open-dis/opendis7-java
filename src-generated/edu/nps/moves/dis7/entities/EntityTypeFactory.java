package edu.nps.moves.dis7.entities;

import edu.nps.moves.dis7.pdus.EntityType;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/** Utility class */
public class EntityTypeFactory
{
  private static Map<Integer,String> uid2ClassNameMap = new HashMap<>();
  static {
    try (InputStream ins = EntityTypeFactory.class.getResourceAsStream("uid2EntityClass.properties")) {
      Properties prop = new Properties();
      prop.load(ins);
      prop.entrySet().stream().forEach(e->uid2ClassNameMap.put(Integer.parseInt(e.getKey().toString()), e.getValue().toString()));
    }
    catch( IOException ex) {
      throw new RuntimeException (ex);
    }
  }

  /** Entity creation
   * @param uid unique identifier
   * @return EntityType of interest
   */
  @SuppressWarnings("unchecked") // TODO apparently unavoidable?
  public static EntityType makeEntity(int uid)
  {
    String name = uid2ClassNameMap.get(uid);
    if(name==null)
      return null;

    try {
      Class<?> cls = Class.forName(name);
      Constructor<EntityType> constr = (Constructor<EntityType>) cls.getConstructors()[0];
      return constr.newInstance();
    }
    catch(ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
      System.err.println(name+"(uid "+uid+") could not be instantiated. Check for proper entity jar(s) on classpath.");
      return null;
    }
  }
}
