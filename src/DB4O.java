import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;


public class DB4O {
    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "PruebaDB402.yap");

        AlumnoCFGS a = new AlumnoCFGS();
        AlumnoCFGS b = new AlumnoCFGS();
        ObjectSet result = db.queryByExample(a);
        ObjectSet result2 = db.queryByExample(b);

        while (result.hasNext()) db.delete(result.next());

        String[] nombre = {"Juan", "María", "Pedro", "Ana", "Luis", "Marta"};
        byte[] edad = {20, 25, 18, 22, 30, 27};
        byte[] noGrupo = {1, 1, 2, 2, 3, 3};
        float[] alturaAproxEnM = {1.70f, 1.65f, 1.80f, 1.75f, 1.60f, 1.70f};
        boolean[] juegaConsola = {true, true, false, true, false, true};
        Long[] horasEnLOL = {300L, 500L, 200L, 100L, 0L, 400L};
        String[] juegosFavorito = {"Minecraft", "League of Legends", "Call of Duty", "FIFA", "The Legend of Zelda", "Animal Crossing"};
        for (int i = 0; i < nombre.length; i++)
            db.store(new AlumnoCFGS(nombre[i], edad[i], noGrupo[i], alturaAproxEnM[i], juegaConsola[i], horasEnLOL[i], juegosFavorito[i]));

        /*
        tanto los que tenga tu nombre como los que no jueguen en consola
         */
        Query query = db.query();
        query.descend("nombre").constrain("Luis").or(query.descend("juegaConsola").constrain(false));
        ObjectSet<AlumnoCFGS>result3 = query.execute();
        while (result3.hasNext()) System.out.println(result3.next());
        db.close();
    }
}
