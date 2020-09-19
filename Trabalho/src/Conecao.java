
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.connection.Connection;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;


/**
 *
 * @author Gustavo Matos
 */
public class Conecao {
    DB BaseDados;
    DBCollection colecao;
    BasicDBObject Document = new BasicDBObject();
    
    public Conecao()
    {
        try{
            Mongo mongo = new Mongo ("localhost" , 27017);
            BaseDados = mongo.getDB("AulaMongo");
            colecao = BaseDados.getCollection("Aluno");
            System.out.println("Conexão realizada com sucesso");
            
            
        }catch (UnknownHostException ex) {
                Logger.getLogger(Conecao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean inserir(String hash, String id, String nome, String esfera)
    {
        Document.put("@hash:" , hash);
        Document.put("@id:" , id);
        Document.put("nome:" , nome);
        Document.put("esfera:" , esfera);
        colecao.insert(Document);
        return true;
    }
    public void mostrar(){
        DBCursor cursor = colecao.find();
        while(cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
    }
    public boolean atualizar(String dadoAntigo , String dadoNovo){
        Document.put("RA", dadoAntigo);
        BasicDBObject DocNovo = new BasicDBObject();
        DocNovo.put("RA", dadoNovo);
        colecao.findAndModify(Document, DocNovo);
        return true;
    }
    public boolean remover(String dado)
    {
        Document.put("RA", dado);
        colecao.remove(Document);
        return true;
    }
}
            
