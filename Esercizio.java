//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    //Creo l'oggetto per l'input da tastiera
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();

    // Il programma parte con una chiamata a main().
    public static void main(String args[]) {
        int n, i, j, coppie, cornici;
        boolean coppiaTrovata, continuaRicerca;

        do {
            System.out.println("Quanti listelli ci sono nella cassettiera?");
            n = Integer.parseInt( input.nextLine() );
        } while (n <= 0);
        int[] v = new int[n];

        i = 0;
        while (i <= n - 1) {
            v[i] = 4 + random.nextInt(7);
            i = i + 1;
        }
        visualizzaVettore(v, n);

        // Trovo le coppie nel vettore. Ogni volta che trovo una coppia la elimino dal vettore. Mi fermo quando il vettore ha meno di 2 elementi oppure non trovo più coppie.
        coppie = 0;
        continuaRicerca = true;
        while (n >= 2 && continuaRicerca) {
            // Non appena trovo una coppia per l'elemento i, interrompo la ricerca.
            coppiaTrovata = false;
            i = 0;
            while (i <= n - 2 && coppiaTrovata == false) {
                j = i + 1;
                while (j <= n - 1 && coppiaTrovata == false) {
                    if (v[i] == v[j]) {
                        System.out.println("Coppia: " + v[i] + " - " + v[j]);
                        // conto la coppia e la elimino dal vettore
                        coppie = coppie + 1;
                        coppiaTrovata = true;
                        n = eliminaElemento(v, n, j);
                    } else {
                        j = j + 1;
                    }
                }
                if (coppiaTrovata) {
                    // Elimino la coppia, riparte la ricerca della nuova coppia
                    n = eliminaElemento(v, n, i);
                } else {
                    i = i + 1;
                }
            }

            // Se non ho trovato coppie, gli elementi restanti sono tutti distinti, quindi non proseguo oltre con la ricerca di coppie.
            continuaRicerca = coppiaTrovata;
        }
        cornici = coppie / 2;
        System.out.println("Si possono produrre " + cornici + " cornici.");
        System.out.println("Listelli non accoppiati:");
        visualizzaVettore(v, n);
    }

    public static int eliminaElemento(int[] v, int n, int ie) {
        int i, n2;

        n2 = n - 1;
        i = ie;
        while (i <= n - 2) {
            v[i] = v[i + 1];
            i = i + 1;
        }
        
        return n2;
    }
    
    public static void visualizzaVettore(int[] v, int n) {
        int i;

        i = 0;
        while (i < n) {
            System.out.println("[" + i + "]: " + v[i]);
            i = i + 1;
        }
    }


}

