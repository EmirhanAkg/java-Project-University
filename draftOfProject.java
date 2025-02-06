import java.util.Scanner;

public class draftOfProject {
    public static void main(String[] args){
        Scanner s =new Scanner(System.in);
        int n = 0;
        String mesaj = s.nextLine();
        String ekMesaj = "a";
        while (!(ekMesaj.equals(""))){ //Silinebilir
            ekMesaj = s.nextLine();
            mesaj += ekMesaj;
        }
        System.out.println(mesaj);
        n += zeroOneSayisi(mesaj);
        System.out.println(n); //SİLİNECEK
        String[] onezeroarray = new String[n];

        zeroOneStringWriter(onezeroarray, mesaj);

        int[] intZeroOne = new int[n];
        for (String c: onezeroarray) //SİLİNECEK
            System.out.print(c + " ");
        zeroOneIntWriter(onezeroarray, intZeroOne);

        System.out.println();
        int bosluk = 1;
        for (int c: intZeroOne) { //SİLİNECEK
            System.out.print(c + " ");
            if (bosluk % 8 == 0 )
                System.out.println();
            bosluk++;
        }

        int[] asciiNum;
        if (intZeroOne.length % 8 == 0){
            asciiNum = new int[intZeroOne.length / 8];
        }else {
            asciiNum = new int[intZeroOne.length / 8 + 1];
        }
        asciiConverter(intZeroOne, asciiNum);

        System.out.println();
        for (int c: asciiNum) //SİLİNECEK
            System.out.println(c);

        char[] asciiChar = new char[asciiNum.length];

        charConverter(asciiNum, asciiChar);
        for (char e: asciiChar)
            System.out.print(e);

    }
    public static int zeroOneSayisi(String mesaj){
        int a = 0;
        int num = 0;
        String eskimesaj = mesaj;
        for (int i = 0; i <= eskimesaj.length(); i++){
            mesaj = mesaj.substring(a);
            if (mesaj.contains("ZERO") && mesaj.contains("ONE")){
                num++;
                if (mesaj.indexOf("ZERO") < mesaj.indexOf("ONE")){
                    a = mesaj.indexOf("ZERO") + 4;
                } else
                    a = mesaj.indexOf("ONE") + 3;
            } else if (mesaj.contains("ZERO")) {
                num++;
                a= mesaj.indexOf("ZERO") + 4;
            } else if (mesaj.contains("ONE")) {
                num++;
                a = mesaj.indexOf("ONE") + 3;
            }else
            break;
        }
        return num;
    }
    public static void zeroOneStringWriter(String[] StringWriter, String mesaj){
        int a = 0;
        for (int i = 0; i < StringWriter.length; i++) {
            mesaj = mesaj.substring(a);
            if (mesaj.contains("ZERO") && mesaj.contains("ONE")) {
                if (mesaj.indexOf("ZERO") < mesaj.indexOf("ONE")) {
                    a = mesaj.indexOf("ZERO") + 4;
                    StringWriter[i] = "ZERO";
                } else {
                    a = mesaj.indexOf("ONE") + 3;
                    StringWriter[i] = "ONE";
                }
            } else if (mesaj.contains("ZERO")) {
                StringWriter[i] = "ZERO";
                a = mesaj.indexOf("ZERO") + 4;
            } else if (mesaj.contains("ONE")) {
                a = mesaj.indexOf("ONE") + 3;
                StringWriter[i] = "ONE";
            } else
                break;
        }
    }
    public static void zeroOneIntWriter(String[] intWriter,int[] intZeroOne){
        for (int i = 0; i < intWriter.length; i++){
            if (intWriter[i].equals("ZERO")){
                intZeroOne[i] = 0;
            }else
                intZeroOne[i] = 1;
        }
    }
    public static void asciiConverter(int[] intZeroOne, int[] asciiNum){
        int controller = intZeroOne.length % 8;
        int sum = 0;
        int digit = 7;
        int count = 1;
        int indexofascii = 0;
        for (int i = 0; i < intZeroOne.length; i++){
            sum += (int) (Math.pow(2, digit)) * intZeroOne[i];

            if (digit == 0 || controller == count){
                asciiNum[indexofascii] = sum;
                digit = 8;
                count++;
                indexofascii++;
                sum = 0;
            }
            digit--;
            count++;
        }
    }
    public static void charConverter(int[] asciiNum, char[] asciiChar){
      for (int i = 0; i < asciiNum.length; i++){
          switch (asciiNum[i]){
              case 52: asciiChar[i] = 'A'; break;
              case 56: asciiChar[i] = 'B'; break;
              case 51: asciiChar[i] = 'E'; break;
              case 54,57: asciiChar[i] = 'G'; break;
              case 49: asciiChar[i] = 'I'; break;
              case 48: asciiChar[i] = 'O'; break;
              case 50,55: asciiChar[i] = 'Z'; break;
              default:
                  asciiChar[i] = (char) asciiNum[i];
          }
      }
    }
}
