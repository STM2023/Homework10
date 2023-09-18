import java.io.*;
import java.util.Arrays;
public class Task3 {

        public static void main(String[] args) {
        StringBuffer s=new StringBuffer();
        String filePath="words.txt";
        try (FileReader reader = new FileReader(filePath)) {
            int c;
            while ((c = reader.read()) != -1) {
                s.append((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("считали из файла: "+filePath);
        System.out.print(s);
        String[] arrWords = split(s.toString());
        System.out.println("---------------------------");
        System.out.println("преобразовали в массив: ");
        System.out.println(Arrays.toString(arrWords));
        System.out.println("===========================");

        changeArr(arrWords);
    }

    public static String[] split(String phrase){
        // извлекаем слова из строки и помещаем в массив
        String line = phrase.trim().toLowerCase();
        int j=0;
        int k=0;
        int l=0;
        int ll=line.length();
        int f = 0;
        String[] words=new String [ll];

        for (int i=0;i<= line.length()-1;i++){
            if ((line.charAt(i)==' '||line.charAt(i)=='\n' )&& f==0 ){
                words[j]=line.substring(k,l+1);
                j++;
                f++;

            }else if( line.charAt(i)!=' ' && f>0 ){
                f=0;
                k=i;
                l=i;

            } else if(line.charAt(i)!=' ' && f==0) {
                l++;
            }

        }
        words[j]=line.substring(k,l+1);
        String[] words1=new String [j+1];
        for(int i=0; i<j+1;i++){
            words1[i]=words[i].strip();
        }
        return words1;
    }

    public static void changeArr(String[] words){
        //  обрабатываем массив слов - подсчитываем количество вхождений каждого слова

        int[] countWord = new int[words.length];
        String [] newWords =new String[words.length];
        for(int j=0;j<=newWords.length-1;j++){
            newWords[j] ="";
            countWord[j] =0;
        }
        int j=0;
        boolean flag= true;
        for(int i=0;i<= words.length-1;i++){
            j=0;
            flag= true;
            while(flag){
                if(newWords[j].equals(words[i]) ) {
                    countWord[j]++;
                    flag=false;
                }
                if(newWords[j] ==""&& flag==true){
                    newWords[j] = words[i];
                    countWord[j]++;
                    flag=false;
                }
                j++;
            }
        }
        //      System.out.println(Arrays.toString(newWords));
        //      System.out.println(Arrays.toString(countWord));
        sortWords(newWords,countWord);
    }

    public static void sortWords(String[] words, int[] countWords){
        //сортировка по убыванию
        boolean isSorted=false;
        int buf;
        String wordBuf="";
        while(!isSorted){
            isSorted=true;
            for( int i=0; i<countWords.length-1;i++){
                if (countWords[i] < countWords[i+1]) {
                    isSorted=false;
                    buf=countWords[i];
                    wordBuf=words[i];

                    countWords[i]=countWords[i+1];
                    words[i]=words[i+1];

                    countWords[i+1]=buf;
                    words[i+1]=wordBuf;

                }
            }
        }
        // System.out.println(Arrays.toString(words));
        // System.out.println(Arrays.toString(countWords));
        System.out.println("получили после обработки: ");
        for(int i=0; i<=countWords.length-1;i++){
            if(countWords[i]!=0){
                System.out.println(words[i]+" "+countWords[i]);
            }
        }
    }

}
