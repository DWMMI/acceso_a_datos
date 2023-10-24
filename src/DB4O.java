import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4O {
    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "PruebaDB402.yap");
        AlumnoCFGS a = new AlumnoCFGS();
        ObjectSet result = db.queryByExample(a);
        while (result.hasNext()) db.delete(result.next());

        String[] nombre = {"Juan", "María", "Pedro", "Ana", "Luis", "Marta"};
        byte[] edad = {20, 25, 18, 22, 30, 27};
        byte[] noGrupo = {1, 2, 3, 4, 5, 6};
        float[] alturaAproxEnM = {1.70f, 1.65f, 1.80f, 1.75f, 1.60f, 1.70f};
        boolean[] juegaConsola = {true, true, false, true, false, true};
        Long[] horasEnLOL = {300L, 500L, 200L, 100L, 0L, 400L};
        String[] juegosFavorito = {"Minecraft", "League of Legends", "Call of Duty", "FIFA", "The Legend of Zelda", "Animal Crossing"};

        a.setJuegaEnConsola(true);
        result = db.queryByExample(a);
        System.out.println("La query ha devuelto " + result.size() + " alumnos");
        while (result.hasNext()) db.delete(result.next());
        result = db.queryByExample(a);
        System.out.println("Tras la eliminación, quedan " + result.size() + " alumnos que cumpla la query");
        db.close();

    }
}
