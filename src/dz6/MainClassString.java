package dz6;

/**
 * Created by vgoryachev on 17.01.2018.
 * Package: dz6.
 */
class MainClassString {
    public static void main(String[] args) {

        String str1 = " Предложение один    Теперь предложение два     Предложение три";
        System.out.println(str1);

        String str2 = str1.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);

        for(int i = 1; i < str2.length(); i++) {
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я') {
                stringBuilder.setCharAt(i-1, '.');
            }
        }

        System.out.println(stringBuilder.toString());

    }
}


// задание привести строку к нормальному ввиду