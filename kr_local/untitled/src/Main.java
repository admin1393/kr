import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);

        // Ввод начальных данных
        System.out.print("Введите ключ (максимум 10): ");
        int key = sc.nextInt();
        if (key > 10){
            System.out.println("Максимум 10).\nДавайте еще раз: ");
            key = sc.nextInt();
            if (key > 10){
                System.out.println("гг я ливаю");
                return;
            }
        }
        System.out.print("Введите слово: ");
        String sl = sc.next();
        char[] m = sl.toCharArray();

        // Работа функции
//        shifr(m,key);
        int choize = 0;
        System.out.print("1)Расшивровать слово\n2)Зашивровать слово\n");
        System.out.print("Выберите операцию(число): ");
        choize = sc.nextInt();
        if(choize == 1){
            System.out.println(de_shifr(m, key));
        } else if (choize == 2) {
            System.out.println(shifr(m,key));
        }
    }

    public static char[] shifr(char[] m, int key){
        // Создаю целый алфавит для дальньешего его использования
        char[] alf = new char[]{'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м',
                                'н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ',
                                'ь','ы','э','ю','я'};


        int poz = 0;
        char[] shifr_m = new char[m.length];
        for(int i = 0; i < m.length; i++){
            // В этом цикле я нахожу позиции всех букв в слове в общем алфавите
            for(int j = 0; j < alf.length; j++){
                if(m[i] == alf[j]){
                    poz = j;
                    break;
                }
            }
//            System.out.println(m[i]+" позиция в алфавите: "+poz);

            // Тут я в новый массив кладу уже те буквы которые должны быть по условию шифра
            if (poz+key < alf.length && poz+key > 0) {
                shifr_m[i] = alf[poz + key];
            } else if (poz+key > alf.length) {
                shifr_m[i] = alf[0+((poz+key)-33)];
            } else if (poz+key < 0) {
                shifr_m[i] = alf[(33+(poz+key))];
            }
        }

        System.out.print("Зашифрованное сообщение -> ");
        return shifr_m;
    }

    public static char[] de_shifr(char[] m, int key){
        char[] deshifr_m = new char[m.length];

        char[] alf = new char[]{'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м',
                'н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ',
                'ь','ы','э','ю','я'};


        int poz = 0;
        for(int i = 0; i < m.length; i++){
            // В этом цикле я нахожу позиции всех букв в слове в общем алфавите
            for(int j = 0; j < alf.length; j++){
                if(m[i] == alf[j]){
                    poz = j;
                    break;
                }
            }
//            System.out.println(m[i]+" позиция в алфавите: "+poz);

            // Тут я в новый массив кладу уже те буквы которые должны быть по условию шифра
            if ( poz-key > 0 && poz-key < alf.length) {
                deshifr_m[i] = alf[poz - key];
            } else if (poz-key < 0) {
                deshifr_m[i] = alf[(33+(poz-key))];
            } else if(key < 0 && (poz-(Math.abs(key))) < 0){
                deshifr_m[i] = alf[(33+(poz-Math.abs(key)))];
            }
        }

        System.out.print("Расшифрованное сообщение -> ");

        return deshifr_m;
    }
}