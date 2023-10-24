import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

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
        a.setJuegaEnConsola(true);
        result = db.queryByExample(a);
        System.out.println("La query ha devuelto " + result.size() + " alumnos");
        while (result.hasNext()) db.delete(result.next());
        result = db.queryByExample(a);
        System.out.println("Tras la eliminación, quedan " + result.size() + " alumnos que cumpla la query");
        db.close();
        */
        /*
        a.setNoGrupo((byte)3);
        b.setNoGrupo((byte)2);
        result = db.queryByExample(a);
        result2 = db.queryByExample(b);
        System.out.println("La query ha devuelto " + (result.size())+(result2.size()) + " alumnos");
        while (result.hasNext()) System.out.println(result.next());
        while (result2.hasNext()) System.out.println(result2.next());
        db.close();
         */

        
    }
}
