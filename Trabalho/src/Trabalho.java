

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *
 * @author Gustavo Matos
 */
public class Trabalho {

    public static void main(String[] args) throws IOException {
        
       // Mongo mongo = new Mongo("localhost", 27017); 
        //DB db = mongo.getDB("sakilla");
        //DBCollection collection = db.getCollection("tabela");
        
        Conecao conexao = new Conecao();
        //conexao.inserir("ola");
        String json = String.join(" ",Files.readAllLines
                                        (Paths.get("./ficheiroJson.json"),
                                         StandardCharsets.UTF_8));
        
        
        
        DBObject dbObject = (DBObject) JSON.parse(json);                   
        DBObject agenda = (DBObject) dbObject.get("agenda");      
        String oi = String.valueOf(agenda);
        DBObject dbObject1 = (DBObject) JSON.parse(oi);
        String parts[] = oi.split(",");
        String id = parts[1];
        String nome = parts[2];
        String esfera = parts[3];
        String completa = parts[0];
        String a = completa.replace("{","");
        String b = a.replace("[","");
        String hash = b;
        
        conexao.inserir(hash, id, nome, esfera);
        System.out.println(hash + id + nome + esfera);
        
    }}
    
        
    
   
    
    
